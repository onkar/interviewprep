package runnable;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {
  public static void main(String[] args) {
    CountDownLatch latch = new CountDownLatch(3);
    Waiter waiter = new Waiter(latch);
    Decrementer decrementer = new Decrementer(latch);

    new Thread(waiter).start();
    new Thread(decrementer).start();

    try {
      Thread.sleep(4000);
    } catch (InterruptedException e) {
      System.out.println("Main thread interrupted while sleeping");
      e.printStackTrace();
    }
  }

}


class Waiter implements Runnable {
  private final CountDownLatch latch;

  public Waiter(CountDownLatch latch) {
    this.latch = latch;
  }

  @Override
  public void run() {
    System.out.println("Waiter calling await()...");
    try {
      latch.await();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("Waiter released...");
  }

}


class Decrementer implements Runnable {
  private final CountDownLatch latch;

  public Decrementer(CountDownLatch latch) {
    this.latch = latch;
  }

  @Override
  public void run() {
    try {
      Thread.sleep(1000);
      latch.countDown();
      System.out.println("Decrementer decremented countdown latch once...");

      Thread.sleep(1000);
      latch.countDown();
      System.out.println("Decrementer decremented countdown latch twice...");

      Thread.sleep(1000);
      latch.countDown();
      System.out.println("Decrementer decremented countdown latch thrice...");
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

}
