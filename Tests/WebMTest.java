import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import org.junit.Test;

import java.io.*;

public class WebMTest {

    @Test
    public void test() throws IOException, ImageProcessingException {
        ImageMetadataReader.readMetadata(new File(("/home/artemklyuev/Downloads/file_example_WEBM_480_900KB.webm")));
    }
}
