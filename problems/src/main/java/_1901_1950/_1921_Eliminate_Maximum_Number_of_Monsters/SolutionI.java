package _1901_1950._1921_Eliminate_Maximum_Number_of_Monsters;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author jacka
 * @version 1.0 on 9/19/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int eliminateMaximum(int[] dist, int[] speed) {
    final Queue<Integer> q = new PriorityQueue<>(Integer::compare);
    final int n = dist.length;
    for(int i = 0; i <n ;++i  ) {
      q.add((int) Math.ceil((double)dist[i] / speed[i]));
    }
    for(int t = 0; t < n ; ++t) {
      final int toRemove = q.remove();
      if(toRemove <= t) return t;
    }
    return n;
  }
}
