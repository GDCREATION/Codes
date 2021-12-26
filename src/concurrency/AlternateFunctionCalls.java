package concurrency;

import java.util.concurrent.atomic.AtomicInteger;

public class AlternateFunctionCalls {
        private int n;
        private AtomicInteger countFoo;
        private AtomicInteger countBar;
    
        public AlternateFunctionCalls(int n) {
            this.n = n;
            this.countFoo=new AtomicInteger(0);
            this.countBar=new AtomicInteger(0);
        }
    
        synchronized public void foo(Runnable printFoo) throws InterruptedException     {
            for (int i = 0; i < n; i++) {    
                if(this.countFoo.get()!=this.countBar.get()){
                    wait();
                }
                printFoo.run();
                this.countFoo.getAndAdd(1);
                notifyAll();
            }
           
        }
    
        synchronized public void bar(Runnable printBar) throws InterruptedException     {
            for (int i = 0; i < n; i++) {
                if(this.countFoo.get()==this.countBar.get()){
                     wait();    
                }
                printBar.run();
                this.countBar.getAndAdd(1);
                notifyAll();
            } 
        }
    }