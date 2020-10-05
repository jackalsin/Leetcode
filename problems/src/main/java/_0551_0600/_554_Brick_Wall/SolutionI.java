package _0551_0600._554_Brick_Wall;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class SolutionI implements Solution {
  public int leastBricks(List<List<Integer>> wall) {
    final Set<Integer> allPossibleX = new HashSet<>();
    final List<List<Integer>> wallBoundary = new ArrayList<>();

    // get all possible X
    for (List<Integer> brick : wall) {
      final List<Integer> curRow = new ArrayList<>();
      wallBoundary.add(curRow);
      int right = 0;
      for (int b : brick) {
        right += b;
        curRow.add(right);
        allPossibleX.add(right);
      }
    }

    int minBricks = wall.size();
    List<Integer> sortX = new ArrayList<>(allPossibleX);
    Collections.sort(sortX);
    sortX.remove(sortX.size() - 1);

    final int[] curIndex = new int[wall.size()];

    for (int possibleX : sortX) {
      int curBricks = wall.size();
      for (int row = 0; row < curIndex.length; row++) {
        while (wallBoundary.get(row).get(curIndex[row]) < possibleX) {
          curIndex[row]++;
        }
        if (wallBoundary.get(row).get(curIndex[row]) == possibleX) {
          curBricks--;
          curIndex[row]++;
        }
      } // end of for loop
      minBricks = Math.min(minBricks, curBricks);
    }
    return minBricks;
  }
}

