package _451_500._477_Total_Hamming_Distance;

public class Solution {

  public int totalHammingDistance(int[] nums) {
    final int total = nums.length;
    final int[] bitCounts = new int[32];
    for (int num : nums) {
      for (int i = 0; i < 32; i++) {
        if (((num >> i) & 1) == 1) {
          bitCounts[i]++;
        }
      }
    }

    int res = 0;
    for (int bitCount : bitCounts) {
      res += (total - bitCount) * bitCount;
    }
    return res;
  }
}
