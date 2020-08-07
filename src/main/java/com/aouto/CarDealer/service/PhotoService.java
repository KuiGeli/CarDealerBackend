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
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.zip.Deflater;

@Service
public class PhotoService {

    PhotoRep photoRep;

    @Autowired
    public PhotoService(PhotoRep photoRep) {
        this.photoRep = photoRep;
    }


    public BodyBuilder uploadImage(InputStream file) throws IOException {
        Photo photo = new Photo();
        byte[] bytes = new byte[file.available()];
        file.read(bytes);
        photo.setImage(bytes);
        photoRep.save(photo);
        return ResponseEntity.status(HttpStatus.OK);

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
