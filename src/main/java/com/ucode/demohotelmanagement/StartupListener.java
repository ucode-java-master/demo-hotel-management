package com.ucode.demohotelmanagement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class StartupListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(StartupListener.class);


    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent event) {
        LOGGER.info("printing all the beans in the application");
        for (String beanDefinitionName : event.getApplicationContext().getBeanDefinitionNames()) {
            LOGGER.info(beanDefinitionName);
        }
    }

}
