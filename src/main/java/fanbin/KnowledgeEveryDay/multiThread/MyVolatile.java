package fanbin.KnowledgeEveryDay.multiThread;

import java.util.concurrent.atomic.AtomicInteger;

public class MyVolatile {
	public volatile int inc = 0;
    
    public void increase() {
        inc++;
    }
    
    /**
     * atomic内部使用了volatile修饰符，保证了可见性
     */
    public AtomicInteger atomicInteger = new AtomicInteger(0);
    
    /**
     * 内部使用了unsafe的算法
     */
    public void atomicIncrease() {
    	atomicInteger.addAndGet(1);
    }
    
    public static void main(String[] args) {
        final MyVolatile test = new MyVolatile();
        for(int i=0;i<10;i++){
            new Thread(){
                public void run() {
                    for(int j=0;j<1000;j++)
                        test.increase();
                };
            }.start();
        }
         
        while(Thread.activeCount()>1)  //保证前面的线程都执行完
            Thread.yield();
        System.out.println(test.inc);
        
        for(int i=0;i<10;i++){
            new Thread(){
                public void run() {
                    for(int j=0;j<1000;j++) {
                    	synchronized (test) {
                    		/**
                    		 * 增加同步后，同一时间仅一个线程可以去访问
                    		 */
                            test.increase(); 
						}
                    }
                };
            }.start();
        }
         
        while(Thread.activeCount()>1)  //保证前面的线程都执行完
            Thread.yield();
        System.out.println(test.inc);
        
        for(int i=0;i<10;i++){
            new Thread(){
                public void run() {
                    for(int j=0;j<1000;j++) {
                    	test.atomicIncrease();
                    }
                };
            }.start();
        }
         
        while(Thread.activeCount()>1)  //保证前面的线程都执行完
            Thread.yield();
        System.out.println(test.atomicInteger.get());
    }
}
