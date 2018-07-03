package io.github.nebubit.hashimage;

import java.awt.Image;
import javax.imageio.ImageIO;
import java.io.File;
import io.github.nebubit.hashimage.Implementation;

class ImageHash {
	protected Implementation implementation;

	ImageHash (Implementation implementation){
		this.implementation = implementation;
	}

	public Hash hash(String imagePath) throws java.io.IOException {
		Image img = ImageIO.read(new File(imagePath));

		return this.implementation.hash(img);
	}
}