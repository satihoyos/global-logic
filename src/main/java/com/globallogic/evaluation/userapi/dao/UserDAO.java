package com.globallogic.evaluation.userapi.dao;

import com.globallogic.evaluation.userapi.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by sati on 29-07-20.
 */
@Repository
public interface UserDAO extends JpaRepository<UserEntity,Long>{
    UserEntity findByEmail(String email);
}
