package airbnb._190_Reverse_Bits;

/**
 * @author jacka
 * @version 1.0 on 8/20/2021
 */
public final class SolutionII implements Solution {
  @Override
  public int reverseBits(int n) {
    int res = 0;
    for (int i = 0; i < 32; ++i) {
      res = (res << 1) | (n & 1);
      n >>>= 1;
    }
    return res;
  }
}
