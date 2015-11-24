package com.adarsh.spring.batch;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationMain {

    public static void main(String[] args) {
        final String[] springConfig = {"classpath:/configuration/applicationContext.xml"};
        final ApplicationContext context = new ClassPathXmlApplicationContext(springConfig);
    }
}
