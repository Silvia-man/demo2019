package concurrency.executor;

import java.util.concurrent.ThreadPoolExecutor;

public class MonitorThread implements Runnable{

    private ThreadPoolExecutor executor;
    private int delay;
    private boolean run = true;

    public MonitorThread(ThreadPoolExecutor executor, int seconds) {
        this.executor = executor;
        this.delay = seconds;
    }

    public void shutdown(){
        this.run = false;
    }

    @Override
    public void run() {
        while (run){
            System.out.println(String.format("[monitor] [%d/%d] Active: %d, Completed: %d, Task: %d, isShudown: %s, isTerminated: %s",
                    this.executor.getPoolSize(),
                    this.executor.getCorePoolSize(),
                    this.executor.getActiveCount(),
                    this.executor.getCompletedTaskCount(),
                    this.executor.getTaskCount(),
                    this.executor.isShutdown(),
                    this.executor.isTerminated()));

            try {
                Thread.sleep(this.delay * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
