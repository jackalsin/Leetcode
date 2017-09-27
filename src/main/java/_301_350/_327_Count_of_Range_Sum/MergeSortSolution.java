package _301_350._327_Count_of_Range_Sum;

/**
 * This solution is using divide conquer, run time 16 ms.
 *
 * @author Zhiwei.Xin
 * @version 1.0 on 9/26/2017.
 */
public class MergeSortSolution implements Solution {
  @Override
  public int countRangeSum(int[] nums, int lower, int upper) {
    /* sum[i] stands for sum[0 ... i - 1] */
    final long[] sum = new long[nums.length + 1];
    for (int i = 0; i < nums.length; ++i) {
      sum[i + 1] = sum[i] + nums[i];
    }
    return countRangeSumMergeSort(sum, lower, upper, 0, nums.length);
  }

  private int countRangeSumMergeSort(final long[] sum, final int lower,
                                     final int upper, final int start, final int end) {
    if (start == end) return 0;
    final long[] aux = new long[end - start + 1];
    int mid = (end - start) / 2 + start;
    int count = countRangeSumMergeSort(sum, lower, upper, start, mid) +
        countRangeSumMergeSort(sum, lower, upper, mid + 1, end);
    /* rEnd is exclusive */
    int l = start, rStart = mid + 1, rEnd = mid + 1, k = 0, rCopyIdx = mid + 1;
    for (; l <= mid; ++l) {
      while (rStart <= end && sum[rStart] - sum[l] < lower) rStart++;
      while (rEnd <= end && sum[rEnd] - sum[l] <= upper) rEnd++;
      while (rCopyIdx <= end && sum[rCopyIdx] < sum[l]) aux[k++] = sum[rCopyIdx++];
      aux[k++] = sum[l];
      count += rEnd - rStart;
    }
    System.arraycopy(aux, 0, sum, start, rCopyIdx - start);
    return count;
  }
}
