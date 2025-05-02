package com.test.test.note;

import java.io.IOException;
import java.util.Optional;
import java.util.zip.DataFormatException;
import org.apache.commons.lang3.exception.ContextedRuntimeException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import jakarta.transaction.Transactional;
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


    @Transactional
    public byte [] downloadImage (String imageName) {
        Optional<image> dbImage = imageRepository.findByName(imageName);

        return dbImage.map(image -> {
            try {
                return ImageUtils.decompressImage(image.getImageData());
            } catch (DataFormatException | IOException e) {
                throw new ContextedRuntimeException("Error downloading an image", e)
                .addContextValue("Image ID", image.getId())
                .addContextValue("Image name", imageName);
            }
        }).orElse(null);
    


    }

}
