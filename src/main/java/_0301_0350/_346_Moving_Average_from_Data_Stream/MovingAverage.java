package _0301_0350._346_Moving_Average_from_Data_Stream;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author jacka
 * @version 1.0 on 10/5/2017.
 */
public class MovingAverage {
  private final Queue<Integer> queue;
  private double sum = 0;
  private final int size;

  public MovingAverage(int size) {
    queue = new ArrayDeque<>();
    this.size = size;
  }

  public double next(int val) {
    if (size == 0) {
      return 0d;
    }
    if (queue.size() == size) {
      sum -= queue.poll();
    }
    sum += val;
    queue.add(val);
    return sum / queue.size();
  }
}
