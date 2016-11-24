package com.engx.bt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.engx.bt.model.User;

/**
 * Title : UserRepository.java. Description : This is a UserRepository
 * interface interacts with user table. Copyright : ENGX-TechBullets (c)
 * 2016 Company : EPAM Solutions.
 *
 * @author : rvaddi
 * @version : 0.1
 */

public interface UserRepository extends JpaRepository<User, Integer> {

    /**
     * This method is used for get the user object using .
     *
     * @param emailId
     *            emailId
     * @return User
     */
    @Query("select u from User u where lower(u.emailId) = lower(?1)")
    User findUserByEmailId(String emailId);

}