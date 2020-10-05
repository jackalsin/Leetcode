package _0201_0250._234_Palindrome_Linked_List;

import utils.ListNode;

public class Solution {
  public boolean isPalindrome(ListNode head) {
    if (head == null) return true;
    ListNode prevMid = head;
    ListNode fast = head;
    while (fast.next != null && fast.next.next != null) {
      prevMid = prevMid.next;
      fast = fast.next.next;
    }
    ListNode another = reverse(prevMid.next);
    ListNode anotherPointer = another;
    ListNode pointer = head;
    while (anotherPointer != null) {
      if (anotherPointer.val == pointer.val) {
        anotherPointer = anotherPointer.next;
        pointer = pointer.next;
      } else {
        prevMid.next = reverse(another);
        return false;
      }
    }

    return true;
  }

  private static ListNode reverse(ListNode head) {
    ListNode prev = null;
    ListNode cur = head;
    while (cur != null) {
      ListNode next = cur.next;
      cur.next = prev;
      prev = cur;
      cur = next;
    }
    return prev;
  }
}
