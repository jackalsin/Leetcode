package _1301_1350._1343_Number_of_Sub_arrays_of_Size_K_and_Average_Greater_than_or_Equal_to_Threshold;

/**
 * @author jacka
 * @version 1.0 on 8/7/2021
 */
public final class SolutionI implements Solution {
  @Override
  public int numOfSubarrays(int[] arr, int k, int threshold) {
    long target = (long) k * threshold;
    long sum = 0;
    int count = 0;
    for (int i = 0; i < arr.length; ++i) {
      if (i >= k) sum -= arr[i - k];
      sum += arr[i];
      if (i >= k - 1) {
        if (sum >= target) count++;
      }
    }
    return count;
  }
}
