package _0701_0750._715_Range_Module;

public final class SegmentTreeSolution implements Solution {
  private final SegmentTree st = new SegmentTree();

  public void addRange(int left, int right) {
    st.updateRange(left, right - 1, true);
  }


  public boolean queryRange(int left, int right) {
    return st.queryRange(left, right - 1);
  }


  public void removeRange(int left, int right) {
    st.updateRange(left, right - 1, false);
  }

  private static final class SegmentTree {
    private static final int MAX = (int) 1E9, NULL = 0, TRUE = 1, FALSE = 2;
    private final Node root = new Node(0, MAX - 1);

    private boolean queryRange(final int qs, final int qe) {
      return queryRange(root, qs, qe);
    }

    private boolean queryRange(final Node root, final int qs, final int qe) {
      if (root == null) {
        return false;
      }
      if (root.lazy != NULL) {
        root.val = root.lazy == TRUE;
        if (root.start != root.end) {
          initChildren(root);
          root.left.lazy = root.lazy;
          root.right.lazy = root.lazy;
        }
        root.lazy = NULL;
      }

      if (qs > root.end || qe < root.start) {
        return true;
      }

      if (qs <= root.start && root.end <= qe) {
        return root.val;
      }

      final boolean left = queryRange(root.left, qs, qe),
          right = queryRange(root.right, qs, qe);
      return left && right;
    }

    void updateRange(final int start, final int end, final boolean val) {
      updateRange(root, start, end, val);
    }

    private void updateRange(final Node root, final int qs, final int qe, final boolean val) {
      if (root == null) {
        return;
      }
      if (root.lazy != NULL) {
        root.val = root.lazy == TRUE;
        if (root.start != root.end) {
          initChildren(root);
          root.left.lazy = root.lazy;
          root.right.lazy = root.lazy;
        }
        root.lazy = NULL;
      }

      if (qs > root.end || qe < root.start) {
        return;
      }
      if (qs <= root.start && root.end <= qe) {
        root.val = val;

        if (root.start != root.end) {
          initChildren(root);
          root.left.lazy = val ? TRUE : FALSE;
          root.right.lazy = val ? TRUE : FALSE;
        }
        return;
      }

      if (root.start != root.end) {
        initChildren(root);
        updateRange(root.left, qs, qe, val);
        updateRange(root.right, qs, qe, val);
        root.val = root.left.val && root.right.val;
      }
    }

    private static void initChildren(final Node root) {
      final int mid = (root.end - root.start) / 2 + root.start;
      if (root.left == null) {
        root.left = new Node(root.start, mid);
      }
      if (root.right == null) {
        root.right = new Node(mid + 1, root.end);
      }
    }


    private static final class Node {
      private boolean val = false;
      private Node left, right;
      private final int start, end;
      private int lazy;

      public Node(final int ss, final int se) {
        start = ss;
        end = se;
      }
    }
  }
}
