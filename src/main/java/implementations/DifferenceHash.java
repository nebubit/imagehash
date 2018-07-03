package io.github.nebubit.hashimage.implementations;

import io.github.nebubit.hashimage.Implementation;
import io.github.nebubit.hashimage.Hash;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.Color;

public class DifferenceHash implements Implementation {
    private int size;

    DifferenceHash(int size) {
        this.size = size;
    }

    public Hash hash(Image image) {
        int width = this.size + 1;
        int height = this.size;

        Image resizedImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        boolean[][] bits = new boolean[height][width];

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

                bits[y][x] = left > right;
            }

        }

        return new Hash(bits);
    }
}
