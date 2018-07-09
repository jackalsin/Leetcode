package interviews.microsoft._191_Number_of_1_Bits;

public class Solution {
  public int hammingWeight(int n) {
    int count = 0;
    while (n != 0) {
      if ((n & 1) == 1) {
        count++;
      }
      n >>>= 1;
    }
    return count;
  }
}
