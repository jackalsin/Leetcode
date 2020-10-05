package byteDance._670_Maximum_Swap;

/**
 * @author jacka
 * @version 1.0 on 5/10/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int maximumSwap(int num) {
    final char[] chars = String.valueOf(num).toCharArray();
    final int[] lastSeen = new int[10];
    for (int i = 0; i < chars.length; ++i) {
      lastSeen[chars[i] - '0'] = i;
    }
    outI:
    for (int i = 0; i < chars.length; ++i) {
      for (int k = 9; k > chars[i] - '0'; --k) {
        if (lastSeen[k] > i) {
          swap(chars, i, lastSeen[k]);
          break outI;
        }
      }
    }
    return Integer.parseInt(String.valueOf(chars));
  }

  private static void swap(final char[] chars, final int a, final int b) {
    final char c = chars[a];
    chars[a] = chars[b];
    chars[b] = c;
  }
}
