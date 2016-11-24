package com.engx.bt.exception;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.engx.bt.common.HhbtCommonUtil;

/**
 * Java File. Title : HHBTControllerExceptionHandler.java Description :
 * This controller advice class used for if any exception is happened, it
 * will catch the exception and add the details into the error object and
 * pass it to the client. Copyright : ENGX-TechBullets (c) 2016 Company :
 * EPAM Solutions.
 *
 * @author : rvaddi
 * @version : 0.1
 */
@ControllerAdvice
public class HHBTControllerExceptionHandler {
    /**
     * LOGGER.
     */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(HHBTControllerExceptionHandler.class);

    /**
     * This method is used for handling the exceptions.
     * 
     * @param exception
     *            exception
     * @return
     */
    @ExceptionHandler
    @ResponseBody
    private final Map<String, Object> handleException(
            final Exception exception) {
        final ErrorMessage errorMessage =
                new ErrorMessage(exception.getClass().getName(),
                        exception.getMessage());

        LOGGER.error("Exception is occured due to: ", errorMessage);
        return HhbtCommonUtil.getErrorResponseMap(errorMessage,
                exception.getMessage());
    }

}