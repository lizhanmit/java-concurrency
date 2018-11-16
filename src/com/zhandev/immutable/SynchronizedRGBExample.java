package com.zhandev.immutable;

import java.util.Random;

public class SynchronizedRGBExample {

	SynchronizedRGB color = new SynchronizedRGB(0, 0, 0, "Pitch Black");
	
	public static void main(String[] args) {
		
		SynchronizedRGBExample syncRGB = new SynchronizedRGBExample();
		
		// name of the color may be modified before getName() 
		// as a result, RGB of the color will not match its name
		// output could be "Black" rather than "Pitch Black"
		(new Thread(syncRGB.new GetRGB())).start();
		(new Thread(syncRGB.new SetRGB())).start();
		
		// as getRGB() and getName() are in the synchronized block
		// name of the color is modified after getName()
		// output will always be "Pitch Black"
		(new Thread(syncRGB.new SynchronizedGetRGB())).start();
		(new Thread(syncRGB.new SetRGB())).start();
	}
	
	private class GetRGB implements Runnable {
		
		@Override
		public void run() {
			System.out.println(color.getRGB());
			
			Random random = new Random();
			try {
				Thread.sleep(random.nextInt(5000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println(color.getName());
		}
	}
	
	private class SynchronizedGetRGB implements Runnable {
		
		@Override
		public void run() {
			synchronized (color) {
				System.out.println(color.getRGB());
				Random random = new Random();
				try {
					Thread.sleep(random.nextInt(5000));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(color.getName());
			}
		}
		
	}
	
	private class SetRGB implements Runnable {
		
		@Override
		public void run() {
			Random random = new Random();
			try {
				Thread.sleep(random.nextInt(5000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			color.set(0, 0, 0, "Black");
		}
	}
}

