package com.deyvis.initialartifactms.models.common;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.util.List;

/**
 * POJO class that represent the structure of valid headers for the app declared in configuration file.
 *
 * @author David G.
 * @version 1.0
 */
@ToString
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
     * Methods that are include in the header.
     */
    private List<String> methods;

}
