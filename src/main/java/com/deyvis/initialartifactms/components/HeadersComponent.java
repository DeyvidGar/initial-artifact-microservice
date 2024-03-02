package com.deyvis.initialartifactms.components;

import com.deyvis.initialartifactms.model.common.HeadersModel;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import java.util.List;

/**
 * This component obtain the vales of configuration file the headers that are required in the microservice.
 *
 * @author David G.
 * @version 1.0
 */
@Component
@ConfigurationProperties("application.constants")
@Getter
public class HeadersComponent {

    /**
     * List of headers that are required.
     */
    private List<HeadersModel> headers;


}
