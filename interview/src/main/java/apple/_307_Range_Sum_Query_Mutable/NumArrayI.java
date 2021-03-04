package apple._307_Range_Sum_Query_Mutable;

/**
 * @author jacka
 * @version 1.0 on 3/3/2021
 */
public final class NumArrayI implements NumArray {
  private final int[] nums;
  private final SegmentTreeNode root;

  public NumArrayI(int[] nums) {
    this.nums = nums;
    root = buildTree(0, nums.length - 1);
  }

  public void update(int index, int val) {
    final int diff = val - nums[index];
    update(root, index, diff);
    nums[index] = val;
  }

  private void update(final SegmentTreeNode root, final int index, final int diff) {
    if (root == null) {
      return;
    }
    root.sum += diff;
    if (root.start == root.end) {
      return;
    }
    final int mid = root.start + (root.end - root.start) / 2;
    if (index <= mid) {
      update(root.left, index, diff);
    } else {
      update(root.right, index, diff);
    }
  }

  public int sumRange(int left, int right) {
    return sumRange(root, left, right);
  }

  private int sumRange(final SegmentTreeNode root, final int left, final int right) {
    if (root == null || left > root.end || right < root.start) {
      return 0;
    }
    if (left <= root.start && root.end <= right) {
      return root.sum;
    }
    return sumRange(root.left, left, right) + sumRange(root.right, left, right);
  }

  private SegmentTreeNode buildTree(final int start, final int end) {
    if (start > end) {
      return null;
    }
    if (start == end) {
      return new SegmentTreeNode(null, null, nums[start], start, end);
    }
    final int mid = start + (end - start) / 2;
    final SegmentTreeNode left = buildTree(start, mid),
        right = buildTree(mid + 1, end);
    int sum = (left == null ? 0 : left.sum) + (right == null ? 0 : right.sum);
    return new SegmentTreeNode(left, right,
        sum, start, end);
  }

  private static final class SegmentTreeNode {
    private final SegmentTreeNode left, right;
    private int sum;
    private final int start, end;

    private SegmentTreeNode(final SegmentTreeNode left, final SegmentTreeNode right, final int sum,
                            final int start, int end) {
      this.left = left;
      this.right = right;
      this.sum = sum;
      this.start = start;
      this.end = end;
    }
  }
}
