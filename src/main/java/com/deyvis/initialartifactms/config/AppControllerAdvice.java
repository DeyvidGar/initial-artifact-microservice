package com.deyvis.initialartifactms.config;

import com.deyvis.initialartifactms.constants.AppConstants;
import com.deyvis.initialartifactms.models.common.HandlerErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpMediaTypeNotSupportedException;
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

    /**
     * Obtain the log for this class.
     */
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    /**
     * Method that show in the response and console the error for the microservice.
     *
     * @param ex exception captured.
     * @param request of the petition.
     * @return @{@link HandlerErrorResponse} for the response.
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    public HandlerErrorResponse handlerHttpRequestMethodNotSupportedEx(
            HttpRequestMethodNotSupportedException ex, HttpServletRequest request){

        HandlerErrorResponse error = createErrorResponse(ex, request, HttpStatus.METHOD_NOT_ALLOWED);
        showErrorLog(ex, request);

        return error;
    }

    /**
     * Method that show in the response and console the error for the microservice.
     *
     * @param ex exception captured.
     * @param request of the petition.
     * @return @{@link HandlerErrorResponse} for the response.
     */
    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    @ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
    public HandlerErrorResponse handlerHttpMediaTypeNotSupportedExceptionEx(
            HttpMediaTypeNotSupportedException ex, HttpServletRequest request){

        HandlerErrorResponse error = createErrorResponse(ex, request, HttpStatus.UNSUPPORTED_MEDIA_TYPE);
        showErrorLog(ex, request);

        return error;
    }

    /**
     * This method show the error in the console.
     *
     * @param ex generic exception.
     * @param request of the petition.
     */
    private void showErrorLog(Exception ex, HttpServletRequest request) {
        log.error(AppConstants.STATUS_ERROR + HttpStatus.METHOD_NOT_ALLOWED.series());
        log.error(AppConstants.MESSAGE_ERROR + ex.getMessage());
        log.error(AppConstants.CODE_ERROR + HttpStatus.METHOD_NOT_ALLOWED.value());
        log.error(AppConstants.TIMESTAMP_ERROR + LocalDateTime.now());
        log.error(AppConstants.PATH_ERROR + request.getRequestURI());
        log.error(AppConstants.TRACE);
        ex.printStackTrace();
    }

    /**
     * This method is like a utility because support at the creation of a object response.
     *
     * @param ex generic exception.
     * @param request of the petition.
     * @param httpStatus of the petition.
     * @return {@link HandlerErrorResponse} for the response.
     */
    private HandlerErrorResponse createErrorResponse(Exception ex, HttpServletRequest request, HttpStatus httpStatus) {
        return HandlerErrorResponse
                .builder()
                .timestamp(LocalDateTime.now())
                .code(httpStatus.value())
                .message(ex.getMessage())
                .status(httpStatus.series())
                .path(request.getRequestURI())
                .build();
    }

}
