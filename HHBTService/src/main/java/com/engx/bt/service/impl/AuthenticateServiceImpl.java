package com.engx.bt.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.engx.bt.common.HhbtEncryption;
import com.engx.bt.common.HhbtTokenGenerator;
import com.engx.bt.exception.HhbtBaseException;
import com.engx.bt.model.User;
import com.engx.bt.repository.UserRepository;
import com.engx.bt.service.AuthenticateService;
import com.engx.bt.transferobjects.AuthenticateUserTo;

/**
 * Title : AuthenticateServiceImpl.java. Description : This is a
 * implementation class of AuthenticateService. Copyright :
 * ENGX-TechBullets (c) 2016 Company : EPAM Solutions.
 *
 * @author : rvaddi
 * @version : 0.1
 */

public class AuthenticateServiceImpl implements AuthenticateService {

    /**
     * userRepository.
     */
    @Autowired
    private transient UserRepository userRepository;

    /**
     * @param AuthenticateUserTo
     *            AuthenticateUserTo
     * @return AuthenticateUserTo
     * @throws HhbtBaseException.
     */
    @Override
    public AuthenticateUserTo validateUserCredentials(
            final AuthenticateUserTo authenticateUserTo)
            throws HhbtBaseException {
        final User user =
                userRepository.findUserByEmailId(authenticateUserTo
                        .getUserEmailId());
        if (user != null) {
            final String decryptedPassword =
                    HhbtEncryption.decrypt(user.getPassword(),
                            user.getSalt());
            if (decryptedPassword.equalsIgnoreCase(authenticateUserTo
                    .getUserPassword())) {
                final String tokenId = HhbtTokenGenerator.createToken();
                authenticateUserTo.setUserId(user.getEmpId());
                authenticateUserTo.setUserTokenId(HhbtTokenGenerator
                        .encryptToken(tokenId));
            } else {
                throw new HhbtBaseException("Invalid Credentials");
            }
        } else {
            throw new HhbtBaseException("Invalid Credentials");
        }
        return authenticateUserTo;
    }

}