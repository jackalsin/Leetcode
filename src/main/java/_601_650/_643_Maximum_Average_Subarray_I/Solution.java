package _601_650._643_Maximum_Average_Subarray_I;

public class Solution {
  public double findMaxAverage(int[] nums, int k) {
    double avg = 0;
    for (int i = 0; i < k; i++) {
      avg += (double) nums[i] / (double) k;
    }
    double maxAvg = avg;
    for (int i = k; i < nums.length; i++) {
      avg += (double) nums[i] / (double) k - (double) nums[i - k] / (double) k;
      maxAvg = Math.max(avg, maxAvg);
    }
    return maxAvg;
  }
}
