package com.example.RentNest.Images;

import com.example.RentNest.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class ImageController {

    private final StorageService storageService;
    @Autowired
    public ImageController(StorageService storageService) {
        this.storageService = storageService;
    }

        @PostMapping("/upload")
        public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file) throws IOException {
            String responseMessage = storageService.uploadImage(file);
            if (responseMessage != null) {
                return new ResponseEntity<>(responseMessage, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Failed to upload the file", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

}
