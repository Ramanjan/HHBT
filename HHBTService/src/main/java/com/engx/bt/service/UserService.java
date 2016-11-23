package com.engx.bt.service;

import com.engx.bt.transferobjects.AuthenticateUserTo;

/**
 * Title : UserService.java. Description : This interface have
 * all methods to perform actions by user.
 * Copyright : ENGX-TechBullets (c) 2016 Company : EPAM Solutions.
 *
 * @author : rvaddi
 * @version : 0.1
 */

public interface UserService {

	AuthenticateUserTo validateUserCredentials(AuthenticateUserTo auth);

}