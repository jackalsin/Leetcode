package microsoft.noodleEssence._117_Populating_Next_Right_Pointers_in_Each_Node_II;

import utils.TreeLinkNode;

public class Solution {
  public void connect(TreeLinkNode root) {

    TreeLinkNode nextLevelHead = null, cur = root, prev = null;

    while (cur != null) {
      if (cur.left != null) {
        if (nextLevelHead == null) {
          nextLevelHead = cur.left;
        }
        if (prev != null) {
          prev.next = cur.left;
        }
        prev = cur.left;
      } // end of if left

      if (cur.right != null) {
        if (nextLevelHead == null) {
          nextLevelHead = cur.right;
        }
        if (prev != null) {
          prev.next = cur.right;
        }
        prev = cur.right;
      }

      cur = cur.next;
      if (cur == null) {
        cur = nextLevelHead;
        nextLevelHead = null;
        prev = null;
      }
    }
  }
}
