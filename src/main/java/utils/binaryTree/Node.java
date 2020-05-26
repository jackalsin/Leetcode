package utils.binaryTree;

import java.util.Objects;

/**
 * @author jacka
 * @version 1.0 on 5/24/2020
 */
public final class Node {
  public int val;
  public Node left;
  public Node right;

  public Node() {
  }

  public Node(int _val) {
    val = _val;
  }

  public Node(int _val, Node _left, Node _right) {
    val = _val;
    left = _left;
    right = _right;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Node)) return false;
    Node node = (Node) o;
    return val == node.val &&
        Objects.equals(left, node.left) &&
        Objects.equals(right, node.right);
  }

  @Override
  public int hashCode() {
    return Objects.hash(val, left, right);
  }

  @Override
  public String toString() {
    return "Node{" +
        "val=" + val +
        ", left=" + left +
        ", right=" + right +
        '}';
  }
}
