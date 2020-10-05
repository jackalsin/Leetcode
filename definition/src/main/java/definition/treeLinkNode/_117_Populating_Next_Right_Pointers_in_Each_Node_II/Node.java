package definition.treeLinkNode._117_Populating_Next_Right_Pointers_in_Each_Node_II;

import java.util.Objects;

/**
 * @author jacka
 * @version 1.0 on 10/20/2019
 */
public final class Node {
  public int val;
  public Node left;
  public Node right;
  public Node next;

  public Node() {
  }

  @Deprecated
  public Node(int val) {
    this.val = val;
  }

  public Node(int _val, Node _left, Node _right, Node _next) {
    val = _val;
    left = _left;
    right = _right;
    next = _next;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Node)) return false;
    Node node = (Node) o;
    return val == node.val &&
        Objects.equals(left, node.left) &&
        Objects.equals(right, node.right) &&
        Objects.equals(next, node.next);
  }

  @Override
  public int hashCode() {
    return Objects.hash(val, left, right, next);
  }

//  @Override
//  public String toString() {
//    return "Node{" +
//        "val=" + val +
//        ", left=" + getValueOrNull(left) +
//        ", right=" + getValueOrNull(right) +
//        ", next=" + getValueOrNull(next) +
//        '}';
//  }

  @Override
  public String toString() {
    return "Node{" +
        "val=" + val +
        ", left=" + left +
        ", right=" + right +
        ", next=" + next +
        '}';
  }

  private static String getValueOrNull(Node node) {
    return node == null ? "null" : String.valueOf(node.val);
  }
}
