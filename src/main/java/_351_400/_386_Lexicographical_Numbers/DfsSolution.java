package _351_400._386_Lexicographical_Numbers;

import java.util.ArrayList;
import java.util.List;

public final class DfsSolution implements Solution {
  /**
   * 26 / 26 test cases passed.
   * Status: Accepted
   * Runtime: 216 ms
   *
   * @param n
   * @return
   */
  @Override
  public List<Integer> lexicalOrder(int n) {
    final List<Integer> result = new ArrayList<>();
    lexicalOrder(n, result, 0);
    return result;
  }

  private static void lexicalOrder(final int n, final List<Integer> result, final int start) {
    if (start > n) {
      return;
    }
    if (start != 0) {
      result.add(start);
    }
    for (int i = (start == 0 ? 1 : 0); i < 10; i++) {
      final int newStart = start * 10 + i;
      if (newStart > n) {
        break;
      }
      lexicalOrder(n, result, newStart);
    }
  }
}
