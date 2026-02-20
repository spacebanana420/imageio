package imageio.wrapper;

import imageio.image.*;
import java.util.ArrayList;

//The ImageMagick implementation for reading image files
//Byte order is forced to big-endian regardless of the machine
public class magick {
  //Read an image file and automatically detect width, height and bit depth
  //Has extra overhead compared to the other image reading functions here but it's more convenient to use
  public static Image readImage(String imagePath) {
    byte[] stdout = process.runProcess_stdout("magick", "identify", "-format", "%w %h %[bit-depth]", imagePath);
    if (stdout == null) return null;

    //Temporary variables used for retrieving witdth and height from the text-based standard output
    var builder = new StringBuilder();
    int saved_index = 0;

    //Get width string from stdout
    for (int i = 0; i < stdout.length; i++) {
      char c = (char)stdout[i];
      if (c == ' ') {
        saved_index = i+1;
        break;
      }
      builder.append(c);
    }
    String width_s = builder.toString();
    builder = new StringBuilder();

    //Get height string from stdout
    for (int i = saved_index; i < stdout.length; i++) {
      char c = (char)stdout[i];
      if (c == ' ') {
        saved_index = i+1;
        break;
      }
      builder.append(c);
    }
    String height_s = builder.toString();
    builder = new StringBuilder();

    //Get bit depth string from stdout
    for (int i = saved_index; i < stdout.length; i++) {
      char c = (char)stdout[i];
      builder.append(c);
    }    
    String depth = builder.toString();

    int width = Integer.parseInt(width_s);
    int height = Integer.parseInt(height_s);
    switch (depth) {
    case "8":
      return readImage8(imagePath, width, height);
    case "16":
      return readImage16(imagePath, width, height);
    }
    return null; //finish
  }
  
  //Read an 8bit image
  public static Image readImage8(String imagePath, int width, int height) {
    byte[] pixelStream = process.runProcess_stdout("magick", "-endian", "MSB", imagePath, "rgba:-");
    if (pixelStream == null) return null;
    
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
    byte[] pixelStream = process.runProcess_stdout("magick", "-endian", "MSB", imagePath, "rgba:-");
    if (pixelStream == null) return null;
    
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
