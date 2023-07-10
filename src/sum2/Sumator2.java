package sum2;

import java.util.concurrent.atomic.AtomicInteger;

public class Sumator2 {

    public static void main(String args[]) throws InterruptedException {
        String name = Thread.currentThread().getName();
        System.out.println("Starter thread - " + name);

        AtomicInteger sum = new AtomicInteger();

        Integer[] a1 = {3, 30, 300};
        SumRunnable sr1 = new SumRunnable(1, sum, a1);
        Thread t1 = new Thread(sr1);

        Integer[] a2 = {2, 20, 200};
        SumRunnable sr2 = new SumRunnable(2, sum, a2);
        Thread t2 = new Thread(sr2);

        Integer[] a3 = {4, 40, 400};
        SumRunnable sr3 = new SumRunnable(3, sum, a3);
        Thread t3 = new Thread(sr3);

        t1.start();
        t1.join();
        t2.start();
        t2.join();
        t3.start();
        t3.join();

        System.out.println(sum.get());
    }
}
