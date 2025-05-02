package com.test.test.note;


import java.io.IOException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ImageService {

    private final ImageRepository imageRepository;

    public String uploadImage(MultipartFile imagFile) throws IOException {
        var imageToSave = image.builder()
        .name(imagFile.getOriginalFilename())
        .type(imagFile.getContentType())
        .imageData(ImageUtils.compressImage(imagFile.getBytes()))
        .build();
        imageRepository.save(imageToSave);
        return "file upload successfully : " + imagFile.getOriginalFilename();
    }

}
