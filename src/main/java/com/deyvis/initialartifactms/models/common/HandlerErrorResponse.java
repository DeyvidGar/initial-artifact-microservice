package com.deyvis.initialartifactms.models.common;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

/**
 * POJO class that represent the error model in a petition.
 *
 * @version David G.
 * @author 1.0
 */
@Getter
@Setter
@Builder
public class HandlerErrorResponse {

    /**
     * Time and Date to occurs the error.
     */
    private LocalDateTime timestamp;

    /**
     * Status http of the petition.
     */
    private String status;

    /**
     * Series http of the petition.
     */
    private Enum series;

    /**
     * Short message to describe the error petition.
     */
    private String message;

    /**
     * Code http of the petition.
     */
    private int code;

    /**
     * Path where occurs the error.
     */
    private String path;

}
