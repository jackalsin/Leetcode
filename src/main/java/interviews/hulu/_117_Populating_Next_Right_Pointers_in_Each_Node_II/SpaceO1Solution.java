package interviews.hulu._117_Populating_Next_Right_Pointers_in_Each_Node_II;

import utils.treeLinkNode._117_Populating_Next_Right_Pointers_in_Each_Node_II.Node;

/**
 * @author jacka
 * @version 1.0 on 2/11/2020
 */
public final class SpaceO1Solution implements Solution {
  @Override
  public Node connect(Node root) {
    if (root == null) return null;
    Node nextHead = null, head = root, prev = null;
    while (head != null) {
      while (head != null) {
        if (head.left != null) {
          if (prev != null) {
            prev.next = head.left;
          }
          prev = head.left;
          if (nextHead == null) {
            nextHead = head.left;
          }
        }
        if (head.right != null) {
          if (prev != null) {
            prev.next = head.right;
          }
          prev = head.right;
          if (nextHead == null) {
            nextHead = head.right;
          }
        }
        head = head.next;
      }

      head = nextHead;
      prev = null;
      nextHead = null;
    }
    return root;
  }
}
