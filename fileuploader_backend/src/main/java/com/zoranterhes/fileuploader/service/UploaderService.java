package com.zoranterhes.fileuploader.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Date;

@Service
public class UploaderService {

    @Value("${file.upload-dir}")
    private String FILE_PATH;


    public ResponseEntity<Object> upload(MultipartFile file) {
        String pathname = FILE_PATH + file.getOriginalFilename() + LocalDateTime.now();
        File convertedFile = new File(pathname);
        try {
            convertedFile.createNewFile();
            FileOutputStream fos = new FileOutputStream(convertedFile);
            fos.write(file.getBytes());
            fos.close();
        } catch (IOException e) {
            return new ResponseEntity<>("Unsuccessful upload", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Succesfull upload", HttpStatus.OK);
    }
}
