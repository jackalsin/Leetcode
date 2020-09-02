package _0801_0850._830_Positions_of_Large_Groups;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 9/2/2020
 */
public final class SolutionI implements Solution {
  @Override
  public List<List<Integer>> largeGroupPositions(String s) {
    final List<List<Integer>> result = new ArrayList<>();
    final int n = s.length();
    for (int start = 0; start < n; ) {
      int end = start;
      final char chr = s.charAt(start);
      while (end + 1 < n && chr == s.charAt(end + 1)) {
        end++;
      }
      final int len = end - start + 1;
      if (len >= 3) {
        result.add(List.of(start, end));
      }
      start = end + 1;
    }
    return result;
  }
}
