package com.engx.bt.common;

import java.util.Map;

import com.engx.bt.response.HHBTErrorResponse;
import com.engx.bt.response.HHBTResponse;
import com.engx.bt.response.HHBTSuccessResponse;
import com.google.gson.Gson;

/**
 * Java File. Title : HhbtCommonUtil.java. Description : This Configuration
 * class is used to perform all common methods. Copyright :
 * ENGX-TechBullets (c) 2016 Company : EPAM Solutions.
 *
 * @author : rvaddi
 * @version : 0.1
 */

public class HhbtCommonUtil {

    /**
     * This method will convert any object into String.
     *
     * @param object
     *            This is the request Object.
     * @return String
     */
    public final static String convertIntoJson(final Object object) {
        return new Gson().toJson(object);
    }

    /**
     * This method is used to get fail status response.
     *
     * @param object
     *            object
     * @param message
     *            message
     * @return responseMap
     */
    public static Map<String, Object> getErrorResponseMap(
            final Object object, final String message) {
        final HHBTResponse hhbtResponse =
                new HHBTErrorResponse(object, message);
        return hhbtResponse.getResponseMap();
    }

    /**
     * This method is used to get success status response.
     *
     * @param object
     *            object
     * @param message
     *            message
     * @return responseMap
     */
    public static Map<String, Object> getSuccessResponseMap(
            final Object object, final String message) {
        final HHBTResponse hhbtResponse =
                new HHBTSuccessResponse(object, message);
        return hhbtResponse.getResponseMap();
    }

}