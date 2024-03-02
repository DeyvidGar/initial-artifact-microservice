package com.deyvis.initialartifactms.model.common;

import lombok.Getter;
import lombok.Setter;
import java.util.List;

/**
 * POJO class that represent the structure of valid headers for the app declared in configuration file.
 *
 * @author David G.
 * @version 1.0
 */
@Getter
@Setter
public class HeadersModel {

    /**
     * Name of the header.
     */
    private String name;

    /**
     * Description of the header.
     */
    private String description;

    /**
     * Boolean value if is required in the microservice.
     */
    private Boolean required;

    /**
     * Methods that are include in the header.
     */
    private List<String> methods;

}