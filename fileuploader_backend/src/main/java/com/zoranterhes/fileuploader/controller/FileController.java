package com.zoranterhes.fileuploader.controller;

import com.zoranterhes.fileuploader.entity.FileOutputDTO;
import com.zoranterhes.fileuploader.service.UploaderService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin
@RequiredArgsConstructor
@RestController
@RequestMapping("/")
public class FileController {
    private final Logger log = LoggerFactory.getLogger(FileController.class);
    private final UploaderService uploaderService;

    @PostMapping("/upload_to_local")
    public ResponseEntity<Object> uploadLocal(@RequestParam("File") MultipartFile file) {
        log.info("Incoming file to local saving: " + file.getOriginalFilename());
        return uploaderService.uploadToLocal(file);
    }

    @PostMapping("/upload")
    public FileOutputDTO uploadDatabase(@RequestParam("File") MultipartFile file){
        log.info("Incoming file to database saving: " + file.getOriginalFilename());
        return uploaderService.upload(file);
    }

    @GetMapping("/download/{id}")
    public ResponseEntity<ByteArrayResource> download(@PathVariable String id){
        log.info("Incoming download request to {}",id);
        return uploaderService.get(id);
    }
}