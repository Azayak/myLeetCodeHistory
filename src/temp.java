//import java.util.concurrent.locks.Lock;
//
//public class DeadLock {
//    private final Lock lock1;
//    private final Lock lock2;
//
//    public  DeadLock(Lock lock1, Lock lock2) {
//        this.lock1 = lock1;
//        this.lock2 = lock2;
//    }
//
//
//    @Override
//    public void run() throws InterruptedException {
//        synchronized (lock1) {
//
//            Thread.sleep(500);
//            System.out.println(Thread.currentThread().getName()+lock1+"   "+lock2);
//
//
//            synchronized (lock2) {
//                System.out.println(Thread.currentThread().getName()+lock2+"  "+lock1);
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//        Lock lock_1 = new Lock("");
//        Lock lock_2 = new Lock();
//
//        Thread thread_1 = new DeadLock(lock_1,lock_2);
//
//
//        Thread thread_2 = new DeadLock(lock_2,lock_1);
//
//        thread_1.start();
//        thread_2.start();
//    }
//
//}
