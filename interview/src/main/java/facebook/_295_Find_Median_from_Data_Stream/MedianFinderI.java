package facebook._295_Find_Median_from_Data_Stream;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author jacka
 * @version 1.0 on 5/1/2021
 */
public final class MedianFinderI implements MedianFinder {
  private final Queue<Integer> left = new PriorityQueue<>((x, y) -> Integer.compare(y, x)),
      right = new PriorityQueue<>();

  public void addNum(int num) {
    left.add(num);
    right.add(left.remove());
    if (left.size() < right.size()) {
      left.add(right.remove());
    }
  }

  public double findMedian() {
    assert !left.isEmpty();
    final long total = left.size() + right.size();
    if (total % 2 == 0) {
      return (((double) left.peek()) + right.peek()) / 2;
    }
    return left.peek();
  }
}
