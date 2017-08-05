package _201_250._201_Bitwise_AND_of_Numbers_Range;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 8/2/2017.
 */
public class Solution {
  /**
   *
   * @param m
   * @param n
   * @return
   */
  public int rangeBitwiseAnd(int m, int n) {
    /*
      last bit of (odd number & even number) is 0.
      when m != n, There is at least an odd number and an even number, so the last bit position result is 0.
      Move m and n rigth a position.
    */
    int factor = 1;
    while (m != n) {
      m >>= 1;
      n >>= 1;
      factor <<= 1;
    }
    return m * factor;
  }
}
