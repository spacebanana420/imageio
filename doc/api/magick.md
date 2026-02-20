# Class `magick`
#### `imageio.wrapper.magick`

This class executes ImageMagick to open and decode image files. You can use its functions to read an image.


### Methods

```java
static Image readImage(String imagePath)
```
Reads an image file found in path `imagePath` and returns it as an `Image` object. If ImageMagick is not installed in your system, the path is invalid or the image reading process fails for any other reason, this function returns `null` instead.

The path can be relative or absolute. If you don't know the resolution and bit depth of the image you are trying to read, use this function, otherwise use the ones below as they have less CPU and memory overhead.

```java
static Image readImage8(String imagePath, int width, int height)
```
Reads an image file as 8bit/channel. If ImageMagick is not installed in your system, the path is invalid or the image reading process fails for any other reason, this function returns `null` instead.

Use this instead of `readImage()` if you know the image's resolution and bit depth. Incorrect bit depth or resolution will result in incorrect decoding

```java
static Image readImage16(String imagePath, int width, int height)
```
Reads an image file as 16bit/channel. If ImageMagick is not installed in your system, the path is invalid or the image reading process fails for any other reason, this function returns `null` instead.

Use this instead of `readImage()` if you know the image's resolution and bit depth. Incorrect bit depth or resolution will result in incorrect decoding
