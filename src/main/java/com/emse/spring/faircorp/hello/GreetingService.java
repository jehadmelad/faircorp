package com.emse.spring.faircorp.hello;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public interface GreetingService {
    void greet(String name);
}

