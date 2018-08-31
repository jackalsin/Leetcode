package interviews.linkedin.mianjing._061_Rotate_List;

import utils.ListNode;

/**
 * TODO: revisit
 */
public class Solution {

  public ListNode rotateRight(ListNode head, int k) {
    if (head == null) {
      return null;
    }
    int len = 0;
    ListNode cur = head;
    while (cur != null) {
      cur = cur.next;
      len++;
    }
    if (k == 0) {
      return head;
    }
    k %= len;
    ListNode slow = head, fast = head;
    for (int i = 0; i < k; i++) {
      fast = fast.next;
    }
    while (fast.next != null) {
      fast = fast.next;
      slow = slow.next;
    }
    fast.next = head;
    head = slow.next;
    slow.next = null;
    return head;
  }

}
