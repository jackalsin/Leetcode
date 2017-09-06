package _251_300._295_Find_Median_from_Data_Stream;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 9/5/2017.
 */
public class MedianFinder {
  private final Queue<Long> small;
  private final Queue<Long> large;
  /** initialize your data structure here. */
  public MedianFinder() {
    small = new PriorityQueue<>(new Comparator<Long>() {
      @Override
      public int compare(Long i, Long j) {
        return Long.compare(j, i);
      }
    });
    large = new PriorityQueue<>();
  }

  public void addNum(int num) {
//    longVersion(num);
    shortVersion(num);
  }

  private void shortVersion(int num) {
    small.add((long) num);
    large.add(small.poll());
    if (large.size() > small.size()) {
      small.add(large.poll());
    }
  }

  private void longVersion(int num) {
    assert small.size() >= large.size();
    long numL = (long) num;
    if (small.size() == 0) {
      small.add(numL);
    } else if (small.size() == large.size()) {
      if(small.peek() >= numL) small.add(numL);
      else {
        large.add(numL);
        small.add(large.poll());
      }
    } else {
      if (small.peek() >= numL) {
        small.add(numL);
        large.add(small.poll());
      } else {
        large.add(numL);
      }
    }
  }

  public double findMedian() {
    // overflow
    return small.size() > large.size() ? small.peek(): (double) (small.peek() + large.peek()) / 2;
  }

  public static void main(String[] args) {
    Queue<Integer> pq = new PriorityQueue<>();
    pq.add(1);
    pq.add(2);
    while (!pq.isEmpty()) {
      System.out.println(pq.remove()); // add equivalent to poll(), but remove is O(N)
    }
  }
}
