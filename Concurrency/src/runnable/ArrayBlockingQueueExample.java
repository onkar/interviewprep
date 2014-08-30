package runnable;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Example of ArrayBlockingQueue acting as a bounded buffer
 * 
 * @author onkar.deshpande@gmail.com (Onkar Deshpande)
 * 
 */
public class ArrayBlockingQueueExample {
  public static void main(String[] args) {
    BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(1000);
    Producer producer = new Producer(queue);
    Consumer consumer = new Consumer(queue);

    new Thread(producer).start();
    new Thread(consumer).start();
  }

}

class Producer implements Runnable {
  BlockingQueue<Integer> queue = null;

  public Producer(BlockingQueue<Integer> queue) {
    this.queue = queue;
  }

  @Override
  public void run() {
    try {
      queue.put(10);
      Thread.sleep(1000);
      queue.put(20);
      Thread.sleep(1000);
      queue.put(30);
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

  }
}


class Consumer implements Runnable {
  BlockingQueue<Integer> queue = null;

  public Consumer(BlockingQueue<Integer> blockingQueue) {
    this.queue = blockingQueue;
  }

  @Override
  public void run() {
    try {
      System.out.println(queue.take());
      System.out.println(queue.take());
      System.out.println(queue.take());
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

  }

}
