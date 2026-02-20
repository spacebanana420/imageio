package imageio.wrapper;

import imageio.image.*;
import java.util.ArrayList;

//The ImageMagick implementation for reading image files
//Byte order is forced to big-endian regardless of the machine
public class magick {
  //Read an 8bit image
  public static Image readImage8(String imagePath, int width, int height) {
    byte[] pixelStream = process.runProcess_stdout("magick", "-depth", "8", "-endian", "MSB", imagePath, "rgba:-");
    
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

  //Read a 16bit image
  public static Image readImage16(String imagePath, int width, int height) {
    byte[] pixelStream = process.runProcess_stdout("magick", "-depth", "16", "-endian", "MSB", imagePath, "rgba:-");
    
    var pixels = new ArrayList<RGBA16>(); 
    for (int i = 0; i < pixelStream.length;) {
      short red = getShort(pixelStream[i], pixelStream[i+1]);
      short green = getShort(pixelStream[i+2], pixelStream[i+3]);
      short blue = getShort(pixelStream[i+4], pixelStream[i+5]);
      short alpha = getShort(pixelStream[i+6], pixelStream[i+7]);
      RGBA16 pixel = new RGBA16(red, green, blue, alpha);
      pixels.add(pixel);
      i+=8;
    }
    return new Image(width, height, pixels.toArray(new RGBA16[0]));
  }

  //Packing bytes into single numeric values, big-endian order
  private static short getShort(byte digit1, byte digit2) {return (short)((digit1<<8) + digit2);}
}
