package com.sonchayan.ProductsService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ProductController {
    @Autowired
    private RestTemplate restTemplate;
    @GetMapping("/product")
    public String product(){
        //it will fetch the homes class which is running on server port number 8082
        //HOMESERVICE --- this is got from service descovery whiich application name we have give it in the homeservice application
        String home=restTemplate.getForObject("http://HOMESERVICE/homes", String.class);
        return home;
    }
    @GetMapping("/products")
    //this is just return string
    public String products(){
        return "this is product class";
    }
}
