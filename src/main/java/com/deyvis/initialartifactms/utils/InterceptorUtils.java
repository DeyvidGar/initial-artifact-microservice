package com.deyvis.initialartifactms.utils;

import com.deyvis.initialartifactms.components.HeadersComponent;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.ServletRequestBindingException;
import java.util.HashMap;
import java.util.Map;

/**
 * This component contains the utils methods for validate interceptor.
 *
 * @author David G.
 * @version 1.0
 */
@Component
public class InterceptorUtils {

    /**
     * Component that contains the headers required in the microservice.
     */
    private static HeadersComponent headersComponent;

    /**
     * Constructor to inject component.
     *
     * @param headersComponent to get headers required.
     */
    public InterceptorUtils(HeadersComponent headersComponent) {
        InterceptorUtils.headersComponent = headersComponent;
    }

    /**
     * This method filter only headers that the application required.
     *
     * @param request of the petition.
     * @return {@code Map<String, Object>} of the headers in the request.
     */
    public static Map<String, Object> getHeadersMap(HttpServletRequest request) {
        Map<String, Object> headersMap = new HashMap<>();

        request.getHeaderNames().asIterator().forEachRemaining(headerRequest -> {
            Boolean present = headersComponent
                    .getHeaders()
                    .stream()
                    .anyMatch(h -> h.getName().equals(headerRequest));

            if (present) {
                headersMap.put(headerRequest, request.getHeader(headerRequest));
            }
        });

        return headersMap;
    }

    /**
     * Method that validated the headers that are requires in the petition and type of method http.
     *
     * @param headersMap headers in {@code Map} that have the petition.
     * @param method type of method http.
     * @throws ServletRequestBindingException in case not found required header.
     */
    public static void validateHeader(Map<String, Object> headersMap, String method)
            throws ServletRequestBindingException {

        if(method.equalsIgnoreCase(HttpMethod.POST.name())) {
        }



    }
}
