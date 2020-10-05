package _1001_1050._1029_Two_City_Scheduling;

import java.util.Arrays;
import java.util.Comparator;

public final class SortSolution implements Solution {
  public int twoCitySchedCost(int[][] costs) {
    if (costs == null || costs.length == 0) {
      return 0;
    }
    Arrays.sort(costs, new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        return Integer.compare(o1[0] - o1[1], o2[0] - o2[1]);
      }
    });
    int res = 0;
    for (int i = 0; i < costs.length; i++) {
      res += costs[i][i < costs.length / 2 ? 0 : 1];
    }
    return res;
  }

}
