package com.piData.emlak.security.endpoint;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(("/api/test"))
//localhost:5000/api/test/hello
public class TestController {

    @GetMapping("/hello")
    public String hello()
    {return "Hello World!";}
}
