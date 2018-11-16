package com.zhandev.immutable;

import java.util.Random;

public class ImmutableRGBExample {

	ImmutableRGB immutableColor = new ImmutableRGB(0, 0, 0, "Pitch Black");
	
	public static void main(String[] args) {
		ImmutableRGBExample immutableRGB = new ImmutableRGBExample();
		
		// outputs of color name are the same
		(new Thread(immutableRGB.new GetRGB())).start();
		(new Thread(immutableRGB.new InvertRGB())).start();
	}
	
	private class GetRGB implements Runnable {
		
		@Override
		public void run() {
			System.out.println(immutableColor.getRGB());
			
			Random random = new Random();
			try {
				Thread.sleep(random.nextInt(5000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println(immutableColor.getName());
		}
	}
	
	private class InvertRGB implements Runnable {
		
		@Override
		public void run() {
			// invert() will create another new object 
			immutableColor.invert();
			// name of immutableColor will not be changed
			System.out.println(immutableColor.getName());
		}
		
	}
}
