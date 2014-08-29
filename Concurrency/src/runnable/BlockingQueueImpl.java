package runnable;

import java.util.LinkedList;

import com.google.common.collect.Lists;

/**
 * Implement simple blocking queue.
 * 
 * @author onkar.deshpande@gmail.com (Onkar Deshpande)
 * 
 */
public class BlockingQueueImpl {
  private final LinkedList<Object> queue = Lists.newLinkedList();
  private int limit = 10;

  public BlockingQueueImpl(int limit) {
    this.limit = limit;
  }

  /**
   * Wait if the size is same as the limit. If, the size is zero, notify other threads (so they can
   * continue in dequeue() method), and add element to the linked list.
   * 
   * @param object
   * @throws InterruptedException
   */
  public synchronized void enqueue(Object object) throws InterruptedException {
    while (this.queue.size() == this.limit) {
      wait();
    }
    if (this.queue.size() == 0) {
      notifyAll();
    }
    this.queue.add(object);
  }

  /**
   * Wait if size is zero. If size is same as limit, notify other threads (so they can continue in
   * enqueue() method). Remove first element of the linked list.
   * 
   * @return
   * @throws InterruptedException
   */
  public synchronized Object dequeue() throws InterruptedException {
    while (this.queue.size() == 0) {
      wait();
    }
    if (this.queue.size() == limit) {
      notifyAll();
    }
    return this.queue.remove(0);
  }

  public static void main(String[] args) {
    BlockingQueueImpl b = new BlockingQueueImpl(10);
    for (int i = 0; i < 15; i++) {
      Thread thread = new Thread(new EnqueueElements(b));
      thread.setName("thread-" + i);
      thread.start();
    }

    for (int i = 0; i < 15; i++) {
      Thread thread = new Thread(new DequeueElements(b));
      thread.start();
    }
  }
}


class EnqueueElements implements Runnable {
  private BlockingQueueImpl bq = null;

  public EnqueueElements(BlockingQueueImpl b) {
    bq = b;
  }

  @Override
  public void run() {
    try {
      bq.enqueue(Thread.currentThread().getName());
      System.out.println("Thread " + Thread.currentThread().getName() + " is enqueued");
    } catch (InterruptedException e) {
      System.out.println("Got exception while enqueing " + e);
    }
  }

}


class DequeueElements implements Runnable {
  private BlockingQueueImpl bq = null;

  public DequeueElements(BlockingQueueImpl b) {
    bq = b;
  }

  @Override
  public void run() {
    try {
      String dequeuedThread = (String) bq.dequeue();
      System.out.println("Thread " + dequeuedThread + " is dequeued");
    } catch (InterruptedException e) {
      System.out.println("Got exception while enqueing " + e);
    }
  }

}
