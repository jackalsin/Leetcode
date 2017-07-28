package _151_200._190_Reverse_Bits;

import java.util.Arrays;
import java.util.BitSet;


/**
 * @author Zhiwei.Xin
 * @version 1.0 on 7/26/2017.
 */
public class Solution {
  // you need treat n as an unsigned value
  public int reverseBits(int n) {
    int result = 0;
    int k = 32;
    while (k-- != 0) {
      int lastBit = n & 1;
      n >>=1;
      result <<= 1;
      result |= lastBit;
    }
    return result;
  }

}
