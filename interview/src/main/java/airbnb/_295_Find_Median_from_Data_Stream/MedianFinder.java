package airbnb._295_Find_Median_from_Data_Stream;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author jacka
 * @version 1.0 on 3/3/2019.
 */
public final class MedianFinder {
  private final Queue<Integer> small = new PriorityQueue<>(new Comparator<Integer>() {
    @Override
    public int compare(Integer o1, Integer o2) {
      return Integer.compare(o2, o1);
    }
  }), big = new PriorityQueue<>();

  public void addNum(int num) {
    small.add(num);
    big.add(small.remove());
    if (big.size() > small.size()) {
      small.add(big.remove());
    }
  }

  public double findMedian() {
    if (small.size() == big.size()) {
      return ((double) small.peek() + big.peek()) / 2;
    }
    return small.peek();
  }
}
