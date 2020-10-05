package facebook._117_Populating_Next_Right_Pointers_in_Each_Node_II;

import utils.TreeLinkNode;

public class Solution {
  public void connect(TreeLinkNode root) {
    if (root == null) {
      return;
    }

    TreeLinkNode prev = null, curNode = root, nextLevelHead = null;

    while (curNode != null) {
      if (curNode.left != null) {
        // find the next level head
        if (nextLevelHead == null) {
          nextLevelHead = curNode.left;
        }
        if (prev == null) {
          prev = curNode.left;
        } else {
          prev.next = curNode.left;
          prev = prev.next;
        }
      }

      if (curNode.right != null) {
        // update next level head
        if (nextLevelHead == null) {
          nextLevelHead = curNode.right;
        }
        if (prev == null) {
          prev = curNode.right;
        } else {
          prev.next = curNode.right;
          prev = prev.next;
        }
      }

      curNode = curNode.next;
    }
    connect(nextLevelHead);
  }
}
