package _301_350._327_Count_of_Range_Sum;

import java.util.Arrays;

/**
 * @author jacka
 * @version 1.0 on 9/27/2017.
 */
public final class SegmentTreeSolution implements Solution{
  @Override
  public int countRangeSum(int[] nums, int lower, int upper) {
    final long[] sums = new long[nums.length + 1];
    for (int i = 0; i < nums.length; ++i) {
      sums[i + 1] = sums[i] + nums[i];
    }
    Arrays.sort(sums);
    SegmentTreeNode root = buildSegmentTree(sums, 0, sums.length - 1);
    int count = 0;


    count += nums[0] >= lower && nums[0] <= upper ? 1 : 0;
    int sum = nums[0];
    for(int i = 1; i<nums.length; i++) {
      updateSegmentTree(root, sum);
      sum += nums[i];
      count += sum >= lower && sum <= upper ? 1 : 0;
      count += getCount(root, (long)sum-upper, (long)sum-lower);
    }
    return count;
  }

  private void updateSegmentTree(SegmentTreeNode root, int sum) {
    if (root != null && root.max >= sum && root.min <= sum) {
      root.count++;
      updateSegmentTree(root.left, sum);
      updateSegmentTree(root.right, sum);
    }
  }

  private SegmentTreeNode buildSegmentTree(long[] sum, int low, int high) {
    if (low > high) return null;
    SegmentTreeNode curNode = new SegmentTreeNode(sum[low], sum[high]);
    if (low == high) return curNode;
    int mid = (high - low) / 2 + low;
    curNode.left = buildSegmentTree(sum, low, mid);
    curNode.right = buildSegmentTree(sum, mid + 1, high);
    return curNode;
  }

  private int getCount(SegmentTreeNode root, long min, long max) {
    if (root == null || min > root.max || max < root.min) return 0;
    if (min <= root.min && root.max <= max) return root.count;
    return getCount(root.left, min, max) + getCount(root.right, min, max);
  }

  private static final class SegmentTreeNode {
    SegmentTreeNode left, right;
    final long min, max;
    int count = 0;
    SegmentTreeNode(long min, long max) {
      this.max = max;
      this.min = min;
    }
  }

}
