package com.example.RentNest.Images;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/image")
public class ImageController {
    private final ImageService imageService;

    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }


    @PostMapping
    public ResponseEntity<?> uploadImage(@RequestParam MultipartFile file) throws IOException {
        String uploadImage = imageService.uploadImage(file);
        return ResponseEntity.status(HttpStatus.OK).body(uploadImage);
    }

    @DeleteMapping("{imageId}")
    public ResponseEntity<?> deleteImage(@PathVariable Long imageId)  {
        String deleteImage = imageService.deleteImage(imageId);
        return ResponseEntity.status(HttpStatus.OK).body(deleteImage);
    }

}
