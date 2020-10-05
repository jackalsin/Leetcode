package _1351_1400._1381_Design_a_Stack_With_Increment_Operation;

/**
 * @author jacka
 * @version 1.0 on 3/14/2020
 */
public class CustomStack {
  private final int maxSize;
  private final int[] vals;
  private int i = 0;

  public CustomStack(int maxSize) {
    this.maxSize = maxSize;
    this.vals = new int[maxSize];
  }

  public void push(int x) {
    if (i == maxSize) {
      return;
    }
    vals[i++] = x;
  }

  public int pop() {
    if (i == 0) {
      return -1;
    }
    return vals[--i];
  }

  public void increment(int k, int val) {
    for (int i = 0; i < Math.min(k, this.i); ++i) {
      vals[i] += val;
    }
  }

}
