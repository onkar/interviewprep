package runnable;

/**
 * This sample code is showing an example of thread signaling. Sometimes, a thread can be woken up
 * spuriously, i.e. a thread which calls wait() might get woken up without some other thread calling
 * notify(). This code handles this situation by using a spinlock.
 * 
 * @author onkar.deshpande@gmail.com (Onkar Deshpande)
 * 
 */
public class SpinLock implements Runnable {
  MonitorObject monitorObject = new MonitorObject();
  boolean wasSignalled = false;

  public void doWait() {
    synchronized (monitorObject) {
      while (!wasSignalled) {
        try {
          monitorObject.wait();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
      // Set wasSignalled to false again so that other threads can
      // continue
      wasSignalled = false;
      System.out.println("doWait exiting...");
    }
  }

  public void doNotify() {
    synchronized (monitorObject) {
      // set wasSignalled to true to signal the waiting thread
      wasSignalled = true;
      monitorObject.notify();
      System.out.println("doNotify exiting...");
    }
  }

  @Override
  public void run() {
    if (Thread.currentThread().getName().equals("t1")) {
      System.out.println("t1 calling wait");
      doWait();
    } else {
      System.out.println("t2 calling notify");
      doNotify();
    }
  }

  public static void main(String[] args) {
    SpinLock spinLock = new SpinLock();
    Thread t1 = new Thread(spinLock, "t1");
    Thread t2 = new Thread(spinLock, "t2");
    t1.start();
    t2.start();
  }
}


class MonitorObject {

}
