# imageio Overview

imageio is a library for reading and writing image files of various formats. This is a wrapper library and depends on ImageMagick being installed in your system to work.

imageio runs ImageMagick as a subprocess to direclty retrieve the raw pixel stream of an image from standard output, to then save it in a Java class. You can read an image with the functions found in the `imageio.wrapper.magick` class.

Once read, the image is returned as an `Image` object, a simple class which contains the width, height, bit depth and raw pixel data of an image. For simplicity, all images are read as RGBA regardless if they have an alpha channel or not. For convenience, pixels are represented as an `RGBA8`, `RGBA16` or `RGBA32` class. These classes let you view and modify the color channels of red, green, blue and alpha of a pixel. Color values can be read as signed (`byte` for 8bit) or unsigned (`short` for 8bit). You can also modify an image's pixels.

## Setting up imageio and using it in your project

You can directly add the source code of imageio and import it from your own, or download the latest library JAR found in the releases page and also import it.

imageio depends on [ImageMagick](https://imagemagick.org/) to work. This program must be installed in your system (in your `$PATH` environment variable on UNIX, or `%PATH%` on Windows). imageio itself is platform-agnostic, it will run on any platform ImageMagick also runs on, which is pretty much everything.


## Getting started

To read an image file with imageio, it's recommended you use these classes:

```java
import imageio.wrapper.magick; //Uses ImageMagick to open and decode image files
import imageio.image.*; //Classes for storing image and pixel data
```

The quickest way to read an image file is to use `magick.readImage()`:

```java
Image image = magick.readImage("/path/to/image.png");
```

If you already know the bit depth and resolution of your image, it's recommended instead to use `readImage8()`, `readImage16()` or `readImage32()` as they have lower CPU and memory overhead.

The Image class holds all your pixel data, but it is a generic class that can support any pixel formats. Because of this, you must check (or preemptively know) the bit depth of your image to see which functions you can use:

```java
System.out.println(image.depth); //Let's assume it prints "8", meaning the image is 8bits/channel

//In that case, you use the 8bit Image functions and the RGBA8 pixel class
RGBA8 pixel = image.getPixel8(30, 60); //Get pixel at coordinates X=30, Y=60

//Now you can retrieve the individual color values of a pixel
byte red = pixel.red; //Signed 8bit value, between -128 and 127
short unsigned_red = pixel.red(); //Unsigned 8bit value, between 0 and 256

//Trying to retrieve pixels of a different bit depth will result in null value
RGBA16 pixel = image.getPixel16(30, 60); //Returns null because the image's bit depth is 8 and not 16
```

More detailed examples can be found in the [Examples](examples.md) page.
