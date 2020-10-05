package airbnb._190_Reverse_Bits;

/**
 * @author jacka
 * @version 1.0 on 1/27/2019.
 */
public class Solution {
  public int reverseBits(int n) {
    int res = 0;
    for (int i = 0; i < 32; i++) {
      final int bit = n & 1;
      n >>= 1;
      res = (res << 1) | bit;
    }
    return res;
  }
}
