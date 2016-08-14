/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadprogramming;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author RolfMoikjær
 */
public class ThreadProgramming {

    static BlockingQueue<Integer> s1 = new ArrayBlockingQueue(11);
    static BlockingQueue<Long> s2 = new ArrayBlockingQueue(11);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Thread1 t1 = new Thread1();

        t1.start();
    }

    public static class Thread1 extends Thread {

//        Producer p2 = new Producer();
//        Producer p3 = new Producer();
//        Producer p4 = new Producer();
        Consumer c1 = new Consumer();

        public void run() {
            try {
                s1.put(4);
                s1.put(5);
                s1.put(8);
                s1.put(12);
                s1.put(21);
                s1.put(22);
                s1.put(34);
                s1.put(35);
                s1.put(36);
                s1.put(37);
                s1.put(42);
            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadProgramming.class.getName()).log(Level.SEVERE, null, ex);
            }

            c1.start();

            ExecutorService executor = Executors.newFixedThreadPool(4);
            for (int i = 0; i < 4; i++) {
                executor.execute(new Producer());
            }
            executor.shutdown();
            while (!executor.isTerminated()) {
            }
            System.out.println("SLUTT!!");
            c1.interrupt();

        }
    }

    public static class Producer extends Thread {

        long s1Result;

        public void run() {
            while (!s1.isEmpty()) {
                try {
                    s1Result = s1.poll();
                    s2.put(fib(s1Result));
                } catch (Exception e) {
                }
            }
        }
    }

    public static class Consumer extends Thread {

        long temp;
        long totalRes;

        public void run() {
            while (true) {
                try {
                    temp = s2.take();
                } catch (Exception e) {
                    break;
                }
                System.out.println("Consumer s2 input: " + temp);
                totalRes += temp;
                System.out.println("Total sum: " + totalRes);
            }
        }
    }

    public static synchronized long fib(long n) {
        if ((n == 0) || (n == 1)) {
            return n;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }
}
