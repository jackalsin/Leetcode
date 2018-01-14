package interviews.google._406_Queue_Reconstruction_by_Height;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 1/14/2018.
 */
public class Solution {
  public int[][] reconstructQueue(int[][] people) {
    Arrays.sort(people, new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        int cmp = Integer.compare(o2[0], o1[0]);
        if (cmp == 0) {
          return Integer.compare(o1[1], o2[1]);
        }
        return cmp;
      }
    });
    List<int[]> res = new LinkedList<>();
    for (final int[] p : people) {
      res.add(p[1], p);
    }
    return res.toArray(new int[0][0]);
  }
}
