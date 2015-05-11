package main;

public class BigInt {

  // Create array representation of the string. For example "1234" will be converted to [1, 2, 3, 4]
  private static int[] stringToDigits(String num) {
    int[] result = new int[num.length()];
    for (int i = 0; i < num.length(); i++) {
      char c = num.charAt(i);
      if (c < '0' || c > '9') {
        throw new IllegalArgumentException("Invalid digit " + c + " found at location " + i);
      }
      result[i] = c - '0';
    }
    return result;
  }

  public static String multiply(String first, String second) {
    int[] num1 = stringToDigits(first);
    int[] num2 = stringToDigits(second);
    int[] result = new int[num1.length + num2.length];
    int carry = 0;
    int offset = 0;

    for (int i = num1.length - 1; i >= 0; i--) {
      int tail = result.length - offset - 1;
      for (int j = num2.length - 1; j >= 0; j--) {
        int sum = result[tail] + num1[i] * num2[j] + carry;
        result[tail] = sum % 10;
        carry = sum / 10;
        --tail;
      }
      if (carry > 0) {
        addCarry(result, tail, carry);
        carry = 0;
      }
      offset++;
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < result.length; i++) {
      if (result[i] == 0)
        continue;
      sb.append(result[i]);
    }

    return sb.toString();
  }

  private static void addCarry(int[] result, int tail, int carry) {
    result[tail] += carry;
    while (result[tail] >= 10) {
      carry = result[tail] / 10;
      result[tail] = result[tail] % 10;
      --tail;
      result[tail] += carry;
    }
  }
}
