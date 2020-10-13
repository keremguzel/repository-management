package com.example.nk.serviceImpl;

import com.example.nk.Exception.FileStorageException;
import com.example.nk.service.FileService;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
@Service
public class FileServiceImpl implements FileService {

  @Value("${app.upload.dir:${user.home}}")
  public String uploadDir;

@Override
  public String uploadFile(MultipartFile file) {

    try {
      String name = String.format("%s.%s", RandomStringUtils.randomAlphanumeric(8), StringUtils.cleanPath(file.getOriginalFilename()));

      Path copyLocation = Paths
          .get(uploadDir + File.separator + name);
      Files.copy(file.getInputStream(), copyLocation, StandardCopyOption.REPLACE_EXISTING);
      return copyLocation.toString();
    } catch (Exception e) {
      e.printStackTrace();
      throw new FileStorageException("Could not store file " + file.getOriginalFilename()
          + ". Please try again!");
    }
  }
}
