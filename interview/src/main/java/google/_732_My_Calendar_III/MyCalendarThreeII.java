package google._732_My_Calendar_III;

/**
 * @author jacka
 * @version 1.0 on 4/26/2021
 */
public final class MyCalendarThreeII implements MyCalendarThree {
  private static final int MAX = 10_0000_0000;
  private final Node root = new Node(0, MAX);

  public int book(int start, int end) {
    update(root, start, end - 1);
    return root.max;
  }

  private void update(final Node root, final int qs, final int qe) {
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
    } // end of root.start != root.end
    root.lazy = 0;
    if (qs > root.end || qe < root.start || (qs <= root.start && root.end <= qe)) {
      return;
    }
    update(root.left, qs, qe);
    update(root.right, qs, qe);
    root.max = Math.max(root.left.max, root.right.max);
  }

  private static final class Node {
    private final int start, end;
    private Node left, right;
    private int lazy, max;

    private Node(int start, int end) {
      this.start = start;
      this.end = end;
    }
  }
}
