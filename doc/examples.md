# imageio examples

This page shows a few examples on how to use the library

### Reading an image

imageio has multiple functions for reading an image file. These can be accessed from the `imageio.wrapper.magick` package. Functions that require you to preemptively know and specify the image's width, height and depth, such as `readImage8()` or `readImage16()` are more performant, while `readImage()` auto-detects the image's properties for you at the cost of extra overhead.

For reading an image automatically, import these classes:

```java
import imageio.image.Image; //Image class containing pixel data
import imageio.wrapper.magick; //ImageMagick implementation
```

You can read an image with:

```java
Image image = magick.readImage("/path/to/image.png");
```

You can obtain the previously-unknown width, height and bit depth of the image:

```java
int width = image.width;
int height = image.height;
int depth = image.depth;
```

### Reading an 8bit image

If you preemptively know that you are handling an 8bit image and you know its width and height, you can call `readImage8()` instead of `readImage()` to spare on CPU and memory, as this function does fewer checks for retrieving the image's properties.

Import these classes:
```java
import imageio.image.Image; //Image class containing pixel data
import imageio.image.RGBA8; //Class holding the 8bit RGBA values of an individual pixel
import imageio.wrapper.magick; //ImageMagick implementation
```

Using these 3 classes, you can read an image file:

```java
Image image = magick.readImage8("/path/to/image.png", 1920, 1080);
```

The width and height must match the image.

### Getting an image's pixels

Regardless of how you opened the image (`readImage()`, `readImage8()`, etc), the `Image` class supports all bit depths and differences, it's a generic and convenient class, but this means extra points of possible failure.

There are multiple functions to retrieve a pixel, depending on the image's bit depth. You need to know what bit depth the image has (e.g the `image.depth` example earlier) to know which function to call.

#### Getting an 8bit image's pixels

You can get a pixel from an image using:
```java
Image image = magick.readImage8("/path/to/image.png", 1920, 1080);

RGBA8 pixel = image.readPixel8(30, 0); //Gets the pixel at coordinates X=30 and Y=0
```

Since we are assuming it's an 8bit image, you use the function `readPixel8()` to retrieve a pixel. Using any other such as `readPixel16()` returns a null value because the image is not 16 or 32 bit. The class `RGBA8` can be imported from `imageio.image.RGBA8`.

You can now retrieve a pixel's color values from any point:

```java
RGBA8 pixel = image.getPixel8(560, 30); //Gets the pixel at X=560 and Y=30
byte red = pixel.red; //Signed 8bit value of the red channel
short red_unsigned = pixel.red(); //16bit value, representing an unsigned 8bit value of the red channel

short[] channels = pixel.getChannels(); //Unsigned 8bit values of the RGBA channels inside 16bit (short) numbers
short channel_red = channels[0]; //Same as pixel.red();
short channel_green = channels[1]; //Same as pixel.green()
short channel_blue = channels[2]; //Same as pixel.red()
```

You can also modify the image's pixels, but note that this also modifies the original image's pixel, as Image.getPixel8() returned a reference to the pixel and not a copy:

```java
pixel.red = 0;
//Removes red color from the original pixel
//This directly affects the pixel in your original image as it returns a reference to the pixel objects and not a copy
```

#### Getting a 16bit/32bit image's pixels

The logic behind retrieving the pixel is the same, except you use the Image class's functions `readPixel16()` for 16bit and `readPixel32()` for 32bit and these return the classes `RGBA16` and `RGBA32`, respectively. The rest is the same.

Here's an example on reading a 16bit image's pixel:

```java
Image image = magick.readImage16("/path/to/image");
RGBA16 pixel = image.getPixel16(10, 200); //X=10, Y=200

short red = pixel.red;
int red_unsigned = pixel.red();
```
