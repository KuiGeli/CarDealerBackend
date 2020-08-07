package com.aouto.CarDealer.controller;


import com.aouto.CarDealer.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.InputStream;

@RestController
@RequestMapping(path = "image")
public class PhotoController {

    PhotoService photoService;

    @Autowired
    public PhotoController(PhotoService photoService) {
        this.photoService = photoService;
    }

    @PostMapping("/upload")
    @CrossOrigin("*")
    public BodyBuilder upload(@RequestParam(name = "imageFile") InputStream file) throws IOException {
        return photoService.uploadImage(file);
    }

}
