package com.emse.spring.faircorp;

import com.emse.spring.faircorp.hello.ConsoleGreetingService;
import com.emse.spring.faircorp.hello.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Configuration
public class FaircorpApplicationConfig {
    @Autowired
    GreetingService greetingService ;

    @Autowired
    ConsoleGreetingService greeting;

    @Bean
    public CommandLineRunner greetingCommandLine(GreetingService greetingService){

        this.greetingService = greetingService;
        return new CommandLineRunner( ) {

            @Override
            public void run(String... args) throws Exception {
                greeting.greet("jehad");
//                ConsoleGreetingService greeting = new ConsoleGreetingService();


//                greeting.greet("Jehad");
                // (4)
            }
        };
    }
}
