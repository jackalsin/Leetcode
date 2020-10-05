package linkedin._060_Permutation_Sequence;

import java.util.ArrayList;
import java.util.List;

public class Solution {

  private static final int[] FACTORIAL = new int[10];

  static {
    int tmp = 1;
    for (int i = 1; i <= 9; ++i) {
      tmp *= i;
      FACTORIAL[i] = tmp;
    }
  }

  public String getPermutation(int n, int k) {
    assert n >= 1 && n <= 9;
    final StringBuilder sb = new StringBuilder();
    final List<Integer> candidates = new ArrayList<>();
    for (int i = 1; i <= n; ++i) {
      candidates.add(i);
    }
    k--;
    for (int i = 1, remainDigits = n - 1; i <= n; ++i, --remainDigits) {
      final int perCount = FACTORIAL[remainDigits];
      final int index = perCount == 0 ? 0 : (k / perCount);
      k -= index * perCount;
      sb.append(candidates.get(index));
      candidates.remove(index);
    }
    return sb.toString();
  }
}
