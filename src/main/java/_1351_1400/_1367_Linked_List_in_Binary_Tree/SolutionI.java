package _1351_1400._1367_Linked_List_in_Binary_Tree;

import utils.ListNode;
import utils.TreeNode;

/**
 * @author jacka
 * @version 1.0 on 4/22/2020
 */
public final class SolutionI implements Solution {

  public boolean isSubPath(ListNode head, TreeNode root) {
    if (head == null) {
      return true;
    }
    if (root == null) {
      return false;
    }
    return isMatchStartFromHere(head, root) || isSubPath(head, root.left) || isSubPath(head, root.right);
  }

  private static boolean isMatchStartFromHere(final ListNode head, final TreeNode root) {
    if (head == null) {
      return true;
    }
    if (root == null) {
      return false;
    }
    return (root.val == head.val) && (
        isMatchStartFromHere(head.next, root.left) ||
            isMatchStartFromHere(head.next, root.right));
  }
}
