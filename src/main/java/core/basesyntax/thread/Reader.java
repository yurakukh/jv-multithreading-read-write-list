package core.basesyntax.thread;

import core.basesyntax.ReadWriteList;
import java.util.Random;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Reader implements Runnable {
    private ReadWriteList<Integer> sharedList;

    public Reader(ReadWriteList<Integer> sharedList) {
        this.sharedList = sharedList;
    }

    @Override
    public void run() {
        Random random = new Random();
        int size = sharedList.size();
        if (size > 0) {
            Integer number = sharedList.get(random.nextInt(size));
            System.out.println(Thread.currentThread().getName() + " -> read: " + number);
        }
    }
}
