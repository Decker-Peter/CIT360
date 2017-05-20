 import java.util.*;
import java.util.concurrent.*;
 
public class MyMultiThreading {
             
 
             
              public static void main(String[] args) throws Exception {               
                             currentThread();
                             multiThread();
                             runnableThread();
                             executorThread();
                             executorService();
                             executorServiceCallable();
                             executorScheduled();
              }
 
             
 
             
              // To show that by default, everything run under main thread
             
              private static void currentThread() {
                             System.out.println("The current thread id is: " + Thread.currentThread().getName());
              }
 
             
              // Multithreading with overwrite thread class.
             
              private static void multiThread() {
                             for (int threadCnt = 0; threadCnt < 3; threadCnt++) {
                                           MyThread aThread = new MyThread();
                                           aThread.start();
                             }
              }
 
             
              // multithreading with runnable
             
              private static void runnableThread() {
                             for (int threadCount = 0; threadCount < 3; threadCount++) {
                                           Thread runnable = new Thread(new MyRunnable());
                                           runnable.start();
                             }
              }
 
             
              // multithreading with executor interface
             
              private static Executor executorThread() {
                             Executor anExecutor = Executors.newCachedThreadPool();
                             for (int threadCount = 0; threadCount < 3; threadCount++) {
                                           anExecutor.execute(new MyRunnable());
                             }
                             return anExecutor;
              }
 
             
              // multithreading with executorservice interface It creates a pool with size
    // of file, so 5 threads will run at the same time The 10 tasks will
              // distribute into those 5 threads and output
             
              private static ExecutorService executorService() {
                             ExecutorService myES = Executors.newFixedThreadPool(5);
 
                             for (int i = 0; i < 10; i++) {
                                           myES.submit(new MyRunnable("Task Number " + i));
                             }
 
                             return myES;
              }
 
             
              // multithreading with executorservice interface and callable Callables will
              // return a value when the future is done. In this case, it only return a
              // integer value of 1001
             
              private static ExecutorService executorServiceCallable() throws Exception {
                             ExecutorService myES = Executors.newFixedThreadPool(5);
                             Future<Integer> myFuture = myES.submit(new MyCallable());
                             System.out.println("future done? " + myFuture.isDone());
                             Integer result = myFuture.get();
                             System.out.println("future done? " + myFuture.isDone());
                             System.out.println("result: " + result);
                             return myES;
              }
 
             
              // multithreading with scheduledexecutorservice This will schedule 3 tasks
              // in 1, 2, and 3 seconds The third one will also be monitored for how many
              // seconds of delay left
             
              private static ScheduledExecutorService executorScheduled() throws Exception {
                             ScheduledExecutorService executor = Executors.newScheduledThreadPool(3);
 
                             Runnable task = () -> System.out.println("Time: " + new Date());
                             executor.schedule(task, 1, TimeUnit.SECONDS);
                             executor.schedule(task, 2, TimeUnit.SECONDS);
                             ScheduledFuture<?> future = executor.schedule(task, 3, TimeUnit.SECONDS);
 
                             TimeUnit.MILLISECONDS.sleep(1000);
 
                             System.out.printf("Remaining Delay: %sms\n", future.getDelay(TimeUnit.MILLISECONDS));
 
                             TimeUnit.MILLISECONDS.sleep(1000);
 
                             System.out.printf("Remaining Delay: %sms\n", future.getDelay(TimeUnit.MILLISECONDS));
 
                             return executor;
              }
             
}
 
 
// create a overwrite thread class
class MyThread extends Thread {
              public void run() {
                             for (int i = 0; i < 3; i++) {
                                           System.out.println("Thread id: " + Thread.currentThread().getName());
                                           try {
                                                          Thread.currentThread().sleep(500);
                                           } catch (Exception e) {
                                                          e.printStackTrace();
                                           }
                             }
              }
}
 
 
// create a runnable class
class MyRunnable implements Runnable {
              String msg;
 
              public void run() {
                             for (int i = 0; i < 3; i++) {
                                           System.out.println("Thread id: " + Thread.currentThread().getName() + " with message of " + msg);
                             }
              }
 
              public MyRunnable(String msg) {
                             this.msg = msg;
              }
 
              public MyRunnable() {
 
              }
}
 
 
// create a callable class. Since the return will be raw, we need to define the
// type
class MyCallable implements Callable<Integer> {
 
              @Override
              public Integer call() throws Exception {
                             TimeUnit.MILLISECONDS.sleep(100);
                             return 1001;
              }
}