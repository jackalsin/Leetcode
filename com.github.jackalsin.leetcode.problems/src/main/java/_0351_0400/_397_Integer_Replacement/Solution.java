package _0351_0400._397_Integer_Replacement;

/**
 * @author jacka
 * @version 1.0 on 11/11/2017.
 */
public class Solution {

  /**
   * Move you need when you come across in the mid.
   */
  private static final int[] MOVES = new int[32];
  static {
    MOVES[0] = 0;
    MOVES[1] = 2;
    MOVES[2] = 3;
    for (int i = 3;i < MOVES.length; i++ ) {
      MOVES[i] = i + 1;
    }
  }

  public int integerReplacement(int n) {
    int count = 0;
    while (n != 1 && n != 0) {
      if ((n & 1) == 0) {
        n >>>= 1;
        count++;
      } else {
        if (n == 3) { // if it's leading 0b11, you only need 2 steps, -1, right shift 1;
          count += 2;
          n >>= 1;
        } else {
          int leastSignificantBitCount = 0;
          while ((n & 1) != 0) {
            n >>>= 1;
            leastSignificantBitCount++;
          }
          if (leastSignificantBitCount != 1) n |= 1;
          count += MOVES[leastSignificantBitCount];
        }
      }
    }

    return count;
  }
}
