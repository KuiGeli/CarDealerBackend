package com.aouto.CarDealer.controller;

import com.aouto.CarDealer.model.Auto;
import com.aouto.CarDealer.service.AutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auto/")
public class AutoController {

        AutoService autoService;

        @Autowired
    public AutoController(AutoService autoService) {
        this.autoService = autoService;
    }


    @RequestMapping("/save")
    public void save(@RequestParam("Mark") String mark, @RequestParam String type, @RequestParam String price){
            Auto auto = new Auto();
            auto.setMark(mark);
            auto.setType(type);
            auto.setPrice(price);
            autoService.save(auto);
    }
}
