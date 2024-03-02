package com.deyvis.initialartifactms.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * This component is the default interceptor in the microservice.
 *
 * @author David G.
 * @version 1.0
 */
@Component
public class AppInterceptor implements HandlerInterceptor {

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
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    /**
     * This method obtain the time total that the request is completed.
     *
     * @param request of the petition.
     * @param response of the petition.
     * @param handler of the petition.
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
