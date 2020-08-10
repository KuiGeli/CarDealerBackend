package com.aouto.CarDealer.service;


import com.aouto.CarDealer.model.Photo;
import com.aouto.CarDealer.repository.PhotoRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.Deflater;

@Service
public class PhotoService {

    PhotoRep photoRep;

    @Autowired
    public PhotoService(PhotoRep photoRep) {
        this.photoRep = photoRep;
    }


    public Photo uploadImage(MultipartFile file) throws IOException {

        Photo photo = new Photo();
        photo.setImage(compressImage(file.getBytes()));
        photoRep.save(photo);

        return photo;

    }

    public byte[] compressImage(byte[] data) {
        Deflater deflater = new Deflater();
        deflater.setInput(data);
        deflater.finish();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] buffer = new byte[1024];
        while (!deflater.finished()) {
            int count = deflater.deflate(buffer);
            outputStream.write(buffer, 0, count);
        }
        try {
            outputStream.close();
        } catch (IOException e) {

        }
        return outputStream.toByteArray();
    }


}
