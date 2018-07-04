package io.github.nebubit.hashimage;

import java.awt.image.BufferedImage;

public interface Implementation {
    public Hash hash(BufferedImage image);
}