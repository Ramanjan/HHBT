package com.engx.bt.contollers;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.engx.bt.common.HhbtServiceURI;
import com.engx.bt.service.UserService;
import com.engx.bt.transferobjects.AuthenticateUserTo;

/**
 * Title : UserController.java. Description : This is a user controller.
 * Copyright : ENGX-TechBullets (c) 2016 Company : EPAM Solutions.
 *
 * @author : rvaddi
 * @version : 0.1
 */

@RestController
@RequestMapping(HhbtServiceURI.AUTHENTICATE)
public class AuthenticateController {

    /**
     * userService.
     */
    @Autowired
    private transient UserService userService;

    /**
     * @param userAuthentication
     *            userAuthentication
     * @param request
     *            request
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public final Map validateCredential(
            @RequestBody final AuthenticateUserTo userAuthentication,
            final HttpServletRequest request)  {
                return null;

    }

}