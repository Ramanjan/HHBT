package com.engx.bt.service;

import com.engx.bt.exception.HhbtBaseException;
import com.engx.bt.transferobjects.AuthenticateUserTo;

/**
 * Title : AuthenticateService.java. Description : This interface have
 * methods to authenticate user. Copyright : ENGX-TechBullets (c) 2016
 * Company : EPAM Solutions.
 *
 * @author : rvaddi
 * @version : 0.1
 */

public interface AuthenticateService {

    AuthenticateUserTo validateUserCredentials(AuthenticateUserTo auth)
            throws HhbtBaseException;

}