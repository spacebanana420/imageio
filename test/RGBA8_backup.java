package imageio.image;

//Image class for 8bit/channel RGBA format
//Idea: have this be a universal class, under the hood implementing all kinds of things (alpha or not, bit depth, etc) as separate subclasses
public class RGBA8 {
  public int width;
  public int height;
  public bool hasAlpha;
  
  public byte[] red;
  public byte[] green;
  public byte[] blue;
  public byte[] alpha;

  public RGBA8(int width, int height, bool hasAlpha) {
    this.width = width; this.height = height;
    int total_pixels = width*height;

    this.red = new byte[total_pixels];
    this.green = new byte[total_pixels];
    this.blue = new byte[total_pixels];
    if (hasAlpha) {
      this.alpha = new byte[total_pixels];
      this.hasAlpha = true;
    }
  }

  public RGBA8(int width, int height, byte[] red, byte[] green, byte[] blue) {
    this.red = red;
    this.green = green;
    this.blue = blue;
  }
  
  public RGBA8(int width, int height, byte[] red, byte[] green, byte[] blue, byte[] alpha) {
    this.red = red;
    this.green = green;
    this.blue = blue;
    this.alpha = alpha;
    this.hasAlpha = true;
  }

  //Returns an array representing respectively red, green, blue and alpha channels
  public short[] getPixel(int x, int y) {
    int i = getPixelIndex(x, y);
    if (this.hasAlpha) {
      return new short[] {
        toUnsigned(this.red[i]),
        toUnsigned(this.green[i]),
        toUnsigned(this.blue[i]),
        toUnsigned(this.alpha[i]),
      };
    }
    return new short[] {
      toUnsigned(this.red[i]),
      toUnsigned(this.green[i]),
      toUnsigned(this.blue[i]),
    };
  }

  public void setPixel(int x, int y, short[] pixel) {
    int i = getPixelIndex(x, y);
    this.red[i] = pixel[0];
    this.green[i] = pixel[1];
    this.blue[i] = pixel[2];
    if (this.hasAlpha) {
      this.alpha[i] = pixel[3];
    }
  }

  //Get the index for the RGB channel arrays, converting X and Y coordinates into a single-dimension number
  private int getPixelIndex(int x, int y) {return (this.width * y) + x;}

  //Convert a signed byte into unsigned
  private static short toUnsigned(byte number) {
    if (number > 0) return number;
    short difference = 128+number;
    return 128+difference;
  }
}
