package runnable;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierSimpleExample {
  public static void main(String[] args) {
    Runnable barrier1Action = new Runnable() {
      @Override
      public void run() {
        System.out.println(Thread.currentThread().getName() + " invokes barrierAction1");
      }
    };

    Runnable barrier2Action = new Runnable() {
      @Override
      public void run() {
        System.out.println(Thread.currentThread().getName() + " invokes barrierAction2");
      }
    };
    CyclicBarrier b1 = new CyclicBarrier(2, barrier1Action);
    CyclicBarrier b2 = new CyclicBarrier(2, barrier2Action);

    CyclicBarrierRunnable cbr1 = new CyclicBarrierRunnable(b1, b2);
    CyclicBarrierRunnable cbr2 = new CyclicBarrierRunnable(b1, b2);

    new Thread(cbr1).start();
    new Thread(cbr2).start();
  }

}


class CyclicBarrierRunnable implements Runnable {
  private CyclicBarrier b1 = null;
  private CyclicBarrier b2 = null;

  public CyclicBarrierRunnable(CyclicBarrier b1, CyclicBarrier b2) {
    this.b1 = b1;
    this.b2 = b2;
  }

  @Override
  public void run() {
    try {
      Thread.sleep(1000);
      System.out.println(Thread.currentThread().getName() + " is waiting at barrier1");
      b1.await();

      Thread.sleep(1000);
      System.out.println(Thread.currentThread().getName() + " is waiting at barrier2");
      b2.await();

      System.out.println(Thread.currentThread().getName() + " is done!");
    } catch (InterruptedException e) {
      e.printStackTrace();
    } catch (BrokenBarrierException e) {
      e.printStackTrace();
    }
  }
}
