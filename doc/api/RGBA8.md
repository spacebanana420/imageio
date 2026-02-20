# Class `RGBA8`
#### `imageio.image.RGBA8`

Stores the data of an 8bit pixel. You can store, read and modify the red, green, blue and alpha color channels.

### Constructors
```java
RGBA8(RGBA8 pixel)
```
Creates a new pixel object as a copy of another

```java
RGBA8(byte red, byte green, byte blue, byte alpha)
```
Creates a new pixel object, assigning it color values. The values themselves are 8bit signed, represented as `byte` (e.g 255 is -1).

```java
RGBA8(short red, short green, short blue, short alpha)
```
Creates a new pixel object, assigning it color values. The values themselves are 8bit unsigned, represented as `short`. Values should not go beyond 255.

### Fields
```java
int red
```
Signed 8bit value of the red channel, ranging between -128 and 127.

```java
int green
```
Signed 8bit value of the green channel, ranging between -128 and 127.

```java
int blue
```
Signed 8bit value of the blue channel, ranging between -128 and 127.

```java
int alpha
```
Signed 8bit value of the alpha channel, ranging between -128 and 127.

### Methods

```java
short red()
```
Returns the 8bit color value of the red channel, converted to unsigned. Ranges between 0 and 255.

```java
short green()
```
Returns the 8bit color value of the green channel, converted to unsigned. Ranges between 0 and 255.

```java
short blue()
```
Returns the 8bit color value of the blue channel, converted to unsigned. Ranges between 0 and 255.

```java
short alpha()
```
Returns the 8bit color value of the alpha channel, converted to unsigned. Ranges between 0 and 255.

```java
short[] getChannels()
```
Returns the 8bit color value of all channels at once by respective order (red, green, blue, alpha), converted to unsigned. Values range between 0 and 255.
