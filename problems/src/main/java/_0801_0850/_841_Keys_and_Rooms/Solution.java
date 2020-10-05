package _0801_0850._841_Keys_and_Rooms;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 2/24/2019.
 */
public final class Solution {
  public boolean canVisitAllRooms(List<List<Integer>> rooms) {
    final Queue<Integer> q = new ArrayDeque<>();
    final Set<Integer> visited = new HashSet<>();
    q.add(0);
    visited.add(0);

    while (!q.isEmpty()) {
      final int next = q.remove();
      for (int key : rooms.get(next)) {
        if (!visited.contains(key)) {
          q.add(key);
          visited.add(key);
        }
      }
    }
    return visited.size() == rooms.size();
  }
}
