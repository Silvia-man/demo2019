package concurrency.executor;

public class WorkThread implements Runnable{
    private String command;

    public WorkThread(String command) {
        this.command = command;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " Start. Command = " + command);
        process();
        System.out.println(Thread.currentThread().getName() + " End.");

    }

    private void process(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString(){
        return this.command;
    }
}
