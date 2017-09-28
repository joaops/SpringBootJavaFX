package br.com.joaops.demo.config;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author João Paulo
 */
@Configuration
public class MapperConfig {
    
    @Bean
    public MapperFacade getMapperFacade() {
        MapperFacade mapper = new ConfigurableMapper();
        return mapper;
    }
    
}