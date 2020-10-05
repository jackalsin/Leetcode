package oracle._117_Populating_Next_Right_Pointers_in_Each_Node_II;

import definition.treeLinkNode._117_Populating_Next_Right_Pointers_in_Each_Node_II.Node;

/**
 * @author jacka
 * @version 1.0 on 11/24/2019
 */
public final class O1SpaceSolution implements Solution {
  @Override
  public Node connect(Node root) {
    Node curHead = root, nextLevelHead = null;
    while (curHead != null) {
      Node prev = null, cur = curHead;
      while (cur != null) {
        if (cur.left != null) {
          if (nextLevelHead == null) {
            nextLevelHead = cur.left;
          }
          if (prev == null) {
            prev = cur.left;
          } else {
            prev.next = cur.left;
            prev = prev.next;
          }
        }
        if (cur.right != null) {
          if (nextLevelHead == null) {
            nextLevelHead = cur.right;
          }
          if (prev == null) {
            prev = cur.right;
          } else {
            prev.next = cur.right;
            prev = prev.next;
          }
        }
        cur = cur.next;
      }
      curHead = nextLevelHead;
      nextLevelHead = null;
    }
    return root;
  }
}
