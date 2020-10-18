//public class DeadLock implements Runnable{
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
//    public void run() {
//        synchronized (lock1) {
//
//            try {
//                Thread.sleep(500);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
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

public class DeadLock {
    private static String A="A";
    private static String B="B";

    private void deadLock() throws InterruptedException {
        Thread threadA = new Thread(new Runnable(){
            @Override
            public void run(){
                synchronized(A){
                    try {
                        Thread.currentThread().sleep(2000);  //睡两秒确保了阻塞，不然可能直接运行下去了
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized(B){
                        System.out.println("AB");
                    }
                }
            }
        });
        Thread threadB = new Thread(new Runnable(){
            @Override
            public void run(){
                synchronized(B){
                    try {
                        Thread.currentThread().sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized(A){
                        System.out.println("BA");
                    }
                }
            }
        });
        threadA.start();
        Thread.currentThread().sleep(1000);
        threadB.start();
    }

    public static void main(String[] args) throws InterruptedException {
        new DeadLock().deadLock();
    }
}

