package com.valtech.training.day3;

public class ThreadsTest {
	
	public static class PrinterThread extends Thread {
		
		@Override
		public void run() {
			
			for (int i = 0; i < 10; i++) {
				System.out.println(Thread.currentThread() + " " + i);
			}
			
		}
		
		public static class PrinterThreadByInterface implements Runnable {
			
			@Override
			public void run() {
				
				for (int i = 0; i < 10; i++) {
					System.out.println(Thread.currentThread() + " " + i);
				}
			}
		}
		
		public static void main(String[] args) {
			
			new PrinterThread().start();
			new PrinterThread().start();
			new Thread(new PrinterThreadByInterface()).start();
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					
					for (int i = 0; i < 10; i++) {
						System.out.println(Thread.currentThread() + " " + i);
					}
				}
			}).start();
			for (int i = 0; i < 10; i++) {
				System.out.println(Thread.currentThread() + " " + i);
			}
//				If priority is increased of a specific thread, then more CPU space will be given to that thread to finish it's task 
//				but that doesn't guarantee that the thread with a higher priority will finish first.
		}
		
	}

}
