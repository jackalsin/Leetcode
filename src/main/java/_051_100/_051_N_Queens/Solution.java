package _051_100._051_N_Queens;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 3/3/2017.
 */
public class Solution {

  public List<List<String>> solveNQueens(int n) {
    if (n <= 0) {
      return new ArrayList<>();
    }
    Set<Integer> candidates = new HashSet<>();
    for (int i = 0; i < n; i++) {
      candidates.add(i);
    }
    List<List<Integer>> result = new ArrayList<>();
    solveNQueensHelper(result, new ArrayList<>(), 0, n, candidates);
    return generateFinalResult(result);
  }

  private List<List<String>> generateFinalResult(List<List<Integer>> results) {
    List<List<String>> strResults = new ArrayList<>();
    for (List<Integer> subList : results) {
      List<String> curResult = new ArrayList<>();
      for (int qCol : subList) {
        char[] chars = new char[subList.size()];
        Arrays.fill(chars, '.');
        chars[qCol] = 'Q';
        curResult.add(String.valueOf(chars));
      }
      strResults.add(curResult);
    }
    return strResults;
  }

  private void solveNQueensHelper(List<List<Integer>> result,
                                  List<Integer> curPath, int row, int rows,
                                  Set<Integer> candidates) {
    if (row == rows) {
      result.add(new ArrayList<>(curPath));
    } else {
      for (int cand : candidates) {
        List<Integer> curPathCopy = new ArrayList<>(curPath);
        Set<Integer> curCandidates = new HashSet<>(candidates);
        curCandidates.remove(cand);
        curPathCopy.add(cand);
        if (isValid(curPathCopy, row)) {
          solveNQueensHelper(result, curPathCopy, row + 1, rows, curCandidates);
        }

      }
    }
  }

  /**
   * To decide if the Q on curRow is valid in triangle and anti-triangle direction.
   * @param curPath col positions of the current board
   * @param curRow
   * @return
   */
  private boolean isValid(List<Integer> curPath, int curRow) {
    int curCol = curPath.get(curRow);
    for (int row = 0; row < curPath.size() - 1; row++) {
      int col = curPath.get(row);
      if ((row - col == curRow - curCol) || (row + col) == (curRow + curCol)) {
        return false;
      }
    }
    return true;
  }
}
