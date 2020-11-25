package com.emse.spring.faircorp.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.lang.reflect.Member;

@RestController
@Transactional
@RequestMapping("api/hello")
public class HelloController {


    class MyMessage{
        String msg;

        public MyMessage(String msg){
            this.msg = msg;
        }
        public String getMsg() {
            return msg;
        }}

    @GetMapping("/{name}")
    public MyMessage welcome(@PathVariable String name){
        return new MyMessage("Hello "+ name);
    }
}
