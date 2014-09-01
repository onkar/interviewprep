package runnable;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * In this example, 10 monkeys are created which gather random amount of bananas in a separate
 * thread spawned from an executor service. The main thread then adds those bananas and reports
 * total number of bananas gathered.
 * 
 * @author onkar.deshpande@gmail.com (Onkar Deshpande)
 * 
 */
public class FetchBananas {
  private int totalBananasCollected;
  private final int NumberOfThreads = 10;
  private final ExecutorService executor = Executors.newFixedThreadPool(NumberOfThreads);

  public FetchBananas() {
    totalBananasCollected = 0;
  }

  public static void main(String[] args) {
    FetchBananas fb = new FetchBananas();
    fb.gather();
  }

  private void gather() {
    List<Future<Integer>> futures = new ArrayList<Future<Integer>>();
    for (int i = 0; i < NumberOfThreads; i++) {
      final Monkey m = new Monkey();
      Future<Integer> future = executor.submit(new Callable<Integer>() {
        @Override
        public Integer call() throws Exception {
          int b = m.fetch();
          System.out.println(Thread.currentThread().getName() + " fetched " + b + " bananas");
          return b;
        }
      });
      futures.add(future);
    }

    for (Future<Integer> f : futures) {
      try {
        totalBananasCollected += f.get();
      } catch (InterruptedException e) {
        e.printStackTrace();
      } catch (ExecutionException e) {
        e.printStackTrace();
      }
    }

    System.out.println("Total fetched bananas : " + totalBananasCollected);
  }

}


class Monkey {
  private final Random random;

  public Monkey() {
    random = new Random();
  }

  public int fetch() {
    return random.nextInt(100);
  }
}
