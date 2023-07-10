package sum2;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class SumRunnable implements Runnable {
    private AtomicInteger sum;
    private Integer[] arrayToSum;
    private Integer index;
    private List<Runnable> tasks;

    public SumRunnable(Integer index,
                       AtomicInteger sum,
                       Integer[] arrayToSum) {
        this.sum = sum;
        this.arrayToSum = arrayToSum;
        this.index = index;
    }

    public void run() {
        String name = Thread.currentThread().getName();
        for (int i = 0; i < arrayToSum.length; i++) {
            this.sum.addAndGet(arrayToSum[i]);
        }

        System.out.println("Thread " + name + " with index " + index + " has sum " + sum.get());
    }
}
