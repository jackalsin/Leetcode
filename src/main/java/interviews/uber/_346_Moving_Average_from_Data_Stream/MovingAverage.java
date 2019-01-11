package interviews.uber._346_Moving_Average_from_Data_Stream;

import java.util.ArrayDeque;
import java.util.Queue;

public class MovingAverage {
  private final Queue<Integer> curWindow = new ArrayDeque<>();
  private final int size;
  private int sum = 0;

  /**
   * Initialize your data structure here.
   */
  public MovingAverage(int size) {
    this.size = size;
  }

  public double next(int val) {
    if (size == 0) {
      return 0d;
    }
    curWindow.add(val);
    sum += val;
    if (curWindow.size() > size) {
      sum -= curWindow.remove();
    }
    return (double) sum / curWindow.size();
  }
}
