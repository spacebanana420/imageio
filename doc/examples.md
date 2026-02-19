# imageio examples

This page shows a few examples on how to use the library

### Reading an 8bit image

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

To spare on excessive calls to ImageMagick, imageio does not preemptively know the resolution of your image, and so you must provide it as width and height arguments (1920 and 1080 example).

You can now retrieve a pixel from any point and obtain the value of the RGBA channels:

```java
RGBA8 pixel = image.getPixel8(560, 30); //Gets the pixel at X=560 and Y=30
byte red = pixel.red; //Signed 8bit value of the red channel

short[] channels = pixel.getChannels(); //Unsigned 8bit values of the RGBA channels inside 16bit (short) numbers
short red_unsigned = channels[0]; //First is red, followed by green, blue and alpha
```

You can also modify the image's pixels:

```java
pixel.red = 0;
//Removes red color from the original pixel
//This directly affects the pixel in your original image as it returns a reference to the pixel objects and not a copy
```
