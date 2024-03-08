package com.deyvis.initialartifactms.components;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.util.List;

/**
 * This class obtain the 'simple' values of configuration file for the microservice.
 *
 * @author David G.
 * @version 1.0
 */
@Getter
@Component
public class AppValuesComponent {

    /**
     * Obtain the paths that are included in the interceptor.
     */
    @Value("${application.interceptor.paths}")
    private List<String> paths;

}
