package com.example.RentNest.image;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.zip.DataFormatException;

@RestController
@RequestMapping("/image")
@RequiredArgsConstructor
public class ImageController {

    private final ImageSevice imageService;

    @PostMapping
    public ResponseEntity<?> uploadImage(@RequestParam("image") MultipartFile file,
                                         @RequestParam("entity_type") String entityType,
                                         @RequestParam("entity_id") Long entityId) throws IOException {
        String uploadImage = imageService.uploadImage(file, entityType, entityId);
        return ResponseEntity.status(HttpStatus.OK).body(uploadImage);
    }



    @GetMapping("/{name}")
    public ResponseEntity<?> view(@PathVariable String name) throws IOException, DataFormatException {
        Image image = imageService.getByName(name);
        byte[] imageData = ImageUtils.decompressImage(image.getImageData());

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.valueOf(image.getContentType()));

       return new ResponseEntity<>(imageData, headers, HttpStatus.OK);
    }

    @GetMapping("/viewByEntityId/{entityId}/{entityType}")
    public ResponseEntity<?> viewByEntityId(@PathVariable Long entityId ,@PathVariable ImageEntityType entityType) throws IOException, DataFormatException {

        List<Image> images = imageService.getByEntityId(entityId,entityType);
        List<String> imagesLink = images.stream().map(image -> "https://rentnest.onrender.com/image/" +image.getName())
                .collect(Collectors.toList());

        return ResponseEntity.ok(imagesLink);
    }
}
