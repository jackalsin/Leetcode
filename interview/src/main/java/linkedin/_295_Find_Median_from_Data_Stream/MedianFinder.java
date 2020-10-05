package linkedin._295_Find_Median_from_Data_Stream;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MedianFinder {
  private final Queue<Integer> small = new PriorityQueue<>(new Comparator<Integer>() {
    @Override
    public int compare(Integer o1, Integer o2) {
      return Integer.compare(o2, o1);
    }
  }), big = new PriorityQueue<>();


  public void addNum(int num) {
    // invariant: small.size() >= big.size();
    small.add(num);
    big.add(small.remove());
    if (small.size() < big.size()) {
      small.add(big.remove());
    }
  }

  public double findMedian() {
    if (small.isEmpty()) {
      throw new IllegalStateException("Cannot be empty");
    }

    if (small.size() == big.size()) {
      return (small.peek() + (double) big.peek()) / 2; // overflow
    } else {
      return small.peek();
    }
  }

}
