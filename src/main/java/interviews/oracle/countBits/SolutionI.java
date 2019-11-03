package interviews.oracle.countBits;

/**
 * @author jacka
 * @version 1.0 on 11/2/2019
 */
public final class SolutionI implements Solution {
  private static final int[] BITS = {
//0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15
      0, 1, 1, 2, 1, 2, 2, 3, 1, 2, 2, 3, 2, 3, 3, 4
  };

  public int bitCount(int n) {
    return BITS[n & 0xf] + BITS[(n >> 4) & 0xf] + BITS[(n >> 8) & 0xf] + BITS[(n >> 12) & 0xf]
        + BITS[(n >> 16) & 0xf] + BITS[(n >> 20) & 0xf] + BITS[(n >> 24) & 0xf] + BITS[(n >> 28) & 0xf];
  }
}
