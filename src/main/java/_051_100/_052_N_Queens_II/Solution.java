package _051_100._052_N_Queens_II;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 3/18/2017.
 */
public class Solution {
  public int totalNQueens(int n) {
    if (n <= 0) {
      throw new IllegalArgumentException("n must be positive, which now is " + n);
    }
    Set<Integer> candidates = new HashSet<>();
    for (int i = 0; i < n; i++) {
      candidates.add(i);
    }
    List<List<Integer>> results = new ArrayList<>();
    solveRow(results, new ArrayList<>(), candidates, n);
    return results.size();
  }
  public void solveRow(List<List<Integer>> results , List<Integer> curPath, Set<Integer>
      candidates, int n) {
    if (candidates.isEmpty()) {
      results.add(new ArrayList<>(curPath));
    } else {
      for (int candidate: candidates) {
        curPath.add(candidate);
        if (isValid(curPath, n)) {
          Set<Integer> candidatesCopy = new HashSet<>(candidates);
          candidatesCopy.remove(candidate);
          solveRow(results, curPath, candidatesCopy, n);
        }
        curPath.remove(curPath.size() - 1);
      }
    }
  }

  private boolean isValid(List<Integer> curPath, int n) {
    Set<Integer> curSet = new HashSet<>(curPath);
    if (curPath.size() != curSet.size()) {
      return false;
    }
    int curRow = curPath.size() - 1;
    int curCol = curPath.get(curRow);
    for (int row = 0; row < curPath.size() - 1; row++) {
      if ((row - curPath.get(row) == curRow - curCol) || (row + curPath.get(row) == curRow + curCol)) {
        return false;
      }
    }
    return true;
  }
}
