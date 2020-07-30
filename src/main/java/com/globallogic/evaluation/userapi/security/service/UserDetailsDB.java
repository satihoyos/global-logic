package com.globallogic.evaluation.userapi.security.service;

import com.globallogic.evaluation.userapi.dao.UserDAO;
import com.globallogic.evaluation.userapi.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


/**
 * Created by sati on 29-07-20.
 */
@Service
public class UserDetailsDB implements UserDetailsService{

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private ConversionService conversionService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity user = userDAO.findByEmail(email);
        return conversionService.convert(user,UserDetails.class);
    }
}
