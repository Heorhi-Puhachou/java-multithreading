package sum;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class SumRunnable implements Runnable {
    private AtomicInteger sum;
    private Integer[] arrayToSum;
    private Integer index;
    CountDownLatch latch;

    public SumRunnable(Integer index,
                       AtomicInteger sum,
                       Integer[] arrayToSum,
                       CountDownLatch latch) {
        this.sum = sum;
        this.arrayToSum = arrayToSum;
        this.index = index;
        this.latch = latch;
    }

    public void run() {
        String name = Thread.currentThread().getName();
        for (int i = 0; i < arrayToSum.length; i++) {
            this.sum.addAndGet(arrayToSum[i]);
        }
        System.out.println("Thread " + name + " with index " + index + " has sum " + sum.get());
        latch.countDown();
    }
}
