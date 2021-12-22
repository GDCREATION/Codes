package concurrency;

import java.util.concurrent.atomic.AtomicInteger;

public class PrintinOrderAtomicInteger {
    
    /**Suppose we have a class:

public class Foo {
  public void first() { print("first"); }
  public void second() { print("second"); }
  public void third() { print("third"); }
}
The same instance of Foo will be passed to three different threads.
Thread A will call first(), thread B will call second(), and thread C will call third().
Design a mechanism and modify the program to ensure that second() is executed after first(),
and third() is executed after second(). */

        private AtomicInteger firstJobDone = new AtomicInteger(0);
        private AtomicInteger secondJobDone = new AtomicInteger(0);
      
        public PrintinOrderAtomicInteger() {}
      
        public void first(Runnable printFirst) throws InterruptedException {
          // printFirst.run() outputs "first".
          printFirst.run();
          // mark the first job as done, by increasing its count.
          firstJobDone.incrementAndGet();
        }
      
        public void second(Runnable printSecond) throws InterruptedException {
          while (firstJobDone.get() != 1) {
            // waiting for the first job to be done.
          }
          // printSecond.run() outputs "second".
          printSecond.run();
          // mark the second as done, by increasing its count.
          secondJobDone.incrementAndGet();
        }
      
        public void third(Runnable printThird) throws InterruptedException {
          while (secondJobDone.get() != 1) {
            // waiting for the second job to be done.
          }
          // printThird.run() outputs "third".
          printThird.run();
        }
      }
      
