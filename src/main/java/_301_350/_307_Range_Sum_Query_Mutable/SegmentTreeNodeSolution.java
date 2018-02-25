package _301_350._307_Range_Sum_Query_Mutable;

public final class SegmentTreeNodeSolution {
  private final int[] nums;
  private final SegmentTreeNode root;

  public SegmentTreeNodeSolution(int[] nums) {
    this.nums = nums;
    root = new SegmentTreeNode(0, nums.length - 1);
    for (int i = 0; i < nums.length; i++) {
      updateHelper(root, i, nums[i]);
    }
  }

  public void update(int i, int val) {
    updateHelper(root, i, val - nums[i]);
    nums[i] = val;
  }

  private void updateHelper(final SegmentTreeNode root, int i, int diff) {
    if (root == null || root.start > i || root.end < i) {
      return;
    }

    root.val += diff;
    if (root.start == root.end) return;
    final int mid = root.start + (root.end - root.start) / 2;
    if (root.start <= mid && root.left == null) {
      root.left = new SegmentTreeNode(root.start, mid);
    }
    if (root.end >= mid + 1 && root.right == null) {
      root.right = new SegmentTreeNode(mid + 1, root.end);
    }
    updateHelper(root.left, i, diff);
    updateHelper(root.right, i, diff);
  }

  /**
   * @param i start (inclusive)
   * @param j end (inclusive)
   * @return
   */
  public int sumRange(int i, int j) {
    return sumRange(root, i, j);
  }

  private int sumRange(SegmentTreeNode root, int i, int j) {
    if (i > j) {
      return 0;
    }
    if (i > root.end || j < root.start) {
      return 0;
    }
    if (i == root.start && j == root.end) {
      return root.val;
    } else {
      final int mid = root.start + (root.end - root.start) / 2;

      return sumRange(root.left, i, Math.min(mid, j)) + sumRange(root.right, Math.max(mid + 1, i), j);
    }
  }

  private static final class SegmentTreeNode {
    private final int start, end;
    private SegmentTreeNode left, right;
    private int val;

    private SegmentTreeNode(int start, int end, int val) {
      this.start = start;
      this.end = end;
      this.val = val;
    }

    private SegmentTreeNode(int start, int end) {
      this.start = start;
      this.end = end;
    }
  }
}
