package _1651_1700._1673_Find_the_Most_Competitive_Subsequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhixi
 * @version 1.0 on 11/30/2020
 */
public final class DpSolution implements Solution {
  @Override
  public int[] mostCompetitive(final int[] nums, final int K) {
    final int n = nums.length;
    List[][] dp = new ArrayList[K][n + 1];
    dp[0][0] = new ArrayList<>();
    Arrays.fill(dp[0], null);
    for (int i = 0; i < n; ++i) {
      final List<Integer> cur = new ArrayList<>(min((List<Integer>) dp[0][i], List.of(nums[i])));
      dp[0][i + 1] = cur;
    }

    for (int i = 1; i < K; ++i) {
//      Arrays.fill(dp[i], Integer.MAX_VALUE);
      for (int j = i; j < n; ++j) {
        final List<Integer> cur = new ArrayList<>(dp[i - 1][j]);
        cur.add(nums[j]);
        dp[i][j + 1] = min(cur, dp[i][j]);
      }
    }
    return dp[K - 1][n].stream().mapToInt(x -> (int) x).toArray();
  }

  private List<Integer> min(final List<Integer> arr1, final List<Integer> arr2) {
    if (arr1 == null) {
      return arr2;
    }
    if (arr2 == null) {
      return arr1;
    }
    assert arr1.size() == arr2.size();
    for (int i = 0; i < arr1.size(); i++) {
      final int cmp = Integer.compare(arr1.get(i), arr2.get(i));
      if (cmp < 0) {
        return arr1;
      } else if (cmp == 0) {
        continue;
      } else {
        return arr2;
      }
    }
    return arr1;
  }
}
