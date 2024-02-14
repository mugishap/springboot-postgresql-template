package com.mugishap.templates.springboot.v1.repositories;

import com.mugishap.templates.springboot.v1.enums.EFileStatus;
import com.mugishap.templates.springboot.v1.fileHandling.File;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IFileRepository extends JpaRepository<File, UUID> {
    Page<File> findAllByStatus(Pageable pageable, EFileStatus status);
    File getFileByName(String filename);

}
