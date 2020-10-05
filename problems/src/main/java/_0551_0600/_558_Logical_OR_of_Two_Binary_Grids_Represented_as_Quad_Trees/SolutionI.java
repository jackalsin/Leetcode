package _0551_0600._558_Logical_OR_of_Two_Binary_Grids_Represented_as_Quad_Trees;

import definition._558_Logical_OR_of_Two_Binary_Grids_Represented_as_Quad_Trees.Node;

/**
 * @author jacka
 * @version 1.0 on 2/29/2020
 */
public final class SolutionI implements Solution {
  @Override
  public Node intersect(Node q1, Node q2) {
    if (q1.isLeaf) {
      return q1.val ? q1 : q2;
    }
    if (q2.isLeaf) {
      return q2.val ? q2 : q1;
    }
    final Node topLeft = intersect(q1.topLeft, q2.topLeft),
        topRight = intersect(q1.topRight, q2.topRight),
        bottomLeft = intersect(q1.bottomLeft, q2.bottomLeft),
        bottomRight = intersect(q1.bottomRight, q2.bottomRight);
    assert (topLeft != null && topRight != null && bottomLeft != null && bottomRight != null);
    final Node result = new Node();
    if (topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf
        && topLeft.val == topRight.val && topRight.val == bottomLeft.val && bottomLeft.val == bottomRight.val) {
      result.isLeaf = true;
      result.val = topLeft.val;
    } else {
      result.isLeaf = false;
      result.val = q1.val || q2.val;
      result.topLeft = topLeft;
      result.topRight = topRight;
      result.bottomLeft = bottomLeft;
      result.bottomRight = bottomRight;
    }
    return result;
  }
}
