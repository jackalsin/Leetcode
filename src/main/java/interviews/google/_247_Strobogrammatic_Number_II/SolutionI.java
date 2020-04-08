package interviews.google._247_Strobogrammatic_Number_II;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 4/7/2020
 */
public final class SolutionI implements Solution {
  private static final Map<Integer, Integer> ROTATE = Map.of(
      0, 0,
      1, 1,
      6, 9,
      8, 8,
      9, 6
  );

  public List<String> findStrobogrammatic(int n) {
    final List<String> result = new ArrayList<>();
    final char[] string = new char[n];
    fill(result, string, 0, n - 1);
    return result;
  }

  private static void fill(final List<String> result, final char[] string, final int i, final int j) {
    if (i > j) {
      result.add(String.valueOf(string));
      return;
    }
    for (final Map.Entry<Integer, Integer> e : ROTATE.entrySet()) {
      final int left = e.getKey(), right = e.getValue();
      if (i == 0 && left == 0 && j != 0) {
        continue;
      }
      if (i == j && (left == 6 || left == 9)) {
        continue;
      }
      string[i] = (char) ('0' + left);
      string[j] = (char) ('0' + right);
      fill(result, string, i + 1, j - 1);
    }
  }
}
