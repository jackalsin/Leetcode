package _0101_0150._109_Convert_Sorted_List_to_Binary_Search_Tree;

import definition.ListNode;
import definition.binaryTree.TreeNode;

/**
 * @author jacka
 * @version 1.0 on 6/7/2017.
 */
public class Solution {

  public TreeNode sortedListToBST(ListNode head) {
    return sortedListToBST(head, null);
  }

  /**
   *
   * @param head inclusive
   * @param tail exclusive
   * @return
   */
  private TreeNode sortedListToBST(ListNode head, ListNode tail) {
    if (head == null || head == tail) return null; // 变体：head.next == null -> return head
    ListNode fast = head;
    ListNode slow = head;
    while (fast != tail && fast.next != tail) {
      slow = slow.next;
      fast = fast.next.next;
    }
    TreeNode root = new TreeNode(slow.val);
    root.left = sortedListToBST(head, slow);
    root.right = sortedListToBST(slow.next, tail);
    return root;
  }
}
