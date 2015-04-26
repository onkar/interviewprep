package main;

public class Factors {
  public static void printAllSets(int number) {
    printAllSetsUtil("", number, number);
  }

  private static void printAllSetsUtil(String expression, int current, int previousFactor) {
    if (expression.equals(""))
      System.out.println(current + " * 1");
    for (int factor = current - 1; factor >= 2; factor--) {
      if (current % factor == 0 && factor <= previousFactor) {
        int nextFactor = current / factor;
        if (nextFactor <= factor && nextFactor <= previousFactor) {
          System.out.println(expression + factor + " * " + nextFactor);
        }
        printAllSetsUtil(expression + factor + " * ", nextFactor, factor);
      }
    }
  }
}
