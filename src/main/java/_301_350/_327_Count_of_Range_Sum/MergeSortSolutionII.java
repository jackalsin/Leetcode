package _301_350._327_Count_of_Range_Sum;

/**
 * This solution is using divide conquer, run time 16 ms.
 *
 * @author Zhiwei.Xin
 * @version 1.0 on 9/26/2017.
 */
public final class MergeSortSolutionII implements Solution {
  @Override
  public int countRangeSum(int[] nums, int lower, int upper) {
    final long[] sum = new long[nums.length + 1];
    for (int i = 0; i < nums.length; i++) {
      sum[i + 1] = sum[i] + nums[i];
    }
//    System.out.println(Arrays.toString(sum));
    return countRangeSum(sum, lower, upper, 0, nums.length);
  }

  private int countRangeSum(final long[] sum, final int lower, final int upper, int start, int end) {
    if (start >= end) {
      return 0;
    } else if (start == end) {
      return (sum[start] >= lower && sum[start] <= upper) ? 1 : 0;
    }
    final long[] aux = new long[end - start + 1];
    final int mid = start + (end - start) / 2;
    int count = countRangeSum(sum, lower, upper, start, mid) +
        countRangeSum(sum, lower, upper, mid + 1, end),
        left = start, rStart = mid + 1, rEnd = mid + 1, p = 0,
        right = mid + 1;
    while (left <= mid) {
      while (rStart <= end && sum[rStart] - sum[left] < lower) {
        rStart++;
      }

      while (rEnd <= end && sum[rEnd] - sum[left] <= upper) {
        rEnd++;
      }

      while (right <= end && sum[right] < sum[left]) {
        aux[p++] = sum[right++];
      }
      aux[p++] = sum[left];
      count += (rEnd - rStart);
      ++left;
    }
    while (right <= end) {
      aux[p++] = sum[right++];
    }
    System.arraycopy(aux, 0, sum, start, end - start + 1);
    return count;
  }
}
