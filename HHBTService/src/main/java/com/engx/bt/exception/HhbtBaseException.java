package com.engx.bt.exception;

/**
 * Java File. Title : HhbtBaseException.java Description : This class is
 * used for base exception. Copyright : ENGX-TechBullets (c) 2016 Company :
 * EPAM Solutions.
 *
 * @author : rvaddi
 * @version : 0.1
 */
public class HhbtBaseException extends Exception {

    /**
     * serialVersionUID.
     */
    private static final long serialVersionUID = 5117717883344589172L;
    /**
     * message.
     */
    private final transient String message;

    /**
     * @param msg
     *            msg
     */
    public HhbtBaseException(final String msg) {
        super();
        this.message = msg;
    }

    /**
     * @return message
     */
    @Override
    public final String getMessage() {
        return message;
    }
}
