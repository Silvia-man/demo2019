package concurrency.multithread;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
//定时

public class BasicThreadTimer extends TimerTask {

    public void run(){
        System.out.println("Timer task started at: " + new Date());
        processing();
        System.out.println("Timer task started at: " + new Date());
    }

    private void processing(){
        try {
            Thread.sleep(9000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        TimerTask timerTask = new BasicThreadTimer();
        Timer timer = new Timer(false);
        timer.scheduleAtFixedRate(timerTask, 3000, 3*1000);
        /*
            scheduleAtFixedRate(TimerTask task,long delay,long period) 方法用于安排指定的任务进行重复的固定速率执行，在指定的延迟后开始。
			task--这是被调度的任务。
			delay--这是以毫秒为单位的延迟之前的任务执行。
			period--这是在连续执行任务之间的毫秒的时间.
         */
        System.out.println("Timertask started");

        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        timer.cancel();
        System.out.println("Timertask cancelled");

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
