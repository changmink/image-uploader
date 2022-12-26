package dev.changmin.image.uploader.controller;

import dev.changmin.image.uploader.business.*;
import dev.changmin.image.uploader.model.ResponseForm;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/image")
public class ImageController {
    private ImageHandler imageHandler;

    public ImageController(GoogleStorageImageHandler imageHandler) {
        this.imageHandler = imageHandler;
    }

    @PostMapping
    public Mono<ResponseForm> upload(Mono<FilePart> image) {
            return image.flatMap(imageFilePart -> {
                return imageHandler.writeImage(imageFilePart);
            }).thenReturn(new ResponseForm("Success", 0));
    }
}
