package com.aouto.CarDealer.repository;


import com.aouto.CarDealer.model.Auto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutoRep extends CrudRepository<Auto, Long> {
}
