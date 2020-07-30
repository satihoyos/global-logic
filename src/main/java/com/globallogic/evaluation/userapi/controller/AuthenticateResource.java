package com.globallogic.evaluation.userapi.controller;

import com.globallogic.evaluation.userapi.dao.UserDAO;
import com.globallogic.evaluation.userapi.entity.UserEntity;
import com.globallogic.evaluation.userapi.model.AuthenticationRq;
import com.globallogic.evaluation.userapi.model.AuthenticationRs;
import com.globallogic.evaluation.userapi.security.exception.AuthenticationException;
import com.globallogic.evaluation.userapi.security.service.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Objects;

/**
 * Created by sati on 30-07-20.
 */
@RestController
public class AuthenticateResource {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsDB;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserDAO userDAO;


    @PostMapping("${jwt.get.token.uri}")
    public ResponseEntity<AuthenticationRs>auth(@RequestBody AuthenticationRq rq) throws AuthenticationException {
        this.authenticate(rq.getUsername(), rq.getPassword());
        UserDetails userDetails = userDetailsDB.loadUserByUsername(rq.getUsername());
        String token = jwtTokenUtil.generateToken(userDetails);
        UserEntity user = userDAO.findByEmail(rq.getUsername());
        user.setLastLogin(new Date());
        userDAO.save(user);
        return ResponseEntity.ok(new AuthenticationRs(token));
    }

    private void authenticate(String username, String password) {
        Objects.requireNonNull(username);
        Objects.requireNonNull(password);

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new AuthenticationException("Usuario inactivo", e);
        } catch (BadCredentialsException e) {
            throw new AuthenticationException("usuario o password incorrecto", e);
        }
    }
}
