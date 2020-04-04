package interviews.google._731_My_Calendar_II;

/**
 * @author jacka
 * @version 1.0 on 4/2/2020
 */
public final class SolutionI implements Solution {
    private final Node root = new Node(0, Integer.MAX_VALUE);
//  private final Node root = new Node(0, 63);

  public boolean book(int start, int end) {
//    System.out.println("Qrying [" + start + ", " + end + "]");
    final int cur = query(root, start, end - 1);
    if (cur >= 2) {
      return false;
    }
//    System.out.println("Updating [" + start + ", " + end + "]");
    update(root, start, end - 1, 1);
    return true;
  }

  private int query(final Node root, final int qs, final int qe) {
//    System.out.println(root + ", qs = " + qs + ", qe = " + qe);
    if (root == null || qe < root.start || qs > root.end) {
      return 0;
    }
    if (root.lazy > 0) {
      initChildren(root);
      root.max += root.lazy;
      if (root.start != root.end) {
        root.left.lazy += root.lazy;
        root.right.lazy += root.lazy;
      }
      root.lazy = 0;
    }
    if (qs <= root.start && root.end <= qe) {
      return root.max;
    }
    final int max = Math.max(query(root.left, qs, qe), query(root.right, qs, qe));
//    System.out.println(root + ", qs = " + qs + ", qe = " + qe);
    return max;
  }

  private static void initChildren(final Node root) {
    if (root.start == root.end) return;
    final int mid = root.start + (root.end - root.start) / 2;
    if (root.left == null) {
      root.left = new Node(root.start, mid);
    }
    if (root.right == null) {
      root.right = new Node(mid + 1, root.end);
    }
  }

  private void update(final Node root, final int qs, final int qe, final int toAdd) {
    assert root != null;
//    System.out.println(root + ", qs = " + qs + ", qe = " + qe + ", toAdd = " + toAdd);
    if (qs > root.end || qe < root.start) {
      return;
    }
    if (root.lazy > 0) {
      initChildren(root);
      root.max += root.lazy;
      if (root.start != root.end) {
        root.left.lazy += root.lazy;
        root.right.lazy += root.lazy;
      }
      root.lazy = 0;
    }
    if (qs <= root.start && root.end <= qe) {
      root.lazy += toAdd;
      return;
    }
    if (root.start != root.end) {
      initChildren(root);
      update(root.left, qs, qe, toAdd);
      update(root.right, qs, qe, toAdd);
      root.max = Math.max(root.left.max + root.left.lazy, root.right.lazy + root.right.max);
    }
//    System.out.println(root + ", qs = " + qs + ", qe = " + qe + ", toAdd = " + toAdd);
  }

  private static final class Node {
    private final int start, end;
    private Node left = null, right = null;
    private int max = 0, lazy = 0;

    private Node(int left, int right) {
      this.start = left;
      this.end = right;
    }

    @Override
    public String toString() {
      return "Node{" +
          "start=" + start +
          ", end=" + end +
          ", max=" + max +
          ", lazy=" + lazy +
          '}';
    }
  }
}
