package com.zhandev.guardedBlock;

/**
 * Data is shared between two threads: producer and consumer 
 * the consumer thread must not attempt to retrieve the data before the producer thread has delivered it
 * the producer thread must not attempt to deliver new data if the consumer hasn't retrieved the old data
 */
public class ProducerConsumerExample {

	public static void main(String[] args) {
		Drop drop = new Drop();
		
		(new Thread(new Producer(drop))).start();
		(new Thread(new Consumer(drop))).start();
	}
}
