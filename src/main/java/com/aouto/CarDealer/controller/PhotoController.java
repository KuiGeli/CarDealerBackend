package com.aouto.CarDealer.controller;


import com.aouto.CarDealer.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping(path = "image")
public class PhotoController {

    PhotoService photoService;

    @Autowired
    public PhotoController(PhotoService photoService) {
        this.photoService = photoService;
    }

    @PostMapping(value = "/upload", consumes = "multipart/form-data")
    @CrossOrigin("*")
    public void upload(@RequestParam("imageFile") MultipartFile file) throws IOException {
        photoService.uploadImage(file);
    }

}
