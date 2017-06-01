package _051_100._061_Rotate_List;

import utils.ListNode;

/**
 * @author jacka
 * @version 1.0 on 4/23/2017.
 */
public class Solution {
  public ListNode rotateRight(ListNode head, int k) {
    ListNode tail = head;
    if(head == null) {
      return head;
    }
    int i = 0;
    while (i < k) {
      if (tail.next == null) {
        tail = head;
        k = k % (i + 1);
        i = 0;
      } else {
        tail = tail.next;
        i++;
      }
    }

    ListNode newTail = head;
    while (tail.next != null) {
      tail = tail.next;
      newTail = newTail.next;
    }
    tail.next = head;
    head = newTail.next;
    newTail.next  = null;
    return head;
  }

}
