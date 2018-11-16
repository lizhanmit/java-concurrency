package com.zhandev.guardedBlock;

import java.util.Random;

public class Producer implements Runnable {

	private Drop drop;
	
	public Producer(Drop drop) {
		this.drop = drop;
	}

	@Override
	public void run() {
		String messages[] = {
				"This is the 1st message.", 
				"2nd message.",
				"3rd message."
		};
		
		Random random = new Random();
		
		for (String message : messages) {
			drop.put(message);
			
			try {
				Thread.sleep(random.nextInt(5000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		// after putting all messages, put "DONE" to indicate it is the end 
		drop.put("DONE");
	} 
	
}
