package com.huey.learning.java.concurrent.synchronizedkeyword;

public class TicketCase {

	public static void main(String[] args) {

		TicketMachine ticketMachine = new TicketMachine(3);
		
		Thread zhangsan = new Thread(new BuyTicketTask(ticketMachine, 2), "张三");
		Thread lisi = new Thread(new BuyTicketTask(ticketMachine, 2), "李四");
		
		zhangsan.start();
		lisi.start();

	}

}