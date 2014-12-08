package main;



public class ReverseSentence {
  public String reverse(String input) {
    if (input == null || input.length() == 0)
      return " ";
    char[] array = input.toCharArray();
    array = reverse(array);
    String str = new String(array);
    int j = 0;
    int i = 0;
    StringBuilder sb = new StringBuilder();
    for (i = 0; i < str.length(); i++) {
      if (str.charAt(i) == ' ') {
        String subString = str.substring(j, i);
        char[] r = subString.toCharArray();
        r = reverse(r);
        sb.append(r);
        sb.append(" ");
        j = i + 1;
      }
    }

    String subString = str.substring(j, i);
    char[] r = subString.toCharArray();
    r = reverse(r);
    sb.append(r);
    return sb.toString();
  }

  private char[] reverse(char[] array) {
    int i = 0;
    int j = array.length - 1;
    while (i < j) {
      char temp = array[i];
      array[i] = array[j];
      array[j] = temp;
      i++;
      j--;
    }
    return array;
  }
}
