import imageio.image.*;
import imageio.wrapper.*;

public class frogtest {
  public static void main(String[] args) {
    autoTest();
    
    System.out.println("Testing 8bit image");
    pixelTest8();

    System.out.println("Testing 16bit image");
    pixelTest16();
  }

  static void autoTest() {
    Image frog = magick.readImage("frog.png");
    System.out.println("WIDTH " + frog.width + "\nHEIGHT " + frog.height + "\nDEPTH " + frog.depth + "\n");
  }

  static void pixelTest8() {
    Image frog = magick.readImage8("frog.png", 720, 720);
    RGBA8 pixel1 = frog.getPixel8(10, 0);
    RGBA8 pixel2 = frog.getPixel8(200, 100);
    RGBA8 pixel3 = frog.getPixel8(719, 719);
    printPixel(pixel1);
    printPixel(pixel2);
    printPixel(pixel3);
  }

  static void pixelTest16() {
    Image frog = magick.readImage16("frog.png", 720, 720);
    RGBA16 pixel = frog.getPixel16(0, 0);
    RGBA16 pixel2 = frog.getPixel16(200, 100);
    RGBA16 pixel3 = frog.getPixel16(719, 719);
    printPixel(pixel);
    printPixel(pixel2);
    printPixel(pixel3);
  }

  static void printPixel(RGBA8 pixel) {
    String message = "RED " + pixel.red + "\nGREEN " + pixel.green + "\nBLUE " + pixel.blue + "\nALPHA " + pixel.alpha + "\n";
    System.out.println(message);
  }

  static void printPixel(RGBA16 pixel) {
    String message = "RED " + pixel.red + "\nGREEN " + pixel.green + "\nBLUE " + pixel.blue + "\nALPHA " + pixel.alpha + "\n";
    System.out.println(message);
  }
}
