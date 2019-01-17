package org.sla;

public class QueueClass {
    // Fields
    private Object[] array;
    private int nextPutLocation = 0;
    private int nextGetLocation = 0;
    private int amountOfData;

    // Constructor
    QueueClass() {
        array = new Object[100];
        amountOfData = 0;
    }

    synchronized boolean put() {
        if (amountOfData <= 99) {
            amountOfData = amountOfData + 1;
            //System.out.println("amountOfData = " + amountOfData);
            if (nextPutLocation == 99) {
                nextPutLocation = 0;
            } else {
                nextPutLocation = nextPutLocation + 1;
            }
            return true;
        }
        return false;
    }

    synchronized Object get() {
        if (amountOfData == 0) {
            return null;
        }
        int currentGet = nextGetLocation;
        if (nextGetLocation == 99) {
            nextGetLocation = 0;
        } else {
            nextGetLocation = nextGetLocation + 1;
        }
        amountOfData = amountOfData - 1;
        return array[currentGet];
    }
    // Methods
    /*void put(Object obj) {
        if (amountOfData > 99) {
            System.out.println("Put failed;  try get() to give me space");
            return;
        }
        array[nextPutLocation] = obj;
        amountOfData = amountOfData + 1;
        if (nextPutLocation == 99) {
            nextPutLocation = 0;
        } else {
            nextPutLocation = nextPutLocation + 1;
        }
    }

    Object get() {
        if (amountOfData == 0) {
            System.out.println("Get failed;  try put() to add stuff");
            return null;
        }
        int currentGet = nextGetLocation;
        if (nextGetLocation == 99) {
            nextGetLocation = 0;
        } else {
            nextGetLocation = nextGetLocation + 1;
        }
        amountOfData = amountOfData - 1;
        return array[currentGet];
    }*/
}
