package io.github.nebubit.hashimage;

import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import io.github.nebubit.hashimage.Implementation;

public class ImageHash {
    private Implementation implementation;

    public ImageHash (Implementation implementation) {
        this.implementation = implementation;
    }

    public Hash hash(String imagePath) throws java.io.IOException {
        BufferedImage img = ImageIO.read(new File(imagePath));

        return this.implementation.hash(img);
    }
}