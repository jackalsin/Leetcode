package _0201_0250._218_The_Skyline_Problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @author jacka
 * @version 1.0 on 8/15/2017.
 */
public class Solution {
  /**
   * https://briangordon.github.io/2014/08/the-skyline-problem.html
   * <p>
   * Critical Points are those points whose height changes and then draw right
   * They only appear on the on the left or right edge of the rectangle.
   * <p>
   * The key is to
   * for each critical point c
   * c.y gets the height of the tallest rectangle over c
   *
   * @param buildings an array of [left, right, height]
   * @return
   */
  public List<List<Integer>> getSkyline(int[][] buildings) {
    Map<Integer, List<int[]>> criticalPoints = new TreeMap<>();
    for (int[] building : buildings) { //getOrDefault
      criticalPoints.putIfAbsent(building[0], new ArrayList<>());
      criticalPoints.putIfAbsent(building[1], new ArrayList<>());
      criticalPoints.get(building[0]).add(building);
      criticalPoints.get(building[1]).add(building);
    }
    TreeSet<int[]> pq = new TreeSet<>(new Comparator<int[]>() {
      /**
       * If using this comparator, in add, it's using comparator to add, when the last element
       * are the same, it will not add this int[].
       *
       * @param o1
       * @param o2
       * @return
       */
      @Override
      public int compare(int[] o1, int[] o2) {
        int cmp2 = Integer.compare(o2[2], o1[2]);
        if (cmp2 == 0) {
          int cmp1 = Integer.compare(o2[1], o1[1]);
          if (cmp1 == 0) {
            return Integer.compare(o2[0], o1[0]);
          }
          return cmp1;
        }
        return cmp2;
      }
    });

    List<List<Integer>> result = new ArrayList<>();
    for (Map.Entry<Integer, List<int[]>> entry : criticalPoints.entrySet()) {
      int cpLeft = entry.getKey();
      List<int[]> edgesContainsCriticalPoints = entry.getValue();
      for (int[] child : edgesContainsCriticalPoints) {
        if (cpLeft == child[0]) { // left edge
          pq.add(child);
        } else {
          pq.remove(child);
        }
      }

      if (pq.isEmpty()) {
        result.add(Arrays.asList(cpLeft, 0));
      } else {
        int h = pq.first()[2];
        if (result.size() == 0 || h != result.get(result.size() - 1).get(1)) {
          result.add(Arrays.asList(cpLeft, h));
        }
      }
    }

    return result;
  }

}
