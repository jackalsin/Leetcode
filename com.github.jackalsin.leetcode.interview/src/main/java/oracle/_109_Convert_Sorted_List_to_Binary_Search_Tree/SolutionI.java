package oracle._109_Convert_Sorted_List_to_Binary_Search_Tree;

import utils.ListNode;
import utils.binaryTree.TreeNode;

/**
 * @author jacka
 * @version 1.0 on 10/20/2019
 */
public final class SolutionI implements Solution {
  private ListNode q;

  public TreeNode sortedListToBST(ListNode head) {
    final int size = getSize(head);
    q = head;
    return sortedListToBST(0, size - 1);
  }

  private TreeNode sortedListToBST(final int start, final int end) {
    if (start > end) {
      return null;
    }
    final int mid = start + (end - start) / 2;
    final TreeNode left = sortedListToBST(start, mid - 1);
    final TreeNode root = new TreeNode(q.val);
    q = q.next;
    final TreeNode right = sortedListToBST(mid + 1, end);
    root.left = left;
    root.right = right;
    return root;
  }

  private static int getSize(final ListNode head) {
    ListNode cur = head;
    int size = 0;
    while (cur != null) {
      size++;
      cur = cur.next;
    }
    return size;
  }
}
