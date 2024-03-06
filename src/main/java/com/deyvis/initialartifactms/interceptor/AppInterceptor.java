package com.deyvis.initialartifactms.interceptor;

import com.deyvis.initialartifactms.constants.AppConstants;
import com.deyvis.initialartifactms.constants.MagicValuesConstants;
import com.deyvis.initialartifactms.utils.AppUtils;
import com.deyvis.initialartifactms.utils.InterceptorUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import java.util.Map;

/**
 * This component is the default interceptor in the microservice.
 *
 * @author David G.
 * @version 1.0
 */
@Component
public class AppInterceptor implements HandlerInterceptor {

    /**
     * Obtain the variable to show log in spring.
     */
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    /**
     * This method validate the headers that is required in the app, that headers are declared in the application
     * properties, as well as start obtain the time of the request.
     *
     * @param request of the petition.
     * @param response of the petition.
     * @param handler of the petition.
     * @return {@code boolean} value if petition is valid.
     * @throws Exception is the general exception.
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info(AppConstants.START_PETITION_LOG);

        Long startPetition = System.currentTimeMillis();
        request.setAttribute(AppConstants.START_PETITION, startPetition);

        Map<String, Object> headersMap = InterceptorUtils.getHeadersMap(request);

        //todo: validate the headers.
        InterceptorUtils.validateHeader(headersMap, request.getMethod());

        //todo: validate matches in headers.
        InterceptorUtils.matcherValidateHeader(headersMap, request.getMethod());

        //todo: validate if the request should have body request.

        //todo: show in console the headers in the petition.

        return Boolean.TRUE;
    }

    /**
     * This method obtain the time total that the request is completed.
     *
     * @param request of the petition.
     * @param response of the petition.
     * @param handler of the petition.
     * @throws Exception generic.
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        Long endPetition = System.currentTimeMillis();
        Long startPetition = (Long) request.getAttribute(AppConstants.START_PETITION);
        Long totalTime = endPetition - startPetition;

        String message = AppUtils.stringBuilder(AppConstants.COMPLETE_PETITION, totalTime, MagicValuesConstants._MS);
        log.info(message);
    }

}
