package com.huey.learning.java.concurrent.synchronizedkeyword;

public class BuyTicketTask implements Runnable {

    private TicketMachine ticketMachine;
    private int times;

    public BuyTicketTask(TicketMachine ticketMachine, int times) {
        this.ticketMachine = ticketMachine;
        this.times = times;
    }

    @Override
    public void run() {
        for (int i = 0; i < times; i++) {
            ticketMachine.sellTicket();
        }
    }

}