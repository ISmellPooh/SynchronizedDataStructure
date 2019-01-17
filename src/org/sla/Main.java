package org.sla;

public class Main {
    public static void main(String[] args) {
        QueueClass queueClass = new QueueClass();

        PutClass myPut1 = new PutClass(queueClass, 1, 150);
        PutClass myPut2 = new PutClass(queueClass, 2, 150);
        GetClass myGet1 = new GetClass(queueClass, 1, 100);
        GetClass myGet2 = new GetClass(queueClass, 2, 100);
        GetClass myGet3 = new GetClass(queueClass, 3, 100);

        Thread putThread1 = new Thread(myPut1);
        putThread1.start();

        Thread putThread2 = new Thread(myPut2);
        putThread2.start();

        Thread getThread1 = new Thread(myGet1);
        getThread1.start();

        Thread getThread2 = new Thread(myGet2);
        getThread2.start();

        Thread getThread3 = new Thread(myGet3);
        getThread3.start();

        /*for (int i = 0; i < 100; i++) {
            stackClass.put(i);
        }

        for (int i = 0; i < 100; i++) {
            Object newStack = stackClass.get();
            System.out.println(newStack);
        }

        for (int i = 0; i < 100; i++) {
            stackClass.put(i);
        }

        for (int i = 0; i < 100; i++) {
            Object newStack = stackClass.get();
            System.out.println(newStack);
        }

        for (int i = 0; i < 100; i++) {
            stackClass.put(i);
        }

        for (int i = 0; i < 100; i++) {
            Object newStack = stackClass.get();
            System.out.println(newStack);
        }*/
    }
}
