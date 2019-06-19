package concurrency.executor;

import java.util.concurrent.*;

public class BasicThreadPoolExecutor {
    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor executor = creatThreadPool();

        MonitorThread monitor = startMonitoring(executor);

        StartWorking(executor);

        StopWorking(executor);
    }

    private static ThreadPoolExecutor creatThreadPool() {
        RejectedExecutionHandlerImpl rejectedExecutionHandler = new RejectedExecutionHandlerImpl();
        ThreadFactory threadFactory = Executors.defaultThreadFactory();
        return new ThreadPoolExecutor(2, 4,
                10, TimeUnit.SECONDS, new ArrayBlockingQueue<>(4), threadFactory, rejectedExecutionHandler);
    }

    private static MonitorThread startMonitoring(ThreadPoolExecutor executor) {
        MonitorThread monitor = new MonitorThread(executor, 3);
        Thread monitorThread = new Thread();
        monitorThread.start();
        return monitor;
    }

    private static void StopWorking(ThreadPoolExecutor executor) throws InterruptedException {
        Thread.sleep(30000);
        executor.shutdown();
        Thread.sleep(50000);
        executor.shutdown();
    }

    private static void StartWorking(ThreadPoolExecutor executor) {
        for(int i = 0; i < 10; i++){
            executor.execute(new WorkThread("cmd" + i));
        }
    }
}
