package google._732_My_Calendar_III;

/**
 * @author jacka
 * @version 1.0 on 5/9/2021
 */
public final class MyCalendarThreeIII implements MyCalendarThree {
  private final Node root = new Node(0, Integer.MAX_VALUE);

  public int book(int start, int end) {
    return update(root, start, end - 1);
  }

  private int update(final Node root, final int qs, final int qe) {
    if (qs <= root.start && root.end <= qe) {
      root.lazy++;
    }
    root.max += root.lazy;
    if (root.start != root.end) {
      if (root.left == null) {
        assert root.right == null;
        final int mid = root.start + (root.end - root.start) / 2;
        root.left = new Node(root.start, mid);
        root.right = new Node(mid + 1, root.end);
      }
      root.left.lazy += root.lazy;
      root.right.lazy += root.lazy;
    }
    root.lazy = 0;
    if (root.end < qs || root.start > qe || (qs <= root.start && root.end <= qe)) return root.max;
    update(root.left, qs, qe);
    update(root.right, qs, qe);
    root.max = Math.max(root.left.max, root.right.max);
    return root.max;
  }

  private static final class Node {
    private final int start, end;
    private Node left, right;
    private int max = 0, lazy = 0;

    private Node(int start, int end) {
      this.start = start;
      this.end = end;
    }
  }
}
