package com.slippery.jsec.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class SimpleHelloController {
    public String greeting(){
        return "hii";
    }
//    396347c9-848f-467b-951a-5a3b39dffd5f

}
