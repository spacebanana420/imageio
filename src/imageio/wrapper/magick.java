package imageio.wrapper;

import imageio.image.*;
import java.util.ArrayList;

//The ImageMagick implementation for reading image files
public class magick {
  //Read an 8bit image
  public static Image readImage8(String imagePath, int width, int height) {
    byte[] pixelStream = process.runProcess_stdout("magick", imagePath, "rgba:-");
    
    var pixels = new ArrayList<RGBA8>(); 
    for (int i = 0; i < pixelStream.length;) {
      byte red = pixelStream[i];
      byte green = pixelStream[i+1];
      byte blue = pixelStream[i+2];
      byte alpha = pixelStream[i+3];
      RGBA8 pixel = new RGBA8(red, green, blue, alpha);
      pixels.add(pixel);
      i+=4;
    }
    return new Image(width, height, pixels.toArray(new RGBA8[0]));
  }
}
