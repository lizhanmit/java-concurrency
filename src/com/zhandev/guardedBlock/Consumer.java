package com.zhandev.guardedBlock;

import java.util.Random;

public class Consumer implements Runnable {

	private Drop drop;

	public Consumer(Drop drop) {
		this.drop = drop;
	}
	
	@Override
	public void run() {
		Random random = new Random();
		
		// take messages until it is "DONE"
		for (String message = drop.take(); ! message.equals("DONE"); message = drop.take()) {
			System.out.println("Message received: " + message);
			try {
				Thread.sleep(random.nextInt(5000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	} 
	
	
}
