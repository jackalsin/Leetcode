package definition._558_Logical_OR_of_Two_Binary_Grids_Represented_as_Quad_Trees;

import java.util.Objects;

/**
 * @author jacka
 * @version 1.0 on 2/29/2020
 */
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
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Node)) return false;
    Node node = (Node) o;
    if (isLeaf != node.isLeaf) {
      return false;
    }
    if (isLeaf) {
      return val == node.val &&
          Objects.equals(topLeft, node.topLeft) &&
          Objects.equals(topRight, node.topRight) &&
          Objects.equals(bottomLeft, node.bottomLeft) &&
          Objects.equals(bottomRight, node.bottomRight);
    } else {
      return Objects.equals(topLeft, node.topLeft) &&
          Objects.equals(topRight, node.topRight) &&
          Objects.equals(bottomLeft, node.bottomLeft) &&
          Objects.equals(bottomRight, node.bottomRight);
    }
  }

  @Override
  public int hashCode() {
    return Objects.hash(val, isLeaf, topLeft, topRight, bottomLeft, bottomRight);
  }

  @Override
  public String toString() {
    return "Node{" +
        "val=" + val +
        ", isLeaf=" + isLeaf +
        ", topLeft=" + topLeft +
        ", topRight=" + topRight +
        ", bottomLeft=" + bottomLeft +
        ", bottomRight=" + bottomRight +
        '}';
  }
}
