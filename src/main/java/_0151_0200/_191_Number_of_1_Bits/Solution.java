package _0151_0200._191_Number_of_1_Bits;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 7/26/2017.
 */
public class Solution {
  public int hammingWeight(int n) {
    int count = 0;
    for (int i = 0; i < 32; i++) {
      count += (n & 1);
      n >>= 1;
    }
    return count;
  }
}
