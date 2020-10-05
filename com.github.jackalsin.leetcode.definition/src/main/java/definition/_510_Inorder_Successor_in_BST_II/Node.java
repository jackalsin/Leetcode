package definition._510_Inorder_Successor_in_BST_II;

import java.util.Objects;

/**
 * @author jacka
 * @version 1.0 on 12/25/2019
 */
public final class Node {
  public int val;
  public Node left;
  public Node right;
  public Node parent;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Node)) return false;
    Node node = (Node) o;
    return val == node.val &&
        Objects.equals(left, node.left) &&
        Objects.equals(right, node.right) &&
        parentValEquals(parent, node.parent);
  }

  private static boolean parentValEquals(final Node p1, final Node p2) {
    if (p1 == null && p2 == null) {
      return true;
    } else if (p1 == null || p2 == null) {
      return false;
    } else {
      return p1.val == p2.val;
    }
  }

  @Override
  public int hashCode() {
    return Objects.hash(val, left, right, parent);
  }

  @Override
  public String toString() {
    return "Node{" +
        "val=" + val +
        ", left=" + left +
        ", right=" + right +
        ", parent=" + getVal(parent) +
        '}';
  }

  private static String getVal(Node node) {
    return node == null ? "null" : String.valueOf(node.val);
  }
}
