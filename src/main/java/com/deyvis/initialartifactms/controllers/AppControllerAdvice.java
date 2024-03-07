package com.deyvis.initialartifactms.controllers;

import com.deyvis.initialartifactms.constants.AppConstants;
import com.deyvis.initialartifactms.exceptions.MissingHeaderException;
import com.deyvis.initialartifactms.models.common.HandlerErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.NoSuchElementException;

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
     * Method that show in the response and console the error when user use a method not supported for the microservice.
     *
     * @param ex exception captured.
     * @param request of the petition.
     * @return {@link HttpRequestMethodNotSupportedException} for the response.
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    public HandlerErrorResponse handlerHttpRequestMethodNotSupportedEx(
            HttpRequestMethodNotSupportedException ex, HttpServletRequest request){

        HandlerErrorResponse error = createErrorResponse(ex, request, HttpStatus.METHOD_NOT_ALLOWED);
        showErrorLog(ex, request, HttpStatus.METHOD_NOT_ALLOWED);

        return error;
    }

    /**
     * Method that show in the response and console the error when not found header for the microservice.
     *
     * @param ex exception captured.
     * @param request of the petition.
     * @return {@link MissingHeaderException} for the response.
     */
    @ExceptionHandler(MissingHeaderException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public HandlerErrorResponse handlerMissingHeaderExceptionEx(
            MissingHeaderException ex, HttpServletRequest request){

        HandlerErrorResponse error = createErrorResponse(ex, request, HttpStatus.BAD_REQUEST);
        showErrorLog(ex, request, HttpStatus.BAD_REQUEST);

        return error;
    }

    /**
     * Method that show in the response and console the error, for example in 'Content-type' required header for the microservice.
     *
     * @param ex exception captured.
     * @param request of the petition.
     * @return {@link HttpMediaTypeNotSupportedException} for the response.
     */
    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    @ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
    public HandlerErrorResponse handlerHttpMediaTypeNotSupportedExceptionEx(
            HttpMediaTypeNotSupportedException ex, HttpServletRequest request){

        HandlerErrorResponse error = createErrorResponse(ex, request, HttpStatus.UNSUPPORTED_MEDIA_TYPE);
        showErrorLog(ex, request, HttpStatus.UNSUPPORTED_MEDIA_TYPE);

        return error;
    }

    /**
     * Method that show in the response and console the error, for example in 'Accept' required header for the microservice.
     *
     * @param ex exception captured.
     * @param request of the petition.
     * @return {@link HttpMediaTypeNotAcceptableException} for the response.
     */
    @ExceptionHandler(HttpMediaTypeNotAcceptableException.class)
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    public HandlerErrorResponse handlerHttpMediaTypeNotAcceptableExceptionEx(
            HttpMediaTypeNotAcceptableException ex, HttpServletRequest request){

        HandlerErrorResponse error = createErrorResponse(ex, request, HttpStatus.NOT_ACCEPTABLE);
        showErrorLog(ex, request, HttpStatus.NOT_ACCEPTABLE);

        return error;
    }

    /**
     * Show in the response and console the error,
     * when the petition no have the object in request and object expected for the microservice.
     *
     * @param ex exception captured.
     * @param request of the petition.
     * @return {@link NoSuchElementException} for the response.
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public HandlerErrorResponse handlerHttpMessageNotReadableExceptionEx(
            HttpMessageNotReadableException ex, HttpServletRequest request){

        HandlerErrorResponse error = createErrorResponse(ex, request, HttpStatus.BAD_REQUEST);
        showErrorLog(ex, request, HttpStatus.BAD_REQUEST);

        return error;
    }

    /**
     * This method show the error in the console.
     *
     * @param ex generic exception.
     * @param request of the petition.
     * @param methodNotAllowed type of HttpStatus.
     */
    private void showErrorLog(Exception ex, HttpServletRequest request, HttpStatus methodNotAllowed) {
        log.error(AppConstants.STATUS_ERROR + methodNotAllowed.series());
        log.error(AppConstants.MESSAGE_ERROR + ex.getMessage());
        log.error(AppConstants.CODE_ERROR + methodNotAllowed.value());
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
                .series(httpStatus.series())
                .status(httpStatus.getReasonPhrase().toUpperCase())
                .path(request.getRequestURI())
                .build();
    }

}
