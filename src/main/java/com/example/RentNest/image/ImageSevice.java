package com.example.RentNest.image;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;
import java.util.zip.DataFormatException;

@Service
public class ImageSevice {
    @Autowired
    private final ImageRepository imageRepository;

    public ImageSevice(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    public String uploadImage(MultipartFile imageFile, String entityType, Long entityId) throws IOException {
        var imageToSave = Image.builder()
                .name(UUID.randomUUID() + "." + imageFile.getContentType().split("/")[1])
                .contentType(imageFile.getContentType())
                .entityType(ImageEntityType.valueOf(entityType))
                .entityId(entityId)
                .imageData(ImageUtils.compressImage(imageFile.getBytes()))
                .build();
        Image image = imageRepository.save(imageToSave);
        return image.getName();
    }

    public Image getByName(String name) throws DataFormatException, IOException {
        return imageRepository.findByName(name).orElseThrow();
    }

    public List<Image> getByEntityId(Long entityId,ImageEntityType entityType) throws DataFormatException, IOException {
        return  imageRepository.findByEntityIdAndEntityType(entityId , entityType).orElseThrow();
    }

    public boolean deleteImageByName(String name) {
        Optional<Image> imageOptional = imageRepository.findByName(name);
        if (imageOptional.isPresent()) {
            imageRepository.deleteByName(name);
            return true;
        }
        return false;
    }
}
