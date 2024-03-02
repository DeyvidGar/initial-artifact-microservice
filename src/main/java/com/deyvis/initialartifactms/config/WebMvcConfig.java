package com.deyvis.initialartifactms.config;

import com.deyvis.initialartifactms.components.AppValuesComponent;
import com.deyvis.initialartifactms.interceptor.AppInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * This configuration component class add the default interceptor for the microservice.
 *
 * @author David G.
 * @version 1.0
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    /**
     * This component contains the constants for the microservice.
     */
    private AppValuesComponent app;


    /**
     * Component that contains the logic of default interceptor.
     */
    private AppInterceptor appInterceptor;

    /**
     * Constructor of this class.
     *
     * @param appInterceptor default configuration.
     */
    public WebMvcConfig(AppInterceptor appInterceptor, AppValuesComponent app) {
        this.appInterceptor = appInterceptor;
        this.app = app;
    }

    /**
     * This method add the news interceptor for the microservice.
     *
     * @param registry InterceptoRegistry.
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        WebMvcConfigurer.super.addInterceptors(registry);
        registry.addInterceptor(appInterceptor).addPathPatterns(app.getPaths());
    }


}
