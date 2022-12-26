package dev.changmin.image.uploader.business;

import org.springframework.http.codec.multipart.FilePart;
import reactor.core.publisher.Mono;

import java.io.File;

public interface ImageHandler {
    Mono<Void> writeImage(File imageFile);
}
