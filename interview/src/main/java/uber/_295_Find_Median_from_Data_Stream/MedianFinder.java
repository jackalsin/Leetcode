package uber._295_Find_Median_from_Data_Stream;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author jacka
 * @version 1.0 on 3/23/2018.
 */
public final class MedianFinder {
  private final Queue<Integer> small = new PriorityQueue<>(new Comparator<Integer>() {
    @Override
    public int compare(final Integer i1, final Integer i2) {
      return Integer.compare(i2, i1);
    }
  }), large = new PriorityQueue<>();

  public void addNum(int num) {
    small.add(num);
    large.add(small.remove());
    while (large.size() > small.size()) {
      small.add(large.remove());
    }
  }

  public double findMedian() {
    assert !small.isEmpty() || !large.isEmpty();
    if (small.size() == large.size()) {
      return ((double) small.peek() + (double) large.peek()) / 2d;
    } else {
      return small.peek();
    }
  }
}
