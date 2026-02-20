package imageio.image;

//Class for conveniently representing an RGBA 8bit/channel pixel
public class RGBA8 {
  public byte red;
  public byte green;
  public byte blue;
  public byte alpha;

  public RGBA8(RGBA8 pixel) {
    this.red = pixel.red;
    this.green = pixel.green;
    this.blue = pixel.blue;
    this.alpha = pixel.alpha;
  }

  public RGBA8(byte red, byte green, byte blue, byte alpha) {
    this.red = red;
    this.green = green;
    this.blue = blue;
    this.alpha = alpha;
  }

  public RGBA8(short red, short green, short blue, short alpha) {
    this.red = (byte)red;
    this.green = (byte)green;
    this.blue = (byte)blue;
    this.alpha = (byte)alpha;
  }

  public short red() {return toUnsigned(this.red);}
  public short green() {return toUnsigned(this.green);}
  public short blue() {return toUnsigned(this.blue);}
  public short alpha() {return toUnsigned(this.alpha);}
  
  //Returns an array representing respectively red, green, blue and alpha channels
  public short[] getChannels() {
    return new short[] {
      toUnsigned(this.red),
      toUnsigned(this.green),
      toUnsigned(this.blue),
      toUnsigned(this.alpha)
    };
  }

  //Convert a signed byte into unsigned
  private static short toUnsigned(byte number) {
    if (number > 0) return number;
    return (short)(256+number);
  }
}
