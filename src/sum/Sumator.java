package sum;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class Sumator {

    public static void main(String args[]) {
        String name = Thread.currentThread().getName();
        System.out.println("Starter thread - " + name);

        CountDownLatch latch = new CountDownLatch(3);

        AtomicInteger sum = new AtomicInteger();

        Integer[] a1 = {1, 10, 100};
        SumRunnable sr1 = new SumRunnable(1, sum, a1, latch);
        Thread t1 = new Thread(sr1);

        Integer[] a2 = {2, 20, 200};
        SumRunnable sr2 = new SumRunnable(2, sum, a2, latch);
        Thread t2 = new Thread(sr2);

        Integer[] a3 = {4, 40, 400};
        SumRunnable sr3 = new SumRunnable(3, sum, a3, latch);
        Thread t3 = new Thread(sr3);

        t1.start();
        t2.start();
        t3.start();






        //System.out.println(sum.get());

        try {
            latch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(sum.get());
    }
}
