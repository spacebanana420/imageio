package imageio.image;

//Class for conveniently representing an RGBA 32bit/channel pixel
public class RGBA32 {
  public int red;
  public int green;
  public int blue;
  public int alpha;

  public RGBA32(int red, int green, int blue, int alpha) {
    this.red = red;
    this.green = green;
    this.blue = blue;
    this.alpha = alpha;
  }

  public RGBA32(long red, long green, long blue, long alpha) {
    this.red = (int)red;
    this.green = (int)green;
    this.blue = (int)blue;
    this.alpha = (int)alpha;
  }
  
  //Returns an array representing respectively red, green, blue and alpha channels
  public long[] getChannels() {
    return new long[] {
      toUnsigned(this.red),
      toUnsigned(this.green),
      toUnsigned(this.blue),
      toUnsigned(this.alpha)
    };
  }

  //Convert a signed byte into unsigned
  private static long toUnsigned(int number) {
    if (number > 0) return number;
    return Integer.toUnsignedLong(number);
  }
}
