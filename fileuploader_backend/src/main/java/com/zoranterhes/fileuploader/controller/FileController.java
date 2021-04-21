package com.zoranterhes.fileuploader.controller;

import com.zoranterhes.fileuploader.service.UploaderService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.security.PermitAll;

@CrossOrigin
@RequiredArgsConstructor
@RestController
@RequestMapping("/")
public class FileController {

    private final UploaderService uploaderService;

    @PermitAll
    @PostMapping("/upload")
    public ResponseEntity<Object> upload(@RequestParam("File") MultipartFile file) {
        System.out.println("incoming file");
        return uploaderService.upload(file);
    }
}