package concurrency.executor;

import java.time.LocalDateTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class BasicScheduleExecutor {

    public static void main(String[] args) {
        ScheduledExecutorService exector = Executors.newScheduledThreadPool(3);

        ScheduledTask task1 = new ScheduledTask(1);
        ScheduledTask task2 = new ScheduledTask(2);

        exector.schedule(task1, 2, TimeUnit.SECONDS);

        exector.scheduleAtFixedRate(task2, 0, 10, TimeUnit.SECONDS);

        try {
            TimeUnit.SECONDS.sleep(25);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}


class ScheduledTask implements Runnable{

    private int taskId;

    public ScheduledTask(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public void run() {
        System.out.println("Task #" + this.taskId + " run at " + LocalDateTime.now());

    }
}

