package com.sonchayan.homeService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HomeController {
    @Autowired
    private RestTemplate restTemplate;
    @GetMapping("/home")
    public String Home(){
        //it will fetch the products class which is running on server port number 8081
       //PRODUCTSSERVICE --- this is got from service descovery whiich application name we have give it in the productservice application
        String product=restTemplate.getForObject("http://PRODUCTSSERVICE/products", String.class);
        return product;
    }
    @GetMapping("/homes")
    public String Homes(){
        //it is just return string
        return "this is homes class";
    }
}
