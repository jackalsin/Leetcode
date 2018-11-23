package _0151_0200._164_Maximum_Gap;

import java.util.Arrays;

/**
 * @author jacka
 * @version 1.0 on 7/25/2017.
 */
public final class BucketSortSolution implements Solution {
  @Override
  public int maximumGap(int[] nums) {
    if (nums == null || nums.length < 2) {
      return 0; // less than 2, returns 0
    }
    int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
    for (int num : nums) {
      min = Math.min(min, num);
      max = Math.max(max, num);
    }
    final int bucketSize = nums.length - 1;
    final int gap = (int) Math.ceil((double) (max - min) / (nums.length - 1));
    final int[] bucketMin = new int[bucketSize], bucketMax = new int[bucketSize];
    Arrays.fill(bucketMin, Integer.MAX_VALUE);
    Arrays.fill(bucketMax, Integer.MIN_VALUE);

    // every num wil fall in [min + (k - 1) * gap, min + k * gap)
    for (int num : nums) {
      if (num == min || max == num) {
        // max belongs to the [max, max + gap)
        // min belongs to the min，虽然对结果无影响，但是previous与本身进行了运算
        continue;
      }
      final int bucketIndex = (num - min) / gap;
      bucketMin[bucketIndex] = Math.min(bucketMin[bucketIndex], num);
      bucketMax[bucketIndex] = Math.max(bucketMax[bucketIndex], num);
    }

    int maxGap = 0, prev = min;
    for (int i = 0; i < bucketSize; ++i) {
      if (bucketMin[i] == Integer.MAX_VALUE && bucketMax[i] == Integer.MIN_VALUE) {
        continue;
      }
      maxGap = Math.max(maxGap, bucketMin[i] - prev);
      prev = bucketMax[i];
    }
    maxGap = Math.max(maxGap, max - prev);
    return maxGap;
  }
}
