package com.huey.learning.java.concurrent.synchronizedkeyword;

public class TicketMachine {

    private int ticketQuantity;

    public TicketMachine(int ticketQuantity) {
        this.ticketQuantity = ticketQuantity;
    }

    public synchronized void sellTicket() {
        String name = Thread.currentThread().getName();
        System.out.printf("【%s】：正在为您检查是否还有余票…\n", name);
        if (ticketQuantity > 0) {
            System.out.printf("【%s】：当前仍有余票 %d 张。\n", name, ticketQuantity);
            try {
                System.out.printf("【%s】：正在为您出票，请等待。\n", name);
                Thread.sleep(100L);
                ticketQuantity--;
                System.out.printf("【%s】：完成出票。\n", name);
                if (ticketQuantity >= 0) {
                    System.out.printf("【%s】：当前余票为 %d 张。\n", name, ticketQuantity);
                }
                else {
                    throw new RuntimeException(String.format("系统异常：当前余票为 %d 张。", ticketQuantity));
                }
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        else {
            System.out.printf("【%s】：票券已售完，停止售票。\n", name);
        }
    }

}