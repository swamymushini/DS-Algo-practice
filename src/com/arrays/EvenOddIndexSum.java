package com.arrays;

import java.util.Arrays;

public class EvenOddIndexSum implements Runnable {

	static volatile int count = 1;

	public static void main(String[] args) throws InterruptedException {
		String s = "gopala swamy gopala swamy";
		String res = Arrays.asList(s.split(" ")).stream().reduce((a, b) -> a + b).get();
		System.out.println(res);

		Thread t1 = new Thread(new EvenOddIndexSum());
		Thread t2 = new Thread(new EvenOddIndexSum());
		Thread t3 = new Thread(new EvenOddIndexSum());
		Thread t4 = new Thread(new EvenOddIndexSum());
		Thread t5 = new Thread(new EvenOddIndexSum());

		t1.start();
		t1.join();
		t2.start();
		t2.join();
		t3.start();
		t3.join();
		t4.start();
		t4.join();
		t5.start();
		t5.join();

	}

	public void run() {
		System.out.println(count++);
	}

}
