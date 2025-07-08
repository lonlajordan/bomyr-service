package com.bkr.reporting.constant;

import lombok.Getter;
import org.springframework.http.MediaType;

@Getter
public enum Extension {
    PDF(MediaType.APPLICATION_PDF),
    JPEG(MediaType.IMAGE_JPEG),
    JPG(MediaType.IMAGE_JPEG),
    GIF(MediaType.IMAGE_GIF),
    TIFF(MediaType.IMAGE_GIF),
    PNG(MediaType.IMAGE_PNG);

    private final MediaType type;

    Extension(MediaType type) {
        this.type = type;
    }
}
