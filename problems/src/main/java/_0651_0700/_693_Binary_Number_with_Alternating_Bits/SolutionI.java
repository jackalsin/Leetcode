package _0651_0700._693_Binary_Number_with_Alternating_Bits;

/**
 * @author jacka
 * @version 1.0 on 3/15/2020
 */
public final class SolutionI implements Solution {
  @Override
  public boolean hasAlternatingBits(int n) {
    int prevBit = n & 1;
    n >>>= 1;
    while (n != 0) {
      final int curBit = n & 1;
      if ((curBit ^ prevBit) == 0) {
        return false;
      }
      prevBit = curBit;
      n >>>= 1;
    }
    return true;
  }
}
