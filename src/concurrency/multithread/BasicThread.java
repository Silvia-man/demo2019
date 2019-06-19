package concurrency.multithread;

public class BasicThread extends Thread {

    public BasicThread(String name) {
        super(name);
    }

    @Override
    public void run(){
        System.out.println("RUNNING START " + Thread.currentThread().getName());//currentThread()拿到主线程
        try {
            Thread.sleep(1000);
            Processing();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("RUNNING END " + Thread.currentThread().getName());
    }

    private void Processing() throws InterruptedException {
        System.out.println("PROCEDDING...");
        Thread.sleep(5000);
    }

}
