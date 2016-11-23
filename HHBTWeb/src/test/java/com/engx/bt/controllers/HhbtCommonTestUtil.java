package com.engx.bt.controllers;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

public class HhbtCommonTestUtil {
   
    /**
     * {@link Logger}.
     */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(HhbtCommonTestUtil.class);
    
   /**
    * This method to performMockServiceCall by passing parameters and
    * request object.
    * @param mockMvc mockMvc 
    * @param uriRequest uriRequest
    * @param requestData requestData
    * @return ResultActions
    */
    public final ResultActions performMockServiceCall(MockMvc mockMvc,
            String uriRequest, String requestData) {
        ResultActions resultActions = null;
        try {
            resultActions = mockMvc.perform(post(uriRequest).contentType(
                    MediaType.APPLICATION_JSON).content(requestData));
        } catch (Exception exception) {
            LOGGER.error("Exception is occured due to :" + exception);
        }
        return resultActions;
    }

    /**
     * This method is to check the response status code and service
     * response status code are 200.
     * 
     * @param resultActions
     *            resultActions
     */
    public final void checkValidResultStatus(ResultActions resultActions) {
        try {
            resultActions.andExpect(status().isOk());
            resultActions.andExpect(jsonPath("$.statusCode",
                    is(HttpStatus.OK.value())));
        } catch (Exception exception) {
            LOGGER.error("Exception is occured due to :" + exception);
        }
    }
}