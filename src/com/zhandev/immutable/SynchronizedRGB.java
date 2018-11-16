package com.zhandev.immutable;

public class SynchronizedRGB {

	// Values must be between 0 and 255.
	private int red;
	private int green;
	private int blue; 
	private String name;
	
	public SynchronizedRGB(int red, int green, int blue, String name) {
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
	
	public void set(int red, int green, int blue, String name) {
		check(red, green, blue);
		// use synchronized statement to avoid thread interference and memory consistency errors 
		// when more than one thread invokes set() method for the same object
		synchronized (this) {
			this.red = red;
			this.green = green;
			this.blue = blue;
			this.name = name;
		}
	}
	
	public int getRGB() {
        return ((red << 16) | (green << 8) | blue);
    }
	
	public String getName() {
        return name;
    }
	
	public synchronized void invert() {
		red = 255 - red; 
		green = 255 - green; 
		blue = 255 - blue;
		name = "Inverse of " + name;
	}
}
