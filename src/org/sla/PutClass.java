package org.sla;

public class PutClass implements Runnable {
    private QueueClass sharedQueue;
    private int putId;
    private int puts;

    PutClass(QueueClass queueClass, int id, int howMany) {
        sharedQueue = queueClass;
        putId = id;
        puts = howMany;
    }

    @Override
    public void run() {
        for (int i = 0; i < puts; i++) {
            boolean putSuccessful = sharedQueue.put();
            while (!putSuccessful) {
                Thread.currentThread().yield();
                putSuccessful = sharedQueue.put();
            }
            System.out.println("Put thread " + String.valueOf(putId) + ": put " + i);
        }
        System.out.println("Put thread " + String.valueOf(putId) + ": DONE PUTTING");
    }
}
