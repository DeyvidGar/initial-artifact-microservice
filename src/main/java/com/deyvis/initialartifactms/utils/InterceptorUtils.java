package com.deyvis.initialartifactms.utils;

import com.deyvis.initialartifactms.components.HeadersComponent;
import com.deyvis.initialartifactms.exceptions.MissingHeaderException;
import com.deyvis.initialartifactms.models.common.HeadersModel;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.ServletRequestBindingException;
import java.util.*;

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
                    .anyMatch(h -> h.getName().equalsIgnoreCase(headerRequest));

            if (present) {
                headersMap.put(headerRequest.toLowerCase(), request.getHeader(headerRequest));
            }
        });

        return headersMap;
    }

    /**
     * This method validate the headers on petition the type post and put.
     *
     * @param headersMap
     * @param method
     */
    public static void matcherValidateHeader(Map<String, Object> headersMap, String method) {
        boolean isPost = method.equalsIgnoreCase(HttpMethod.POST.name());
        boolean isPut = method.equalsIgnoreCase(HttpMethod.PUT.name());

        if(isPost || isPut) {
            //todo: validate headers that required in post and put methods

            //todo: exception in content type and accept, both: application/json
            //todo: use the class Pattern & Matcher
        }
    }

    /**
     * Method that validated the headers that are requires in the petition and type of method http.
     *
     * @param headersMap headers in {@code Map} that have the petition.
     * @param method type of method http.
     * @throws ServletRequestBindingException in case not found required header.
     */
    public static void validateHeader(Map<String, Object> headersMap, String method) throws ServletException, NoSuchMethodException {

        Iterator<HeadersModel> iterator = headersComponent.getHeaders()
                .stream()
                .filter(header -> {
                    boolean isRequiredMethod = header.getMethods()
                            .stream()
                            .anyMatch(s -> s.equalsIgnoreCase(method));
                    return isRequiredMethod;
                })
                .iterator();

        while(iterator.hasNext()){
            HeadersModel next = iterator.next();
            String name = next.getName();
            String message = next.getDescription();
            boolean containsKey = headersMap.containsKey(name.toLowerCase());
            Object value = headersMap.get(name.toLowerCase());

            if (!containsKey || Objects.isNull(value) || value.toString().isEmpty()) {
                switch (name) {
                    case "accept" -> throw new HttpMediaTypeNotAcceptableException(message);
                    case "content-type" -> throw new HttpMediaTypeNotSupportedException(message);
                    default -> throw new MissingHeaderException(name);
                }
            }
        }
    }

}
