package com.ebiznes.elektronik.service;

import com.ebiznes.elektronik.dto.ImageResponse;
import lombok.val;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Base64;

@Service
public class ImageService {

    @Value("${app.uploadDir}")
    private String uploadDir;

    public ImageResponse getImage(String imageName) {
        File file = new File(uploadDir + "/" + imageName);

        try(FileInputStream fileInputStream = new FileInputStream(file)) {
            byte[] bytes = new byte[(int) file.length()];
            fileInputStream.read(bytes);
            val encodedImage = Base64.getEncoder().encodeToString(bytes);
            return new ImageResponse(encodedImage);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
