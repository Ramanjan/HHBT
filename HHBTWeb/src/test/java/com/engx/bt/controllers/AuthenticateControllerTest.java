package com.engx.bt.controllers;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.engx.bt.common.HhbtCommonUtil;
import com.engx.bt.common.HhbtServiceURI;
import com.engx.bt.controllers.AuthenticateController;
import com.engx.bt.exception.HhbtBaseException;
import com.engx.bt.service.AuthenticateService;
import com.engx.bt.transferobjects.AuthenticateUserTo;

/**
 * Title : AuthenticateControllerTest.java. Description : This class
 * contains test cases related to authenticate controller. Copyright :
 * ENGX-TechBullets (c) 2016 Company : EPAM Solutions.
 *
 * @author : rvaddi
 * @version : 0.1
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class)
public class AuthenticateControllerTest {

    /**
     * {@link AuthenticateService}.
     */
    @Mock
    private transient AuthenticateService authenticateService;

    /**
     * {@link AuthenticateController}.
     */
    @InjectMocks
    private transient AuthenticateController authenticateController;

    /**
     *
     */
    private transient HhbtCommonTestUtil hhbtCommonTestUtil =
            new HhbtCommonTestUtil();

    /**
     * {@link MockMvc}.
     */
    private transient MockMvc mockMvc;

    /**
     * {@link Logger}.
     */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(AuthenticateControllerTest.class);

    /**
     * TestCase 1: Authenticate User with valid credentials.sss
     * 
     * @throws HhbtBaseException
     */
    @Test
    public final void authenticateUserWithValidCredentials()
            throws HhbtBaseException {
        mockTheAuthenticateService(authenticateService);
        performAuthentication();
    }

    /**
     * This method is used to get mock test data of user credentials for
     * authentication.
     *
     * @return AuthenticateUserTo
     */
    private final AuthenticateUserTo getAuthenticateTestData() {
        final AuthenticateUserTo authenticateUserTo =
                new AuthenticateUserTo();
        authenticateUserTo.setUserEmailId("Helping_Hands@TechBullets.com");
        authenticateUserTo.setUserPassword("ASMMRB@TSG");
        return authenticateUserTo;
    }

    /**
     * This method is used to mock the authenticate service method.
     *
     * @param userService
     *            userService
     * @throws HhbtBaseException
     */
    private final void mockTheAuthenticateService(
            final AuthenticateService userService)
            throws HhbtBaseException {
        final AuthenticateUserTo authenticateResponseUserTo =
                getAuthenticateTestData();
        setTokenAndUserIdToAuthenticateObject(authenticateResponseUserTo);
        Mockito.when(
                userService.validateUserCredentials(Matchers
                        .<AuthenticateUserTo> any())).thenReturn(
                authenticateResponseUserTo);
    }

    /**
     * This method will perform the authentication and valid the success.
     */
    private final void performAuthentication() {
        final AuthenticateUserTo authenticateRequestUserTo =
                getAuthenticateTestData();
        final String strAuthenticateRequestUserTo =
                HhbtCommonUtil.convertIntoJson(authenticateRequestUserTo);
        final ResultActions resultActions =
                hhbtCommonTestUtil.performMockServiceCall(mockMvc,
                        HhbtServiceURI.AUTHENTICATE,
                        strAuthenticateRequestUserTo);
        hhbtCommonTestUtil.checkValidResultStatus(resultActions);
    }

    /**
     * This method is to set tokenId and UserId for authenticate object
     * which will be used as response object from service.
     *
     * @param authenticateUserTo
     *            authenticateUserTo
     */
    private final void setTokenAndUserIdToAuthenticateObject(
            final AuthenticateUserTo authenticateUserTo) {
        authenticateUserTo.setUserId(10);
        authenticateUserTo.setUserTokenId("ASJKHHJKAFHJASHJHJ:SHGH");
    }

    /**
     * This Method is to set up user controller object before all the test
     * cases in this class execute.
     */
    @Before
    public final void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc =
                MockMvcBuilders.standaloneSetup(authenticateController)
                        .build();
    }

}