package _051_100._060_Permutation_Sequence;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 4/22/2017.
 */
public class Solution {
  public String getPermutation(int n, int k) {
    List<Integer> candidates = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < n; i++) {
      candidates.add(i + 1);
    }
    int[] factorial = new int[n + 1];
    factorial[1] = 1;
    for (int i = 2; i < n; i++) {
      factorial[i] = factorial[i - 1] * i;
    }
    k--;
    for (int i = 0; i < n - 1; i++) {
      int index = k / factorial[n - i - 1];
      sb.append(candidates.remove(index));
      k -= index * factorial[n - i - 1];
    }
    sb.append(candidates.get(0));
    return sb.toString();
  }
}
