package _0701_0750._731_My_Calendar_II;

public final class SegmentTreeSolutionI implements Solution {
  private static final int MAX = (int) (1E9);
  //  private static final int MAX = (int) (59);
  private final SegmentTreeNode root = new SegmentTreeNode(0, MAX);

  public boolean book(int start, int end) {
    final int q = queryRange(root, start, end - 1);
//    System.out.println("start = " + start + ", end = " + end + " q = " + q);
    if (q < 2) {
      updateRange(root, start, end - 1);
      return true;
    }
    return false;
  }

  int queryRange(final SegmentTreeNode root, final int qs, final int qe) {
    if (root == null) {
      return 0;
    }
    if (root.lazy != 0) {
      root.count += root.lazy;
      if (root.start != root.end) {
        initChildren(root);
        root.left.lazy += root.lazy;
        root.right.lazy += root.lazy;
      }
      root.lazy = 0;
    }

    if (qs > root.end || qe < root.start) {
      return 0;
    }

    if (qs <= root.start && root.end <= qe) {
      return root.count;
    }
    final int left = queryRange(root.left, qs, qe),
        right = queryRange(root.right, qs, qe);
//    root.count = Math.max(left, right);
//    return root.count;
    return Math.max(left, right);
  }

  private void initChildren(SegmentTreeNode root) {
    if (root.start == root.end || root.left != null || root.right != null) {
      return;
    }
    final int mid = root.start + (root.end - root.start) / 2;
    root.left = new SegmentTreeNode(root.start, mid);
    root.right = new SegmentTreeNode(mid + 1, root.end);
  }

  void updateRange(final SegmentTreeNode root, final int qs, final int qe) {
    assert root != null;
    if (root.lazy != 0) {
      root.count += root.lazy;
      if (root.left != root.right) {
        initChildren(root);
        root.left.lazy += root.lazy;
        root.right.lazy += root.lazy;
      }
      root.lazy = 0;
    }

    if (qe < root.start || root.end < qs) {
      return;
    }
    if (qs <= root.start && root.end <= qe) {
      root.count++;
      if (root.start != root.end) {
        initChildren(root);
        root.left.lazy++;
        root.right.lazy++;
      }
      return;
    }

    if (root.start != root.end) {
      initChildren(root);
      updateRange(root.left, qs, qe);
      updateRange(root.right, qs, qe);
      root.count = Math.max(root.left.count, root.right.count);
    }
  }

  private static final class SegmentTreeNode {
    private final int start, end;

    private SegmentTreeNode left, right;

    private int count; // maxCount
    private int lazy;

    private SegmentTreeNode(int start, int end) {
      this.start = start;
      this.end = end;
    }

    @Override
    public String toString() {
      return "SegmentTreeNode{" +
          "start=" + start +
          ", end=" + end +
          ", count=" + count +
          ", lazy=" + lazy +
          '}';
    }
  }

}
