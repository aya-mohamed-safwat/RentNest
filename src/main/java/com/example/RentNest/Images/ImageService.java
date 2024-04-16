package com.example.RentNest.Images;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.awt.*;


@Service
public class ImageService {

    @Autowired
    private ImageRepository imageRepository;

    @Autowired
    public ImageService(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    public Image saveImage(Image image) {
        return imageRepository.save(image);
    }

    public void deleteImage(Long id) {
        imageRepository.deleteById(id);
    }

    public Image updateImage(Long id, Image newImage) {
        if (imageRepository.existsById(id)) {
            newImage.setId(id);
            return imageRepository.save(newImage);
        } else {
            return null;
        }
    }
}
