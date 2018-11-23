package _0901_0950._933_Number_of_Recent_Calls;

import java.util.ArrayDeque;
import java.util.Queue;

public class RecentCounter {
  private Queue<Integer> q = new ArrayDeque<>();

  public int ping(int t) {
    q.add(t);
    while (!q.isEmpty() && q.peek() + 3000 < t) {
      q.remove();
    }
    return q.size();
  }
}
