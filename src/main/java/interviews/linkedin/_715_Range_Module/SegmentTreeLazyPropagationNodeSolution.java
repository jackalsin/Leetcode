package interviews.linkedin._715_Range_Module;

/**
 * @author jacka
 * @version 1.0 on 7/27/2019
 */
public final class SegmentTreeLazyPropagationNodeSolution implements Solution {
  // 0 < left < right < 10^9 in all calls to addRange, queryRange, removeRange.
  private static final int MIN = 1, MAX = (int) (1E9 - 1);
  //  private static final int MIN = 1, MAX = (int) (31 - 1);
  private final Node root = new Node(MIN, MAX);

  public void addRange(int left, int right) {
    update(root, left, right - 1, true);
  }

  public boolean queryRange(int left, int right) {
    return queryRange(root, left, right - 1);
  }

  private static boolean queryRange(final Node root, final int left, final int right) {
    if (root == null || root.end < left || root.start > right) {
      return true;
    }

    if (left <= root.start && root.end <= right) {
      if (root.lazy != null) {
        return root.lazy;
      }
      return root.val;
    }
    // update the child
    final int mid = root.start + (root.end - root.start) / 2;
    if (root.left == null) root.left = new Node(root.start, mid);
    if (root.right == null) root.right = new Node(mid + 1, root.end);
    if (root.lazy != null) {
      update(root.left, root.start, root.end, root.lazy);
      update(root.right, root.start, root.end, root.lazy);
      root.lazy = null;
    }
    final boolean leftResult = queryRange(root.left, left, right),
        rightResult = queryRange(root.right, left, right);
    return leftResult && rightResult;
  }

  public void removeRange(int left, int right) {
    update(root, left, right - 1, false);
  }

  private static void update(final Node root, final int left, final int right, final boolean val) {
    if (root == null || root.start > right || root.end < left) {
      return;
    }
    if (left <= root.start && root.end <= right) {
      root.lazy = val;
      root.val = val;
      return;
    }
    int mid = root.start + (root.end - root.start) / 2;
    if (root.left == null) root.left = new Node(root.start, mid);
    if (root.right == null) root.right = new Node(mid + 1, root.end);

    if (root.lazy != null) {
      update(root.left, root.start, root.end, root.lazy);
      update(root.right, root.start, root.end, root.lazy);
      root.lazy = null;
    }

    update(root.left, left, right, val);
    update(root.right, left, right, val);
    root.val = root.left.val && root.right.val;
  }

  /**
   *
   */
  private static final class Node {
    /**
     * inclusive
     */
    private int start, end;

    /**
     * is all covered
     */
    private boolean val;
    private Boolean lazy;
    private Node left, right;

    private Node(int start, int end) {
      this.start = start;
      this.end = end;
    }

    @Override
    public String toString() {
      return "Node{" +
          "start=" + start +
          ", end=" + end +
          ", val=" + val +
          ", lazy=" + lazy +
          ", left=" + left +
          ", right=" + right +
          '}';
    }
  }
}
