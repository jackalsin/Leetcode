package interviews.google._410_Split_Array_Largest_Sum;

/**
 * @author jacka
 * @version 1.0 on 3/22/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int splitArray(int[] nums, int m) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    final long[] sumMax = getSumMax(nums);
    final long sum = sumMax[0], max = sumMax[1];
//    System.out.println(sum);
    long left = max, right = sum;
    // find first can divide to m
    while (left < right) {
      final long mid = (right + left) / 2;
      final int count = getCount(nums, mid);
      if (count == m) {
        right = mid;
      } else if (count < m) {
        // mid is too big
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    return (int) left;
  }

  private static long[] getSumMax(final int[] nums) {
    long sum = 0, max = 0;
    for (int n : nums) {
      sum += n;
      max = Math.max(max, n);
    }
    return new long[]{sum, max};
  }

  private static int getCount(final int[] nums, final long mid) {
    int count = 1;
    for (int i = 0, curSum = 0; i < nums.length; ++i) {
      if (curSum + nums[i] > mid) {
        count++;
        curSum = nums[i];
      } else {
        curSum += nums[i];
      }
    }
    return count;
  }
}
