package _1401_1450._1403_Minimum_Subsequence_in_Non_Increasing_Order;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author jacka
 * @version 1.0 on 4/4/2020
 */
public final class SolutionI implements Solution {
  @Override
  public List<Integer> minSubsequence(int[] nums) {
    final LinkedList<Integer> result = new LinkedList<>();
    final Queue<Integer> pq = new PriorityQueue<>((x, y) -> Integer.compare(y, x));
    long sum = 0;
    for (int n : nums) {
      sum += n;
      pq.add(n);
    }
    long listSum = 0;
    while (listSum <= sum) {
      final int toRemove = pq.remove();
      listSum += toRemove;
      sum -= toRemove;
      result.add(toRemove);
    }
    return result;
  }
}
