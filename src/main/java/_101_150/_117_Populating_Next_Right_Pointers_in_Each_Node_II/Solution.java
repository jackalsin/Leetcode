package _101_150._117_Populating_Next_Right_Pointers_in_Each_Node_II;

import utils.TreeLinkNode;

/**
 * @author jacka
 * @version 1.0 on 6/25/2017.
 */
public class Solution {
  public void connect(TreeLinkNode root) {
    TreeLinkNode parentLevelHead = root;
    while (parentLevelHead != null) {
      TreeLinkNode parent = parentLevelHead;
      TreeLinkNode prev = new TreeLinkNode(1);
      while (parent != null) {
        if (parent.left != null) {
          prev.next = parent.left;
          prev = prev.next;
        }
        if (parent.right != null) {
          prev.next = parent.right;
          prev = prev.next;
        }
        parent = parent.next;
      }

      // find parent level head next for next level
      while (parentLevelHead != null) {
        if (parentLevelHead.left != null) {
          parentLevelHead = parentLevelHead.left;
          break;
        }
        if (parentLevelHead.right != null) {
          parentLevelHead = parentLevelHead.right;
          break;
        }
        parentLevelHead = parentLevelHead.next;
      }
    }
  }
}
