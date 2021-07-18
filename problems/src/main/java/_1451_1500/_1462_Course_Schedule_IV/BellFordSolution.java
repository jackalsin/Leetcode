package _1451_1500._1462_Course_Schedule_IV;

import java.util.ArrayList;
import java.util.List;

public final class BellFordSolution implements Solution {
  @Override
  public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
    final boolean[][] isParent = new boolean[numCourses][numCourses];
    for (final int[] pre : prerequisites) {
      final int p = pre[0], c = pre[1];
      isParent[p][c] = true;
    }
    for (int m = 0; m < numCourses; ++m) {
      for (int i = 0; i < numCourses; ++i) {
        for (int j = 0; j < numCourses; ++j) {
          isParent[i][j] = isParent[i][j] || isParent[i][m] && isParent[m][j];
        }
      }
    }
    final List<Boolean> result = new ArrayList<>();
    for (final int[] q : queries) {
      result.add(isParent[q[0]][q[1]]);
    }
    return result;
  }
}
