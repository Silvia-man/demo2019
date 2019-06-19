package concurrency.multithread;

public class Runner {
    public static void main(String[] args) {
        Thread t1 = new Thread(new BasicRunnable(), "t1");
        Thread t2 = new Thread(new BasicRunnable(), "t2");
       /* Thread t3 = new Thread(new BasicRunnable());
        Thread t4 = new Thread(new BasicRunnable());
        Thread t5 = new Thread(new BasicRunnable());

        */

        System.out.println("Starting runnable threads");
        t1.start();
        t2.start();
      /*
        t3.start();
        t4.start();
        t5.start();

       */
        System.out.println( "Runnable threads have started");

        Thread t6 = new BasicThread("t6");
        Thread t7 = new BasicThread("t7");

        t6.start();
        t7.start();

        System.out.println( "Runnable threads have started");
    }
}
