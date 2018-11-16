package com.zhandev.immutable;

// no setter method in this class
final public class ImmutableRGB {

	final private int red; 
	final private int green; 
	final private int blue; 
	final private String name; 
	
	public ImmutableRGB(int red, int green, int blue, String name) {
		check(red, green, blue); // before creating the new instance, check if the value of RGB is valid
		this.red = red;
		this.green = green;
		this.blue = blue;
		this.name = name;
	}
	
	private void check(int red, int green, int blue) {
		if (red < 0 || red > 255 
			|| green < 0 || green > 255 
			|| blue < 0 || blue > 255) {
			throw new IllegalArgumentException();
		}
	}
	
	public int getRGB() {
        return ((red << 16) | (green << 8) | blue);
    }
	
	public String getName() {
        return name;
    }
	
	public ImmutableRGB invert() {
		// return a new object instead of modifying the original one
		return new ImmutableRGB(255 - red, 255 - green, 255 - blue, "Inverse of " + name); 
	}
}
