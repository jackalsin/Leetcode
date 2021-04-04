package lime._670_Maximum_Swap;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author jacka
 * @version 1.0 on 4/3/2021
 */
public final class SolutionI implements Solution {
  public int maximumSwap(int num) {
    final char[] chars = String.valueOf(num).toCharArray();
    final int len = chars.length;
    final TreeMap<Integer, Integer> firstIndex = new TreeMap<>();
    int first = len - 1, second = len - 1;
    for (int i = len - 1; i >= 0; --i) {
      final Map.Entry<Integer, Integer> e = firstIndex.lastEntry();
      if (e != null) {
        final int key = e.getKey(), val = e.getValue();
        if (key > chars[i] - '0') {
          first = i;
          second = val;
        }
      }
      firstIndex.putIfAbsent(chars[i] - '0', i);
    }
    swap(chars, first, second);
    return Integer.parseInt(String.valueOf(chars));
  }

  private static void swap(final char[] chars, final int i, final int j) {
    final char tmp = chars[i];
    chars[i] = chars[j];
    chars[j] = tmp;
  }

}
