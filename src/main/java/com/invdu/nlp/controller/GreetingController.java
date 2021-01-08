package com.invdu.nlp.controller;

import com.invdu.nlp.bean.Greeting;
import com.invdu.nlp.mapper.GreetingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by InvincibleDudu on 01/08/2021 at 11:46
 */

@CrossOrigin
@RestController
public class GreetingController {

    GreetingMapper greetingMapper;

    @Autowired
    public void setGreetingMapper(GreetingMapper greetingMapper) {
        this.greetingMapper = greetingMapper;
    }

//    private static final String template = "Hello, %s!";
//    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/getGreeting")
    public Greeting greeting(@RequestParam long id) {
//        System.out.println(name);
//        return new Greeting(counter.incrementAndGet(), String.format(template, name));
        return greetingMapper.getGreetingById(id);
    }

    @PostMapping("/greeting")
    public String greetings(@RequestBody Greeting greeting) {
        if (greeting.getId() != 0 && greeting.getName() != null) {
            var result = greetingMapper.saveGreeting(greeting.getId(), greeting.getName());
            System.out.println("result: " + result + " " + greeting.getId() + greeting.getName());
            return "success " + result + " rows inserted";
        }
        return "failed";
    }

    @DeleteMapping("/greeting")
    public String deleteGreeting(@RequestParam long id) {
        if (id != 0) {
            var delete = greetingMapper.deleteGreeting(id);
            return "ok " + delete + " lines deleted";
        }
        return "failed";
    }
}


