package _401_450._414_Third_Maximum_Number;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeSet;

public class Solution {
  public int thirdMax(int[] nums) {
    final TreeSet<Integer> pq = new TreeSet<>(new Comparator<>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        return Integer.compare(o1, o2);
      }
    });

    for (int i : nums) {
      pq.add(i);
      if (pq.size() > 3) {
        pq.remove(pq.first());
      }
    }
    return pq.isEmpty() ? -1: (pq.size() < 3 ? pq.last() : pq.first());
  }
}
