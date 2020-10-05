package oracle._410_Split_Array_Largest_Sum;

/**
 * @author jacka
 * @version 1.0 on 12/7/2019
 */
public final class SolutionI implements Solution {
  @Override
  public int splitArray(int[] nums, int m) {
    // get sum and max
    long sum = 0, max = 0;
    for (int num : nums) {
      max = Math.max(max, num);
      sum += num;
    }
    // start from the max is important, otherwise, the cuts calculation can be wrong
    long left = max, right = sum;
    while (left < right) {
      final long mid = left + (right - left) / 2,
          cuts = getCuts(nums, mid);
      if (cuts > m) { // mid is too small
        left = mid + 1;
      } else if (cuts == m) {
        right = mid;
      } else {
        right = mid - 1;
      }
    }
    return (int) left;
  }

  private static long getCuts(final int[] nums, final long sum) {
    long count = 1, curSum = 0;
    for (int n : nums) {
      if (curSum + n > sum) {
        count++;
        curSum = n;
      } else {
        curSum += n;
      }
    }
    return count;
  }

}
