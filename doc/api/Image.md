# Class `Image`
#### `imageio.image.Image`

Image stores the width, height, bit depth and pixel data of an image you read with `imageio.wrapper.magick`. This is a generic class that supports all imageio formats, and so it must be handled carefully in order to not get null values. All images are stored as RGBA regardless if the original image has an alpha channel or not.

### Constructors
```java
Image(int width, int height, int depth)
```
Creates a new empty Image object.

```java
Image(int width, int height, RGBA8[] pixels)
```
Creates a new 8bit image, assigning pixels to it. The pixel count must coincide with the multiplication of width and height.

```java
Image(int width, int height, RGBA16[] pixels)
```
Creates a new 16bit image, assigning pixels to it. The pixel count must coincide with the multiplication of width and height.

```java
Image(int width, int height, RGBA32[] pixels)
```
Creates a new 32bit image, assigning pixels to it. The pixel count must coincide with the multiplication of width and height.

### Fields
```java
int width
```
Stores the width of the image, measured in pixels.

```java
int height
```
Stores the height of the image, measured in pixels.

```java
int depth
```
Stores the bit depth of the image, measured in bits/channel. It can only either be `8`, `16` or `32`.

### Methods

```java
RGBA8 getPixel8(int x, int y)
```
Gets the 8bit image's pixel located at coordinates x,y. The coordinates 0,0 represent the first pixel.
If the image is not 16bit/channel (`Image.depth` not being 8), then a null value is returned, use the appropriate function.

```java
RGBA16 getPixel16(int x, int y)
```
Gets the 16bit image's pixel located at coordinates x,y. The coordinates 0,0 represent the first pixel.
If the image is not 16bit/channel (`Image.depth` not being 16), then a null value is returned, use the appropriate function.

```java
RGBA32 getPixel32(int x, int y)
```
Gets the 32bit image's pixel located at coordinates x,y. The coordinates 0,0 represent the first pixel.
If the image is not 32bit/channel (`Image.depth` not being 32), then a null value is returned, use the appropriate function.

```java
void setPixel(int x, int y, RGBA8 pixel)
```
Sets the 8bit image's pixel located at coordinates x,y. The coordinates 0,0 represent the first pixel.
If the image is not 8bit/channel (`Image.depth` not being 8), then nothing in the image changes.

```java
void setPixel(int x, int y, RGBA16 pixel)
```
Sets the 16bit image's pixel located at coordinates x,y. The coordinates 0,0 represent the first pixel.
If the image is not 16bit/channel (`Image.depth` not being 16), then nothing in the image changes.

```java
void setPixel(int x, int y, RGBA32 pixel)
```
Sets the 32bit image's pixel located at coordinates x,y. The coordinates 0,0 represent the first pixel.
If the image is not 32bit/channel (`Image.depth` not being 32), then nothing in the image changes.
