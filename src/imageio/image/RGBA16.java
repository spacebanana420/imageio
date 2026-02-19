package imageio.image;

//Class for conveniently representing an RGBA 16bit/channel pixel
public class RGBA16 {
  public short red;
  public short green;
  public short blue;
  public short alpha;

  public RGBA16(short red, short green, short blue, short alpha) {
    this.red = red;
    this.green = green;
    this.blue = blue;
    this.alpha = alpha;
  }

  public RGBA16(int red, int green, int blue, int alpha) {
    this.red = (short)red;
    this.green = (short)green;
    this.blue = (short)blue;
    this.alpha = (short)alpha;
  }
  
  //Returns an array representing respectively red, green, blue and alpha channels
  public int[] getChannels() {
    return new int[] {
      toUnsigned(this.red),
      toUnsigned(this.green),
      toUnsigned(this.blue),
      toUnsigned(this.alpha)
    };
  }

  //Convert a signed byte into unsigned
  private static int toUnsigned(short number) {
    if (number > 0) return number;
    return Short.toUnsignedInt(number);
  }
}
