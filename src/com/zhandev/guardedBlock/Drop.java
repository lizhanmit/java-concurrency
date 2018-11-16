package com.zhandev.guardedBlock;

// equivalent to util class
public class Drop {

	// message sent from producer to consumer
	private String message; 
	
	// indicates if message channel is empty or not
	// true: consumer should wait for producer to send message
	// false: producer should wait for consumer to retrieve message
	private boolean empty = true;   
	
	public synchronized String take() {
		while (empty) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		// after taking messages, the channel becomes empty
		empty = true; 
		// notify all producers that messages have been taken, the channel is empty now
		notifyAll();
		return message;
	}
	
	public synchronized void put(String message) {
		while (!empty) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		// after putting messages, the channel becomes non-empty 
		empty = false;
		this.message = message;
		// notify all consumers that there are new messages to take in the channel
		notifyAll();
	}
	
}
