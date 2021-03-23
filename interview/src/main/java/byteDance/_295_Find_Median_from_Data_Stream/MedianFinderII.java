package byteDance._295_Find_Median_from_Data_Stream;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author jacka
 * @version 1.0 on 3/22/2021
 */
public final class MedianFinderII implements MedianFinder {
  private final Queue<Integer> left = new PriorityQueue<>((x, y) -> Integer.compare(y, x)),
      right = new PriorityQueue<>();

  public void addNum(int num) {
    left.add(num);
    right.add(left.remove());
    if (right.size() > left.size()) {
      left.add(right.remove());
    }
  }

  public double findMedian() {
    assert !left.isEmpty();
    if (left.size() > right.size()) {
      return left.peek();
    } else {
      return ((double) left.peek() + right.peek()) / 2d;
    }
  }
}
