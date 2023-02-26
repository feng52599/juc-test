package edu.feng.code.lock;

public class Main {
    static int sum = 0;
    static LuoLock lock = new LuoLock();

    public static void main(String[] args) throws Exception{
	    Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    lock.lock();
                    for (int i = 0; i < 10000; i++) {
                        sum++;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }

            }
        };
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(sum);
    }
}
