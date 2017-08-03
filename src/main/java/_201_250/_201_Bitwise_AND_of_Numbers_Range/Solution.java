package _201_250._201_Bitwise_AND_of_Numbers_Range;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 8/2/2017.
 */
public class Solution {
  public int rangeBitwiseAnd(int m, int n) {
    int factor = 1;
    while (m != n) {
      m >>= 1;
      n >>= 1;
      factor <<= 1;
    }
    return m * factor;
  }
}
