package com.deyvis.initialartifactms.config;

import com.deyvis.initialartifactms.constants.AppConstants;
import com.deyvis.initialartifactms.model.common.HandlerErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.time.LocalDateTime;

/**
 * This class take the control for the handlers exceptions.
 *
 * @author David G.
 * @version 1.0
 */
@RestControllerAdvice
public class AppControllerAdvice {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    /**
     * Method that show in the response and console the error for the microservice.
     *
     * @param ex {@code HttpRequestMethodNotSupportedException}.
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    public HandlerErrorResponse handlerHttpRequestMethodNotSupportedEx(
            HttpRequestMethodNotSupportedException ex, HttpServletRequest request){

        HandlerErrorResponse error = new HandlerErrorResponse();
        error.setTimestamp(LocalDateTime.now());
        error.setCode(HttpStatus.METHOD_NOT_ALLOWED.value());
        error.setMessage(ex.getMessage());
        error.setStatus(HttpStatus.METHOD_NOT_ALLOWED.series());
        error.setPath(request.getRequestURI());
        showErrorLog(ex, request);

        return error;
    }

    /**
     * This method show the error in the console.
     *
     * @param ex Exception of the error in request.
     * @param request of the petition.
     */
    private void showErrorLog(HttpRequestMethodNotSupportedException ex, HttpServletRequest request) {
        log.error(AppConstants.STATUS_ERROR + HttpStatus.METHOD_NOT_ALLOWED.series());
        log.error(AppConstants.MESSAGE_ERROR + ex.getMessage());
        log.error(AppConstants.CODE_ERROR + HttpStatus.METHOD_NOT_ALLOWED.value());
        log.error(AppConstants.TIMESTAMP_ERROR + LocalDateTime.now());
        log.error(AppConstants.PATH_ERROR + request.getRequestURI());
        log.error(AppConstants.TRACE);
        ex.printStackTrace();
    }


}
