package com.aouto.CarDealer.service;


import com.aouto.CarDealer.model.Auto;
import com.aouto.CarDealer.repository.AutoRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutoService {
    AutoRep autoRep;

    @Autowired
    public AutoService(AutoRep autoRep) {
        this.autoRep = autoRep;
        Auto auto = new Auto();
        auto.setMark("Audi");
        auto.setPrice("64645");
        auto.setType("TT");
        autoRep.save(auto);
    }

    public Auto findById(long id){
        return autoRep.findById(id).get();
    }
}
