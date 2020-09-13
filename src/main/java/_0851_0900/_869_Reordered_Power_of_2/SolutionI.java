package _0851_0900._869_Reordered_Power_of_2;

/**
 * @author jacka
 * @version 1.0 on 9/13/2020
 */
public final class SolutionI implements Solution {

  public boolean reorderedPowerOf2(int N) {
    final long key = getCharMap(N);
    for (int i = 1; i > 0; i <<= 1) {
      final long c = getCharMap(i);
      if (c == key) return true;
    }
    return false;
  }

  private static long getCharMap(int val) {
    long res = 0;
    for (; val > 0; val /= 10) {
      res += (long) Math.pow(10, val % 10);
    }
    return res;
  }
}
