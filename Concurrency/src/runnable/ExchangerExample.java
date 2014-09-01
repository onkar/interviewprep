package runnable;

import java.util.concurrent.Exchanger;

public class ExchangerExample {

  Exchanger<String> exchanger;

  public static void main(String[] args) {
    Exchanger<String> exchanger = new Exchanger<String>();
    ExchangeRunnable e1 = new ExchangeRunnable(exchanger, "A");
    ExchangeRunnable e2 = new ExchangeRunnable(exchanger, "B");
    new Thread(e1).start();
    new Thread(e2).start();
  }
}


class ExchangeRunnable implements Runnable {
  Exchanger<String> ex = null;
  String str = null;

  public ExchangeRunnable(Exchanger<String> ex, String str) {
    this.ex = ex;
    this.str = str;
  }

  @Override
  public void run() {
    String prev = str;
    try {
      this.str = ex.exchange(this.str);
      System.out.println(Thread.currentThread().getName() + " exchanged " + prev + " for "
          + this.str);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

  }
}
