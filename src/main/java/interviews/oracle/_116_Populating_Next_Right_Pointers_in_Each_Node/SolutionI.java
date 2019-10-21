package interviews.oracle._116_Populating_Next_Right_Pointers_in_Each_Node;

import utils.treeLinkNode._116_Populating_Next_Right_Pointers_in_Each_Node.Node;

/**
 * @author jacka
 * @version 1.0 on 10/20/2019
 */
public final class SolutionI implements Solution {
  @Override
  public Node connect(Node root) {
    if (root == null) {
      return null;
    }
    Node cur = root;
    while (true) {
      Node nextHead = null, prev = null;
      while (cur != null) {
        if (cur.left != null) {
          if (nextHead == null) {
            nextHead = cur.left;
          }
          if (prev != null) {
            prev.next = cur.left;
          }
          prev = cur.left;
        }
        if (cur.right != null) {
          if (nextHead == null) {
            nextHead = cur.right;
          }
          if (prev != null) {
            prev.next = cur.right;
          }
          prev = cur.right;
        }
        cur = cur.next;
      } // end of while
      if (nextHead == null) break;
      cur = nextHead;
    }
    return root;
  }
}
