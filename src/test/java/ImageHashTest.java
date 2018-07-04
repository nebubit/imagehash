import org.junit.Test;
import static org.junit.Assert.*;
import io.github.nebubit.hashimage.ImageHash;
import io.github.nebubit.hashimage.Hash;
import io.github.nebubit.hashimage.implementations.DifferenceHash;
import java.io.File;
import java.io.IOException;


public class ImageHashTest {
    @Test
    public void testDifferenceHash() throws java.io.IOException {
        String imagePath = "src/test/java/resources/images/office/tumblr_ndyfnr7lk21tubinno1_1280.jpg";
        File file = new File(imagePath);
        assertTrue(file.exists());

        ImageHash imageHash = new ImageHash(new DifferenceHash());
        Hash hash = imageHash.hash(imagePath);
        assertEquals("1841248008a08000", hash.toString());
    }

    @Test
    public void testDifferenceHashComparesForestImages() throws java.io.IOException {
        String imagePath = "src/test/java/resources/images/forest/forest-high.jpg";
        File file = new File(imagePath);
        assertTrue(file.exists());
        ImageHash imageHash = new ImageHash(new DifferenceHash());
        Hash hash = imageHash.hash(imagePath);

        imagePath = "src/test/java/resources/images/forest/forest-copyright.jpg";
        file = new File(imagePath);
        assertTrue(file.exists());
        imageHash = new ImageHash(new DifferenceHash());
        Hash hash2 = imageHash.hash(imagePath);

        assertEquals(2, hash.distance(hash2));
    }
}