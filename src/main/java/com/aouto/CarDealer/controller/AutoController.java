package com.aouto.CarDealer.controller;

import com.aouto.CarDealer.model.Auto;
import com.aouto.CarDealer.service.AutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "auto")
public class AutoController {

        AutoService autoService;

        @Autowired
    public AutoController(AutoService autoService) {
        this.autoService = autoService;
    }


    @PostMapping("/save")
    @CrossOrigin("*")
    public void save(@RequestParam("mark") String mark, @RequestParam("type") String type, @RequestParam("price") String price){
        System.out.println("Works");
            Auto auto = new Auto();
            auto.setMark(mark);
            auto.setType(type);
            auto.setPrice(price);
            autoService.save(auto);
    }
}
