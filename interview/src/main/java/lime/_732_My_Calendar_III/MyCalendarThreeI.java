package lime._732_My_Calendar_III;

/**
 * @author jacka
 * @version 1.0 on 4/13/2021
 */
public final class MyCalendarThreeI implements MyCalendarThree {
  private static final int MAX = (int) 1E9;
  private final Node root = new Node(0, MAX);

  public int book(int start, int end) {
    update(root, start, end - 1, 1);
    return root.max;
  }

  private void update(final Node root, final int qs, final int qe, final int diff) {
    if (qe < root.start || root.end < qs) {
      return;
    }
    if (qs <= root.start && root.end <= qe) {
      root.max += diff;
    }
    if (root.start == root.end) {
      return;
    }
    if (root.left == null) {
      final int mid = root.start + (root.end - root.start) / 2;
      root.left = new Node(root.start, mid);
      root.right = new Node(mid + 1, root.end);
    }
    update(root.left, qs, qe, diff);
    update(root.right, qs, qe, diff);
    root.max = Math.max(root.left.max, root.right.max);
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

