package utils.treeNode;

import java.util.List;
import java.util.Objects;

public final class Node {
  public int val;
  public List<Node> children;

  public Node() {
  }

  public Node(int _val, List<Node> _children) {
    val = _val;
    children = _children;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Node node = (Node) o;
    return val == node.val &&
        Objects.equals(children, node.children);
  }

  @Override
  public int hashCode() {
    return Objects.hash(val, children);
  }

  @Override
  public String toString() {
    return "Node{" +
        "val=" + val +
        ", children=" + children +
        '}';
  }
}
