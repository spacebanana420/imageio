import imageio.image.*;
import imageio.wrapper.*;

public class frogtest {
  public static void main(String[] args) {
    Image frog = magick.readImage8("frog.png", 720, 720);
    RGBA8 pixel1 = frog.getPixel8(10, 0);
    RGBA8 pixel2 = frog.getPixel8(200, 100);
    RGBA8 pixel3 = frog.getPixel8(719, 719);
    printPixel(pixel1);
    printPixel(pixel2);
    printPixel(pixel3);
  }

  static void printPixel(RGBA8 pixel) {
    String message = "RED " + pixel.red + "\nGREEN " + pixel.green + "\nBLUE " + pixel.blue + "\nALPHA " + pixel.alpha + "\n";
    System.out.println(message);
  }
}
