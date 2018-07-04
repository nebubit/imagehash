package io.github.nebubit.hashimage.implementations;

import io.github.nebubit.hashimage.Implementation;
import io.github.nebubit.hashimage.Hash;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.util.Arrays;
import javax.imageio.ImageIO;
import java.io.File;

public class DifferenceHash implements Implementation {
    private int size;

    public DifferenceHash() {
        this.size = 8;
    }

    public DifferenceHash(int size) {
        this.size = size;
    }

    public Hash hash(BufferedImage image) {
        int width = this.size + 1;
        int height = this.size;

        BufferedImage bufferedImage = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
        Image resizedImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        bufferedImage.createGraphics().drawImage(resizedImage, 0, 0, null);

        boolean[] bits = new boolean[this.size * this.size];

        for(int y = 0; y < height; y++) {
            Color pixelColor = new Color(bufferedImage.getRGB(0, y));

            int left = (int) Math.floor(pixelColor.getRed() * 0.299
                                        + pixelColor.getGreen() * 0.587
                                        + pixelColor.getBlue() * 0.114);
            for (int x = 1; x < width; x++) {
                pixelColor = new Color(bufferedImage.getRGB(x, y));
                int right = (int) Math.floor(pixelColor.getRed() * 0.299
                                             + pixelColor.getGreen() * 0.587
                                             + pixelColor.getBlue() * 0.114);

                bits[(y + 1) * (x - 1)] = (boolean)(left > right);

                left = right;
            }

        }

        return new Hash(bits);
    }
}
