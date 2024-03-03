package com.deyvis.initialartifactms.components;

import com.deyvis.initialartifactms.models.common.HeadersModel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import java.util.List;

/**
 * This component obtain the vales of configuration file the headers that are required in the microservice.
 *
 * @author David G.
 * @version 1.0
 */
@Getter
@Setter
@Component
@ConfigurationProperties("application.constants")
public class HeadersComponent {

    /**
     * List of headers that are required.
     */
    private List<HeadersModel> headers;

}
