package utils._510_Inorder_Successor_in_BST_II;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 12/25/2019
 */
public final class Nodes {
  private Nodes() {
    // private constructor
  }

  public static Node getByLevelOrder(final Integer... a) {
    if (a == null || a.length == 0) {
      return null;
    }
    validate(a);

    final Queue<Integer> vals = new LinkedList<>(Arrays.asList(a));
    final Node root = new Node();
    root.val = vals.remove();
    final Queue<Node> q = new LinkedList<>();
    q.add(root);
    while (!q.isEmpty()) {
      final int size = q.size();
      for (int i = 0; i < size; i++) {
        final Node parent = q.remove();
        final Integer leftVal = vals.isEmpty() ? null : vals.remove(),
            rightVal = vals.isEmpty() ? null : vals.remove();
//        System.out.println("parent = " + parent + ", leftVal = " + leftVal + ", rightVal = " + rightVal);
        if (leftVal != null) {
          final Node left = new Node();
          left.val = leftVal;
          left.parent = parent;
          parent.left = left;
          q.add(left);
        }
        if (rightVal != null) {
          final Node right = new Node();
          right.val = rightVal;
          right.parent = parent;
          parent.right = right;
          q.add(right);
        }
      }
    }
    while (!vals.isEmpty()) {
      if (vals.remove() != null) {
        throw new IllegalArgumentException("a = " + Arrays.toString(a) + "has pending non null val");
      }
    }
    return root;
  }

  private static void validate(Integer[] vals) {
    final Set<Integer> set = new HashSet<>();
    for (Integer val : vals) {
      if (val == null) continue;
      if (set.contains(val)) {
        throw new IllegalArgumentException("vals = " + Arrays.toString(vals) + " contains duplicate value + " + val);
      }
      set.add(val);
    }
  }

  public static void link(final Node parent, final Node left, final Node right) {
    parent.left = left;
    parent.right = right;
    if (left != null) left.parent = parent;
    if (right != null) right.parent = parent;
  }
}
