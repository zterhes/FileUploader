package com.zoranterhes.fileuploader.service;

import com.zoranterhes.fileuploader.entity.FileEntity;
import com.zoranterhes.fileuploader.entity.FileOutputDTO;
import com.zoranterhes.fileuploader.repository.UploaderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.core.io.ByteArrayResource;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UploaderService {
    private final Logger log = LoggerFactory.getLogger(UploaderService.class);

    @Autowired
    private UploaderRepository uploaderRepository;

    @Value("${file.upload-dir}")
    private String FILE_PATH;

    public UploaderService() {
    }


    public ResponseEntity<Object> uploadToLocal(MultipartFile file) {
        String pathname = FILE_PATH + file.getOriginalFilename() + LocalDateTime.now();
        File convertedFile = new File(pathname);
        try {
            convertedFile.createNewFile();
            FileOutputStream fos = new FileOutputStream(convertedFile);
            fos.write(file.getBytes());
            fos.close();
        } catch (IOException e) {
            log.info(e.getMessage());
            return new ResponseEntity<>("Unsuccessful upload", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Succesfull upload", HttpStatus.OK);
    }

    public FileOutputDTO upload(MultipartFile file) {
        FileOutputDTO fileOutputDTO = new FileOutputDTO();
        try {
            FileEntity fileEntity = uploaderRepository.save(new FileEntity(
                    file.getOriginalFilename(),
                    file.getContentType(),
                    LocalDateTime.now(),
                    file.getBytes()));
            String downloadUrl= ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/download/")
                    .path(fileEntity.getFileId())
                    .toUriString();
            fileOutputDTO.setDownloadUrl(downloadUrl);
            fileOutputDTO.setId(fileEntity.getFileId());
            fileOutputDTO.setType(fileEntity.getFileType());
            fileOutputDTO.setMessage("Upload is successfull");
            fileOutputDTO.setUploaded(true);
            return fileOutputDTO;
        } catch (IOException e) {
            log.info(e.getMessage());
            fileOutputDTO.setMessage("Upload is unsuccessfull");
            return fileOutputDTO;
        }
    }

    public ResponseEntity<ByteArrayResource> get(String id) {
        Optional<FileEntity> fileEntity= uploaderRepository.findById(id);
        return fileEntity.map(entity -> ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(entity.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename= " + entity.getFileName())
                .body(new ByteArrayResource(entity.getFileData()))).orElseGet(() -> new ResponseEntity("File is not in database", HttpStatus.BAD_REQUEST));
    }
}
