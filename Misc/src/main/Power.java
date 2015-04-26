package main;

public class Power {
  public static int get(int base, int exponent) {
    if (base == 1)
      return 1;
    if (exponent == 1)
      return base;
    if (exponent == 0)
      return 1;
    else if (exponent % 2 == 0) {
      return get(base, exponent / 2) * get(base, exponent / 2);
    } else {
      return base * get(base, exponent / 2) * get(base, exponent / 2);
    }
  }

  public static double getOptimized(int base, int exponent) {
    if (base == 1)
      return 1d;
    if (exponent == 1)
      return base;
    if (exponent == 0)
      return 1d;
    double temp = getOptimized(base, exponent / 2);
    if (exponent % 2 == 0)
      return temp * temp;
    else
      return base * temp * temp;
  }

  public static double getOptimizedNegative(double base, int exponent) {
    if (base == 1)
      return 1d;
    if (exponent == 1)
      return base;
    if (exponent == 0)
      return 1d;
    double temp = getOptimizedNegative(base, exponent / 2);
    if (exponent % 2 == 0)
      return temp * temp;
    else {
      if (exponent > 0)
        return base * temp * temp;
      else
        return base * 1d / (temp * temp);
    }
  }
}
