package _0651_0700._689_Maximum_Sum_of_3_Non_Overlapping_Subarrays;

public class Solution {
  public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
    final int n = nums.length;
    /*
     * posLeft[i] is the starting index for the left interval in range [0, i];
     * posRight[i] is the starting index for the right interval in range [i, n-1];
     */
    final int[] sum = new int[n + 1], posLeft = new int[n], posRight = new int[n];
    int[] ans = new int[3];
    for (int i = 0; i < n; i++) sum[i + 1] = sum[i] + nums[i];
    for (int i = k, maxSum = sum[k] - sum[0]; i < n; i++) {
      int curSum = sum[i + 1] - sum[i + 1 - k];
      if (curSum > maxSum) {
        maxSum = curSum;
        posLeft[i] = i + 1 - k;
      } else {
        posLeft[i] = posLeft[i - 1];
      }
    }

    // right
    for (int i = n - k, masSum = sum[n] - sum[n - k]; i >= 0; i--) {
      int curSum = sum[i + k] - sum[i];
      if (curSum >= masSum) {
        masSum = curSum;
        posRight[i] = i;
      } else {
        posRight[i] = posRight[i + 1];
      }
    }

    // iterate all possible intervals
    int maxSum = 0;
    for (int midStart = k; midStart <= n - 2 * k; midStart++) {
      int leftStart = posLeft[midStart - 1], rightStart = posRight[midStart + k];
      int curSum = (sum[leftStart + k] - sum[leftStart]) + (sum[midStart + k] - sum[midStart])
          + (sum[rightStart + k] - sum[rightStart]);
      if (curSum > maxSum) {
        maxSum = curSum;
        ans = new int[]{leftStart, midStart, rightStart};
      }
    }

    return ans;
  }
}
