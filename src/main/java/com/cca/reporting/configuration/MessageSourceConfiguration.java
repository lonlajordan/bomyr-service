package com.cca.reporting.configuration;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;

import java.util.Arrays;
import java.util.Locale;

@Configuration
public class MessageSourceConfiguration {

    @Bean
    public MessageSource messageSource(){
        ResourceBundleMessageSource source = new ResourceBundleMessageSource();
        source.addBasenames("lang/messages");
        source.setUseCodeAsDefaultMessage(true);
        return source;
    }

    @Bean
    public LocaleResolver localeResolver(){
        HeaderLocaleResolver localeResolver = new HeaderLocaleResolver();
        localeResolver.setName("language");
        localeResolver.setDefaultLocale(Locale.FRENCH);
        localeResolver.setSupportedLocales(Arrays.asList(Locale.FRENCH, Locale.ENGLISH));
        return localeResolver;
    }
}
