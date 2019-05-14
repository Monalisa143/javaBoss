package com.nt.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

@Configuration
@Import({PersistenceConfig.class,ServiceConfig.class})
public class AppConfig {

}
