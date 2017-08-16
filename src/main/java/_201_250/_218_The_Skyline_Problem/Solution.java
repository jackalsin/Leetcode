package _201_250._218_The_Skyline_Problem;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * @author jacka
 * @version 1.0 on 8/15/2017.
 */
public class Solution {
  /**
   * https://briangordon.github.io/2014/08/the-skyline-problem.html
   *
   * The key is to
   *  for each critical point c
   *    c.y gets the height of the tallest rectangle over c
   *
   * @param buildings an array of [left, right, height]
   * @return
   */
  public List<int[]> getSkyline(int[][] buildings) {
    Map<Integer, List<int[]>> criticalPoints = new TreeMap<>();
    for (int[] building : buildings) { //getOrDefault
      criticalPoints.putIfAbsent(building[0], new ArrayList<>());
      criticalPoints.putIfAbsent(building[1], new ArrayList<>());
      criticalPoints.get(building[0]).add(building);
      criticalPoints.get(building[1]).add(building);
    }

    PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        return Integer.compare(o2[2], o1[2]);
      }
    });

    List<int[]> result = new ArrayList<>();
    for (Map.Entry<Integer, List<int[]>> entry : criticalPoints.entrySet()) {
      int cpLeft = entry.getKey();
      List<int[]> edgesContainsCriticalPoints = entry.getValue();
      for (int[] child : edgesContainsCriticalPoints) {
        if (cpLeft == child[0]) { // left edge
          pq.offer(child);
        } else {
          pq.remove(child);
        }
      }

      if(pq.isEmpty()) {
        result.add(new int[] {cpLeft, 0});
      } else {
        int h = pq.peek()[2];
        if (result.size() == 0 || h != result.get(result.size() - 1)[1]) {
          result.add(new int[] {cpLeft, h});
        }
      }
    }

    return result;
  }

}
