package _0701_0750._717_1_bit_and_2_bit_Characters;

/**
 * @author jacka
 * @version 1.0 on 5/17/2020
 */
public final class SolutionI implements Solution {
  @Override
  public boolean isOneBitCharacter(int[] bits) {
    if (bits == null || bits.length < 2) return true;
    final int n = bits.length;
    final boolean[] canFormIfLast2Are2Bits = new boolean[n];
    canFormIfLast2Are2Bits[n - 1] = false;
    canFormIfLast2Are2Bits[n - 2] = bits[n - 2] != 0;
    for (int i = n - 3; i >= 0; --i) {
      if (bits[i] == 0) {
        canFormIfLast2Are2Bits[i] |= canFormIfLast2Are2Bits[i + 1];
      } else {
        canFormIfLast2Are2Bits[i] |= canFormIfLast2Are2Bits[i + 2];
      }
    }
//    System.out.println(Arrays.toString(canFormIfLast2Are2Bits));
    return !canFormIfLast2Are2Bits[0];
  }
}