package _0901_0950._932_Beautiful_Array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 9/22/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int[] beautifulArray(int N) {
    /*这题有个总结，<a href='https://leetcode.com/problems/beautiful-array/discuss/186679/Odd-%2B-Even-Pattern-O(N)' />
     注意，如果A是全奇数， B是全偶数，且均为 beautiful array, A.append(B) is still beautiful array
     */
    final List<Integer> result = help(N);
    return result.stream().mapToInt(x -> x).toArray();
  }

  private List<Integer> help(final int N) {
    if (N == 1) {
      return List.of(1);
    }
    final List<Integer> src = help((N + 1) / 2),
        result = new ArrayList<>();
    for (int s : src) {
      if (2 * s - 1 <= N) result.add(2 * s - 1);
    }
    for (int s : src) {
      if (2 * s <= N) result.add(2 * s);
    }
    return result;
  }
}
