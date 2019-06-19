package concurrency;

import java.util.concurrent.atomic.AtomicInteger;

public class BasicSync implements Runnable{

    static BasicSync instance = new BasicSync();

    //static int i = 0;
    static AtomicInteger i = new AtomicInteger();

    @Override
    public void run(){
        for(int j = 0; j < 1000000; j++){
  //          synchronized (instance){
  //              i++;
  //          }
            i.incrementAndGet();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);

     //   System.currentTimeMillis();
        t1.start();
        t2.start();

        t1.join();
        t2.join();
     //   System.out.println(i);

    }
}
