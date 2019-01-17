package org.sla;

public class GetClass implements Runnable {
    private QueueClass sharedQueue;
    private int getId;
    private int gets;

    GetClass(QueueClass queueClass, int id, int howMany) {
        sharedQueue = queueClass;
        getId = id;
        gets = howMany;
    }

    @Override
    public void run() {
        for (int j = 0; j < gets; j++) {
            Object obj = sharedQueue.get();
            while (obj == null) {
                Thread.currentThread().yield();
                obj = sharedQueue.get();
            }
            System.out.println("Get thread " + getId + ": get " + j);
        }
        System.out.println("Get thread " + getId + ": DONE GETTING");
    }
}
