package _301_350._327_Count_of_Range_Sum;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Segment Tree solution.
 * @author jacka
 * @version 1.0 on 9/27/2017.
 */
public final class SegmentTreeSolution implements Solution {
  @Override
  public int countRangeSum(int[] nums, int lower, int upper) {
    long curSum = 0;
    Set<Long> sumSet = new HashSet<>();
    sumSet.add(curSum);

    for (int i = 0; i < nums.length; ++i) {
      curSum += nums[i];
      sumSet.add(curSum);
    }
    final Long[] uniqueSums = sumSet.toArray(new Long[0]);

    Arrays.sort(uniqueSums);
    SegmentTreeNode root = buildSegmentTree(uniqueSums, 0, uniqueSums.length - 1);
    int count = 0;

    // 0th element in sums, itself should not be in the count

//    count += (sums[1] >= lower && sums[1] <= upper) ? 1 : 0;
//    for (int i = 2; i < sums.length; ++i) {
//      long prevSum = sums[i - 1];
//      updateSegmentTree(root, prevSum);
//      count += sums[i] >= lower && sums[i] <= upper ? 1 : 0;
//      count += getCount(root, (sums[i] - upper), (sums[i] - lower));
//    }

//    // common mistake 1:
//    // the 0th element in sums, itself should not be treated as valid count, since it stands for
//    // the sum that ranges from i(inclusive) to i(exclusive), where i belongs to [0, sums.length)
//    for (int i = 1; i < sums.length; ++i) {
//      updateSegmentTree(root, sums[i - 1]);
//      count += getCount(root, sums[i] - upper, sums[i] - lower);
//    }

    // common mistake 2:
    // to avoid the problem above, deduct from the count first
//    count -= (sums[1] >= lower && sums[1] <= upper) ? 1 : 0;
//    for (int i = 1; i < sums.length; ++i) {
//      updateSegmentTree(root, sums[i - 1]);
//      count += getCount(root, sums[i] - upper, sums[i] - lower);
//    }

    curSum = 0;
    for (int i = 0; i < nums.length; ++i) {
      updateSegmentTree(root, curSum);
      curSum += nums[i];
      count += getCount(root, curSum - upper, curSum - lower);
    }

    return count;
  }

  private void updateSegmentTree(SegmentTreeNode root, long sum) {
    if (root != null && root.max >= sum && root.min <= sum) {
      root.count++;
      updateSegmentTree(root.left, sum);
      updateSegmentTree(root.right, sum);
    }
  }

  private SegmentTreeNode buildSegmentTree(Long[] sum, int low, int high) {
    if (low > high) {
      return null;
    }
    SegmentTreeNode curNode = new SegmentTreeNode(sum[low], sum[high]);
    if (low == high) {
      return curNode;
    }
    int mid = (high - low) / 2 + low;
    curNode.left = buildSegmentTree(sum, low, mid);
    curNode.right = buildSegmentTree(sum, mid + 1, high);
    return curNode;
  }

  private int getCount(SegmentTreeNode root, long min, long max) {
    if (root == null || min > root.max || max < root.min) {
      return 0;
    }
    if (min <= root.min && root.max <= max) {
      return root.count;
    }
    return getCount(root.left, min, max) + getCount(root.right, min, max);
  }

  private static final class SegmentTreeNode {
    SegmentTreeNode left, right;
    final long min, max;
    /**
     * The count of prevSum belong to [min, max].
     */
    int count = 0;

    SegmentTreeNode(long min, long max) {
      this.max = max;
      this.min = min;
    }

    @Override
    public String toString() {
      return "SegmentTreeNode{" +
//          "left=" + left +
//          ", right=" + right +
          ", min=" + min +
          ", max=" + max +
          ", count=" + count +
          '}';
    }
  }

}
