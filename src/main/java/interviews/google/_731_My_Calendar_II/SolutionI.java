package interviews.google._731_My_Calendar_II;

/**
 * @author jacka
 * @version 1.0 on 4/2/2020
 */
public final class SolutionI implements Solution {
  private final SegmentTree root = new SegmentTree();

  public boolean book(int start, int end) {
    final int cur = root.query(start, end - 1);
    if (cur >= 2) {
      return false;
    }
    root.update(start, end - 1, 1);
    return true;
  }

  private static final class SegmentTree {
    private final Node root = new Node(0, Integer.MAX_VALUE);
//    private final Node root = new Node(0, 63);

    private int query(final int left, final int right) {
      return query(root, left, right);
    }

    private static int query(final Node root, final int start, final int end) {
      if (root == null || start > root.end || end < root.start) {
        return 0;
      }
      if (start <= root.start && root.end <= end) {
//        System.out.println("[" + start + ", " + end + "], " + root.start + ", " + root.end + " val = " + root.max);
        return root.max;
      }
      pushLazy(root);
      final int res = Math.max(query(root.left, start, end), query(root.right, start, end));
//      System.out.println("[" + start + ", " + end + "], " + root.start + ", " + root.end + " val = " + res);
      return res;
    }

    private static void pushLazy(Node root) {
      final int mid = (root.end - root.start) / 2 + root.start;
      if (root.left == null) {
        root.left = new Node(root.start, mid);
      }
      if (root.right == null) {
        root.right = new Node(mid + 1, root.end);
      }
      root.left.lazy += root.lazy;
      root.left.max += root.lazy;
      root.right.lazy += root.lazy;
      root.right.max += root.lazy;
      root.lazy = 0;
    }

    private void update(final int start, final int end, final int toAdd) {
      update(root, start, end, toAdd);
    }

    private static void update(final Node root, final int start, final int end, final int toAdd) {
      assert root != null;
      if (start > root.end || end < root.start) {
        return;
      }
      if (start <= root.start && root.end <= end) {
        root.max += toAdd;
        root.lazy += toAdd;
        return;
      }
      pushLazy(root);
      update(root.left, start, end, toAdd);
      update(root.right, start, end, toAdd);
      root.max = Math.max(root.left.max, root.right.max);
    }
  }

  private static final class Node {
    private final int start, end;
    private Node left = null, right = null;
    private int max = 0, lazy = 0;

    private Node(int left, int right) {
      this.start = left;
      this.end = right;
    }
  }
}
