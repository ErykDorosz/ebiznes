package com.ebiznes.elektronik.controller;

import com.ebiznes.elektronik.dto.ImageResponse;
import com.ebiznes.elektronik.service.ImageService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Tag(name = "Image")
public class ImageController {

    private final ImageService imageService;

    @GetMapping("/images/{name}")
    public ImageResponse getImage(@PathVariable String name) {
        return imageService.getImage(name);
    }
}
