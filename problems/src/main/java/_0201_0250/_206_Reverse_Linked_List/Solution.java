package _0201_0250._206_Reverse_Linked_List;

import definition.ListNode;

public class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        } else {
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
}
