/**
 *
 */
package com.engx.bt.response;

import org.springframework.http.HttpStatus;

public class HHBTSuccessResponse extends HHBTResponse {

    public HHBTSuccessResponse(final Object object, final String message) {
        prepareResponse(object, message);
    }

    @Override
    public void prepareResponse(final Object object, final String message) {
        responseMap.put("statusCode", HttpStatus.OK.value());
        responseMap.put("data", object);
        responseMap.put("message", message);
    }

}