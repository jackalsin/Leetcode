package byteDance._295_Find_Median_from_Data_Stream;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author jacka
 * @version 1.0 on 5/8/2020
 */
public final class MedianFinderI implements MedianFinder {
  private final Queue<Integer> small = new PriorityQueue<>((x, y) -> Integer.compare(y, x)),
      big = new PriorityQueue<>(Integer::compare);

  public void addNum(int num) {
    small.add(num);
    big.add(small.remove());
    if (big.size() > small.size()) {
      small.add(big.remove());
    }
  }

  public double findMedian() {
    if (big.size() == small.size()) {
      return ((double) big.peek() + small.peek()) / 2d;
    }
    return small.peek();
  }
}
