package imageio.image;

//Image objects represent an image, holding all of its pixel data as well as width, height and bit depth (per channel)
//Has very slight CPU and memory overhead but it's very convenient to use
public class Image {
  public int width;
  public int height;
  public int depth;

  //Arrays of pixel objects. Only one of these is used, the one that corresponds to the image's bit depth
  private RGBA8[] rgba8;
  private RGBA16[] rgba16;
  private RGBA32[] rgba32;

  //Create new empty image
  public Image(int width, int height, int depth) {
    this.width = width;
    this.height = height;
    this.depth = depth;
    int total_pixels = width*height;

    switch(depth) {
      case 8:
        this.rgba8 = new RGBA8[total_pixels];
        break;
      case 16:
        this.rgba16 = new RGBA16[total_pixels];
        break;
      case 32:
        this.rgba32 = new RGBA32[total_pixels];
    }
  }

  //Create image with existing pixel data
  public Image(int width, int height, RGBA8[] pixels) {
    this.width = width;
    this.height = height;
    this.depth = 8;
    this.rgba8 = pixels;
  }

  //Create image with existing pixel data
  public Image(int width, int height, RGBA16[] pixels) {
    this.width = width;
    this.height = height;
    this.depth = 16;
    this.rgba16 = pixels;
  }

  //Create image with existing pixel data
  public Image(int width, int height, RGBA32[] pixels) {
    this.width = width;
    this.height = height;
    this.depth = 32;
    this.rgba32 = pixels;
  }

  //Returns an array representing respectively red, green, blue and alpha channels
  //TODO: clone pixels instead of returning a reference to the original ones?
  public RGBA8 getPixel8(int x, int y) {
    if (this.depth != 8) return null;
    int i = getPixelIndex(x, y);
    return this.rgba8[i];
  }

  public RGBA16 getPixel16(int x, int y) {
    if (this.depth != 16) return null;
    int i = getPixelIndex(x, y);
    return this.rgba16[i];
  }

  public RGBA32 getPixel32(int x, int y) {
    if (this.depth != 32) return null;
    int i = getPixelIndex(x, y);
    return this.rgba32[i];
  }

  public void setPixel(int x, int y, RGBA8 pixel) {
    if (this.depth != 8) return;
    int i = getPixelIndex(x, y);
    this.rgba8[i] = pixel;
  }

  public void setPixel(int x, int y, RGBA16 pixel) {
    if (this.depth != 16) return;
    int i = getPixelIndex(x, y);
    this.rgba16[i] = pixel;
  }

  public void setPixel(int x, int y, RGBA32 pixel) {
    if (this.depth != 32) return;
    int i = getPixelIndex(x, y);
    this.rgba32[i] = pixel;
  }

  //Index to use to retrieve a specific pixel according to given coordinates
  private int getPixelIndex(int x, int y) {return (this.width * y) + x;}
}
