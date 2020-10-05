package microsoft.noodleEssence._295_Find_Median_from_Data_Stream;

import java.util.Collections;
import java.util.PriorityQueue;

public final class MedianFinder {

  private final PriorityQueue<Integer> small = new PriorityQueue<>(Collections.reverseOrder()),
      large = new PriorityQueue<>();

  public void addNum(int num) {
    assert small.size() == large.size() || small.size() == large.size() + 1;
    if (small.size() == large.size()) {
      if (small.size() == 0) {
        small.add(num);
      } else {
        if (large.peek() < num) {
          large.add(num);
          small.add(large.remove());
        } else {
          small.add(num);
        }
      }
    } else { // small.size() == large.size() + 1
      if (small.peek() <= num) {
        large.add(num);
      } else {
        small.add(num);
        large.add(small.remove());
      }
    }
  }

  public double findMedian() {
    assert !small.isEmpty();
    return small.size() > large.size() ? small.peek() :
        ((double) small.peek() + (double) large.peek()) / 2d;
  }
}
