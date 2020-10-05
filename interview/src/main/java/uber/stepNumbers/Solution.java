package uber.stepNumbers;

import java.util.HashSet;
import java.util.Set;

public final class Solution {

  public Set<Integer> generateNoGreaterThan(int max) {
    assert max > 0;
    final Set<Integer> result = new HashSet<>();
    for (int i = 1; i <= Math.min(9, max); i++) {
      result.add(i);
      dfs(result, i, max);
    }
    return result;
  }

  private static void dfs(final Set<Integer> result, final int num, final int max) {
    if (num * 10 < 0 || num * 10 > max) {
      return;
    }
    final int ones = num % 10, pos = ones == 9 ? 0 : ones + 1, neg = ones == 0 ? 9 : ones - 1;
    final int posCandidate = num * 10 + pos, negCandidate = num * 10 + neg;
    if (posCandidate > 0 && posCandidate <= max) {
      result.add(posCandidate);
      dfs(result, posCandidate, max);
    }

    if (negCandidate > 0 && negCandidate <= max) {
      result.add(negCandidate);
      dfs(result, negCandidate, max);
    }

  }
}
