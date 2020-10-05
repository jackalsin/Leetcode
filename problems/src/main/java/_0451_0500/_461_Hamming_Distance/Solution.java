package _0451_0500._461_Hamming_Distance;

/**
 * @author jacka
 * @version 1.0 on 1/14/2018.
 */
public class Solution {
  public int hammingDistance(int x, int y) {
    int sameBit = x & y;
    return Integer.bitCount((~sameBit) & x) + Integer.bitCount((~sameBit) & y);
  }
}
