package com.deyvis.initialartifactms.exceptions;

import com.deyvis.initialartifactms.utils.AppUtils;

/**
 * This Exception represent error in find header required for the application,
 *
 * @author David G.
 * @version 1.0
 */
public class MissingHeaderException extends RuntimeException {

    /**
     * Name of required header.
     */
    private String nameHeader;

    /**
     * Constructor of the exception.
     *
     * @param nameHeader that is not found.
     */
    public MissingHeaderException(String nameHeader) {
        super();
        this.nameHeader = nameHeader;
    }

    /**
     * Apply a standard message to show in petition.
     *
     * @return {@code String} message.
     */
    @Override
    public String getMessage() {
        String message = AppUtils.stringBuilder("Required header '", nameHeader, "' is not present.");
        return message;
    }

}
