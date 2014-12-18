package main;

/**
 * <pre>
 * This enum is used to pass an operator (>, <) as an argument to a method. This approach is inspired from
 * the answer mentioned here -
 * http://stackoverflow.com/questions/2902458/is-it-possible-to-pass-arithmetic-operators-to-a-method-in-java
 * </pre>
 * 
 * @author onkar.deshpande@gmail.com (Onkar Deshpande)
 *
 */
public enum Operator {
  GREATER(">") {
    @Override
    public boolean apply(int a, int b) {
      return a > b;
    }
  },
  LESSER("<") {
    @Override
    public boolean apply(int a, int b) {
      return a < b;
    }
  };

  private String text;

  Operator(String text) {
    this.text = text;
  }

  public abstract boolean apply(int a, int b);

  @Override
  public String toString() {
    return text;
  }
}
