package concurrency.lock;

import java.util.concurrent.locks.ReentrantLock;

public class BasicReentrantlock implements Runnable{
    public static ReentrantLock lock = new ReentrantLock();
    public static int i = 0;

    @Override
    public void run() {
        for(int j = 0; j <10000000; j++){
            lock.lock();
            try {
                i++;
            }finally {
                lock.unlock();
            }
        //    synchronized (lock){
        //        i++;
        //    }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        BasicReentrantlock rlock = new BasicReentrantlock();
        Thread t1 = new Thread(rlock);
        Thread t2 = new Thread(rlock);

        t1.start();
        t2.start();

        t1.join();
        t2.join();
        System.out.println(i);
    }
}

