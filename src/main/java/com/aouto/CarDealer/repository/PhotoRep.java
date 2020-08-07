package com.aouto.CarDealer.repository;

import com.aouto.CarDealer.model.Photo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhotoRep extends CrudRepository<Photo, Long> {
}
