package concurrency.lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class BasicReadWriteLock {
    private static Map<String, String > map = new HashMap<>();
    private final ReadWriteLock lock = new ReentrantReadWriteLock();

    private final Lock readLock = lock.readLock();
    private final Lock writeLock = lock.writeLock();
    private Integer counter = 0;

    public void put(String key, String value) {
        System.out.println(Thread.currentThread().getName() + " acquiring put write lock");
        try {
            writeLock.lock();
            System.out.println(Thread.currentThread().getName() + " put locked");
            map.put(key, value);
            System.out.println("counter: " + counter++);
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            writeLock.unlock();
        }
    }

    public String get(String key){
        try {
            readLock.lock();
            return map.get(key);
        } finally {
            readLock.unlock();
        }
    }

    public String remove(String key){
        try {
            writeLock.lock();
            return map.remove(key);
        } finally {
            writeLock.unlock();
        }

    }

    public boolean containsKey(String key){
        try {
            readLock.lock();
            return map.containsKey(key);
        } finally {
            readLock.unlock();
        }
    }

    boolean isReadLockFree(){
        return readLock.tryLock();
    }

    private  static class Reader implements Runnable {
        BasicReadWriteLock object;

        public Reader(BasicReadWriteLock object){
            this.object = object;
        }

        @Override
        public void run() {
            for(int i = 0; i < 10; i++){
                System.out.println(Thread.currentThread().getName() + " reading...");
                System.out.println("read " + i);//????
                object.get("key" + i);
            }

        }
    }
    private  static class Writer implements Runnable {
        BasicReadWriteLock object;
        private final int LOOP = 10;

        public Writer(BasicReadWriteLock object){
            this.object = object;
        }

        @Override
        public void run() {
            for(int i= 0; i< LOOP; i++){
                try {
                    object.put("key" + i, "value " + i);
                    System.out.println(Thread.currentThread().getName() + " writing....");
                    System.out.println("write " + i);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }


    public static void main(String[] args) {
        final int THREAD_COUNT = 4;
        final ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);

        BasicReadWriteLock lock = new BasicReadWriteLock();

        executor.execute(new Thread(new Writer(lock), "writer1"));
        executor.execute(new Thread(new Reader(lock), "Reader1"));
        executor.execute(new Thread(new Reader(lock), "Reader2"));
        executor.execute(new Thread(new Reader(lock), "Reader3"));
        executor.execute(new Thread(new Writer(lock), "writer2"));

        executor.shutdown();

    }
}
