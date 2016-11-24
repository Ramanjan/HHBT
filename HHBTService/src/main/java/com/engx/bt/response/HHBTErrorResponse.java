/**
 *
 */
package com.engx.bt.response;

import org.springframework.http.HttpStatus;

public class HHBTErrorResponse extends HHBTResponse {

    public HHBTErrorResponse(final Object object, final String message) {
        prepareResponse(object, message);
    }

    @Override
    public void prepareResponse(final Object object, final String message) {
        responseMap.put("statusCode",
                HttpStatus.INTERNAL_SERVER_ERROR.value());
        responseMap.put("data", object);
        responseMap.put("message", message);
    }

}