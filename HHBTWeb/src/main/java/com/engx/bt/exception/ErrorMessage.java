package com.engx.bt.exception;

/**
 * Java File. Title : ErrorMessage.java Description : This class is used
 * for holding the error information for exposing it to the client.
 * Copyright : ENGX-TechBullets (c) 2016 Company : EPAM Solutions.
 *
 * @author : rvaddi
 * @version : 0.1
 */
public class ErrorMessage {

    /**
     * name.
     */
    private String name;
    /**
     * message.
     */
    private String message;

    /**
     * @param name
     *            name
     * @param message
     *            message
     */
    public ErrorMessage(final String name, final String message) {
        super();
        this.name = name;
        this.message = message;
    }

    /**
     * @return message
     */
    public final String getMessage() {
        return message;
    }

    /**
     * @return name
     */
    public final String getName() {
        return name;
    }

    /**
     * @param message
     *            message
     */
    public final void setMessage(final String message) {
        this.message = message;
    }

    /**
     * @param name
     *            name
     */
    public final void setName(final String name) {
        this.name = name;
    }

    @Override
    public final String toString() {
        return "ErrorMessage [name=" + name + ", message=" + message + "]";
    }

}
