package com.zoranterhes.fileuploader.controller;

import com.zoranterhes.fileuploader.service.UploaderService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@RestController
public class FileController {

    private final UploaderService uploaderService;

    @PostMapping("/upload")
    public ResponseEntity<Object> upload(@RequestParam("File") MultipartFile file) {
        System.out.println("incoming file");
        return uploaderService.upload(file);
    }
}
