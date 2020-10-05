package google._295_Find_Median_from_Data_Stream;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author jacka
 * @version 1.0 on 4/20/2020
 */
public final class SolutionI implements MedianFinder {
  private final Queue<Integer> small = new PriorityQueue<>(new Comparator<Integer>() {
    @Override
    public int compare(Integer o1, Integer o2) {
      return Integer.compare(o2, o1);
    }
  }), larger = new PriorityQueue<>();

  public void addNum(int num) {
    small.add(num);
    larger.add(small.remove());
    if (larger.size() > small.size()) {
      small.add(larger.remove());
    }
  }

  public double findMedian() {
    assert small.size() == larger.size() || small.size() == larger.size() + 1;
    if (small.size() == larger.size()) {
      return ((double) small.peek() + larger.peek()) / 2d;
    }
    return small.peek();
  }
}
