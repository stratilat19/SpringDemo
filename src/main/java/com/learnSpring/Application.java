package com.learnSpring;

import lombok.extern.log4j.Log4j2;

//import org.apache.logging.log4j.LogManager;// made inside @Log4j2
//import org.apache.logging.log4j.Logger;// made inside @Log4j2
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Log4j2
public class Application implements ApplicationRunner {

//    private static final Logger log = LogManager.getLogger(Application.class);// made inside @Log4j2

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        log.debug("Debugging log");
        log.info("Info log");
        log.warn("Hey, This is a warning!");
        log.error("Oops! We have an Error. OK");
        log.fatal("Damn! Fatal error. Please fix me.");

        log.info("Your application started with option names : {}", applicationArguments.getOptionNames());
    }

}
