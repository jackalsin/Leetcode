package utils._427_Construct_Quad_Tree;

import java.util.Objects;

public final class Node {
  public boolean val;
  public boolean isLeaf;
  public Node topLeft;
  public Node topRight;
  public Node bottomLeft;
  public Node bottomRight;

  public Node() {
  }

  public Node(boolean _val, boolean _isLeaf, Node _topLeft, Node _topRight, Node _bottomLeft, Node _bottomRight) {
    val = _val;
    isLeaf = _isLeaf;
    topLeft = _topLeft;
    topRight = _topRight;
    bottomLeft = _bottomLeft;
    bottomRight = _bottomRight;

  }

  @Override
  public String toString() {
    indent += 4;
    final String res = "\n" + getIndent() + "Node{" +
        "val=" + val +
        ", isLeaf=" + isLeaf +
        ", topLeft=" + topLeft +
        ", topRight=" + topRight +
        ", bottomLeft=" + bottomLeft +
        ", bottomRight=" + bottomRight +
        "}";
    indent -= 4;
    return res;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Node node = (Node) o;
    return val == node.val &&
        isLeaf == node.isLeaf &&
        Objects.equals(topLeft, node.topLeft) &&
        Objects.equals(topRight, node.topRight) &&
        Objects.equals(bottomLeft, node.bottomLeft) &&
        Objects.equals(bottomRight, node.bottomRight);
  }

  @Override
  public int hashCode() {
    return Objects.hash(val, isLeaf, topLeft, topRight, bottomLeft, bottomRight);
  }

  private static int indent = 0;

  private static String getIndent() {
    final StringBuilder sb = new StringBuilder();
    for (int i = 0; i < indent; i++) {
      sb.append(" ");
    }
    return sb.toString();
  }
}
