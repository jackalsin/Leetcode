package example.segmentTree;

/**
 * Lazy Propagation is intended to update the a range of segment tree nodes.
 */
public final class SegmentTreeLazyPropagationTreeNode implements SegmentTree {
  private final int[] values;
  private final Node root;

  public SegmentTreeLazyPropagationTreeNode(final int[] array) {
    if (array == null) {
      throw new NullPointerException();
    }
    if (array.length == 0) {
      throw new IllegalArgumentException();
    }
    this.values = array;
    root = new Node(0, values.length - 1);
    for (int i = 0; i < array.length; i++) {
      update(root, i, array[i]);
    }
  }

  @Override
  public void update(int i, int val) {
    update(root, i, val - values[i]);
    values[i] = val;
  }

  private void update(Node root, int i, int diff) {
    if (root.start <= i && i <= root.end) {
      root.val += diff;
      if (root.start == root.end) return;
      final int mid = root.start + (root.end - root.start) / 2;
      if (root.left == null) {
        root.left = new Node(root.start, mid);
      }
      if (root.right == null) {
        root.right = new Node(mid + 1, root.end);
      }
      if (i <= mid) {
        update(root.left, i, diff);
      } else {
        update(root.right, i, diff);
      }
    }
  }

  @Override
  public int get(int rangeStart, int rangeEnd) {
    return get(root, rangeStart, rangeEnd);
  }

  private int get(final Node root, int rangeStart, int rangeEnd) {
    if (root.end < rangeStart || root.start > rangeEnd) {
      return 0;
    }

    if (rangeStart <= root.start && root.end <= rangeEnd) {
      return root.val;
    }

    return get(root.left, rangeStart, rangeEnd) + get(root.right, rangeStart, rangeEnd);
  }

  private static final class Node {
    private Node left, right;

    private int start, end, val, lazy;

    private Node(final int start, final int end) {
      this.start = start;
      this.end = end;
    }
  }
}
