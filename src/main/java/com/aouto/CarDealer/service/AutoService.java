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

    }

    public Auto findById(long id){
        return autoRep.findById(id).get();
    }

    public void save(Auto auto) {
        autoRep.save(auto);
    }
}
