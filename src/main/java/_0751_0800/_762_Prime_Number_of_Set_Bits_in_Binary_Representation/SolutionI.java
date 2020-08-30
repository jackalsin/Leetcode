package _0751_0800._762_Prime_Number_of_Set_Bits_in_Binary_Representation;

import java.util.stream.IntStream;

/**
 * @author jacka
 * @version 1.0 on 8/29/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int countPrimeSetBits(int L, int R) {
    return IntStream.range(L, R + 1).map(i -> 0b10100010100010101100 >> Integer.bitCount(i) & 1).sum();
  }
}
