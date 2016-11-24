package com.engx.bt.controllers;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.engx.bt.common.HhbtCommonUtil;
import com.engx.bt.common.HhbtServiceURI;
import com.engx.bt.constants.HHBTConstants;
import com.engx.bt.exception.HhbtBaseException;
import com.engx.bt.service.AuthenticateService;
import com.engx.bt.transferobjects.AuthenticateUserTo;

/**
 * Title : AuthenticateController.java. Description : This is a
 * authenticate controller. Copyright : ENGX-TechBullets (c) 2016 Company :
 * EPAM Solutions.
 *
 * @author : rvaddi
 * @version : 0.1
 */

@RestController
@RequestMapping(HhbtServiceURI.AUTHENTICATE)
public class AuthenticateController {

    /**
     * authenticateService.
     */
    @Autowired
    private transient AuthenticateService authenticateService;

    /**
     * @param userAuthentication
     *            userAuthentication
     * @param request
     *            request
     * @return
     * @throws HhbtBaseException
     */
    @RequestMapping(method = RequestMethod.POST)
    public final Map<String, Object> validateCredential(
            @RequestBody final AuthenticateUserTo userAuthentication,
            final HttpServletRequest request) throws HhbtBaseException {
        return HhbtCommonUtil.getSuccessResponseMap(authenticateService
                .validateUserCredentials(userAuthentication),
                HHBTConstants.DEFAULT_SUCCESS_MESSAGE);
    }

}