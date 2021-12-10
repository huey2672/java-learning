package com.huey.learning.java.concurrent.synchronizedkeyword;

public class SynchronizedClassCase {

	public static void main(String[] args) {

		SynchronizedClass synchronizedObject = new SynchronizedClass();

		Thread threadA = new Thread(new TaskA(synchronizedObject));
		Thread threadB = new Thread(new TaskB(synchronizedObject));

		threadA.start();
		threadB.start();

	}

}