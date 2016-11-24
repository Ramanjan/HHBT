package com.engx.bt.common;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Java File. Title : HhbtTokenGenerator.java Description : This class is
 * used to generate new token, encrypt and decrypt the token. Copyright :
 * ENGX-TechBullets (c) 2016 Company : EPAM Solutions.
 *
 * @author : rvaddi
 * @version : 0.1
 */
public final class HhbtTokenGenerator {
    /**
     * This method used for createToken. Token creation.
     *
     * @return result
     */
    public static String createToken() {
        final UUID token = UUID.randomUUID();
        LOGGER.info("Token Id:" + token);
        return String.valueOf(token);
    }

    /**
     * This method used for decryptToken. Token decryption
     *
     * @param token
     *            token
     * @return data
     */
    public static String decryptToken(final String token) {
        return HhbtEncryption.decrypt(token, SALT);
    }

    /**
     * This method used for encryptToken. Token encryption
     *
     * @param token
     *            token
     * @return data
     */
    public static String encryptToken(final String token) {
        return HhbtEncryption.encrypt(token, SALT);
    }

    /**
     * LOGGER.
     */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(HhbtTokenGenerator.class);

    /**
     * SALT.
     */
    private static final String SALT = "xaft";

    /**
     * private constructor.
     */
    private HhbtTokenGenerator() {

    }

}
