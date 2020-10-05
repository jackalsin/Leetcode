package _0751_0800._763_Partition_Labels;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 8/29/2020
 */
public final class SolutionI implements Solution {
  @Override
  public List<Integer> partitionLabels(String s) {
    final int[] lastSeen = getLastSeen(s);
    final int n = s.length();
    final List<Integer> result = new ArrayList<>();
    for (int i = 0; i < n; ) {
      final char chr = s.charAt(i);
      int chrIndex = chr - 'a', lastIndex = lastSeen[chrIndex];
      for (int j = i; j <= lastIndex; ++j) {
        final char jChar = s.charAt(j);
        final int jIndex = jChar - 'a';
        lastIndex = Math.max(lastIndex, lastSeen[jIndex]);
      }
      result.add(lastIndex - i + 1);
      i = lastIndex + 1;
    }
    return result;
  }

  private int[] getLastSeen(final String s) {
    final int[] result = new int[26];
    Arrays.fill(result, -1);
    for (int i = 0; i < s.length(); ++i) {
      final int index = s.charAt(i) - 'a';
      result[index] = i;
    }
    return result;
  }
}
