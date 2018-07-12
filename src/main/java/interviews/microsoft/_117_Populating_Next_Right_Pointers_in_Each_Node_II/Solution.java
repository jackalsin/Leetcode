package interviews.microsoft._117_Populating_Next_Right_Pointers_in_Each_Node_II;

import utils.TreeLinkNode;

public class Solution {
  public void connect(TreeLinkNode root) {
    if (root == null) {
      return;
    }

    TreeLinkNode nextLevelHead = null,
        nextLevelLastVisit = null, curNode = root;

    while (curNode != null) {

      while (curNode != null) {
        if (curNode.left != null) {

          if (nextLevelLastVisit == null) {
            nextLevelHead = curNode.left;
          } else {
            nextLevelLastVisit.next = curNode.left;
          }
          nextLevelLastVisit = curNode.left;
        }

        if (curNode.right != null) {
          if (nextLevelLastVisit == null) {
            nextLevelHead = curNode.right;
          } else {
            nextLevelLastVisit.next = curNode.right;
          }
          nextLevelLastVisit = curNode.right;
        }

        curNode = curNode.next;
      }

      // move to next level
      nextLevelLastVisit = null;
      curNode = nextLevelHead;
      nextLevelHead = null;
    }
  }
}
