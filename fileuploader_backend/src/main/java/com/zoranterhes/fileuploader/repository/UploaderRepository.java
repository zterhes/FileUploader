package com.zoranterhes.fileuploader.repository;

import com.zoranterhes.fileuploader.entity.FileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UploaderRepository extends JpaRepository<FileEntity,String > {
}
