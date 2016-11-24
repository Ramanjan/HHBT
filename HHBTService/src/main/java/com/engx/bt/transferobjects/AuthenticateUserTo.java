package com.engx.bt.transferobjects;

/**
 * Title : AuthenticateUserTo.java. Description : This class is used to
 * transfer the user credentials from UI to controller and vice versa.
 * Copyright : ENGX-TechBullets (c) 2016 Company : EPAM Solutions.
 *
 * @author : rvaddi
 * @version : 0.1
 */
public class AuthenticateUserTo {

    /**
     * userId.
     */
    private int userId;

    /**
     * userEmailId.
     */
    private String userEmailId;

    /**
     * userPassword.
     */
    private String userPassword;

    /**
     * userTokenId.
     */
    private String userTokenId;

    /**
     * @return the userEmailId
     */
    public final String getUserEmailId() {
        return userEmailId;
    }

    /**
     * @return the userId
     */
    public final int getUserId() {
        return userId;
    }

    /**
     * @return the userPassword
     */
    public final String getUserPassword() {
        return userPassword;
    }

    /**
     * @return the userTokenId
     */
    public final String getUserTokenId() {
        return userTokenId;
    }

    /**
     * @param userEmailId
     *            the userEmailId to set
     */
    public final void setUserEmailId(final String userEmailId) {
        this.userEmailId = userEmailId;
    }

    /**
     * @param userId
     *            the userId to set
     */
    public final void setUserId(final int userId) {
        this.userId = userId;
    }

    /**
     * @param userPassword
     *            the userPassword to set
     */
    public final void setUserPassword(final String userPassword) {
        this.userPassword = userPassword;
    }

    /**
     * @param userTokenId
     *            the userTokenId to set
     */
    public final void setUserTokenId(final String userTokenId) {
        this.userTokenId = userTokenId;
    }

}