package com.finalweb.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.finalweb.clinicas.dto.ClinicaDTO;
import com.finalweb.clinicas.model.Clinica;

@Configuration
public class AppConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper mapper = new ModelMapper();

        
        mapper.addMappings(new PropertyMap<Clinica, ClinicaDTO>() {
            @Override
            protected void configure() {
                map().setIdentificador(source.getId());
            }
        });

        mapper.addMappings(new PropertyMap<ClinicaDTO, Clinica>() {
            @Override
            protected void configure() {
                map().setId(source.getIdentificador());
            }
        });

        return mapper;
    }
}
