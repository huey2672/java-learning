package com.huey.learning.java.concurrent.semaphore;

import java.util.concurrent.Semaphore;

class LoginQueue {

    private Semaphore semaphore;

    public LoginQueue(int slotLimit) {
        semaphore = new Semaphore(slotLimit);
    }

    public boolean tryLogin() {
        return semaphore.tryAcquire();
    }

    public void logout() {
        semaphore.release();
    }

    public int availableSlots() {
        return semaphore.availablePermits();
    }

}