package com.zoranterhes.fileuploader.entity;

import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
public class FileEntity {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String fileId;
    private String fileName;
    private String fileType;
    private LocalDateTime uploadingTime;
    @Lob
    private byte[] fileData;

    public FileEntity(String fileName, String fileType, LocalDateTime uploadingTime, byte[] fileData) {
        this.fileName = fileName;
        this.fileType = fileType;
        this.uploadingTime=uploadingTime;
        this.fileData = fileData;
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public byte[] getFileData() {
        return fileData;
    }

    public void setFileData(byte[] fileData) {
        this.fileData = fileData;
    }

    public LocalDateTime getUploadingTime() {
        return uploadingTime;
    }

    public void setUploadingTime(LocalDateTime uploadingTime) {
        this.uploadingTime = uploadingTime;
    }

    @Override
    public String toString() {
        return "FileEntity{" +
                "fileId='" + fileId + '\'' +
                ", fileName='" + fileName + '\'' +
                ", fileType='" + fileType + '\'' +
                ", uploadingTime='" + uploadingTime + '\'' +
                '}';
    }
}
