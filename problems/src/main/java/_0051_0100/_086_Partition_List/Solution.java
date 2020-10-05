package _0051_0100._086_Partition_List;

import definition.ListNode;

/**
 * @author jacka
 * @version 1.0 on 5/23/2017.
 */
public class Solution {

  public ListNode partition(ListNode head, int x) {
    ListNode lessDummy = new ListNode(0);
    ListNode greatOrEqualDummy = new ListNode(0);
    ListNode lessCur = lessDummy;
    ListNode greatOrEqualCur = greatOrEqualDummy;
    ListNode curNode = head;
    while (curNode != null) {
      if (curNode.val < x) {
        lessCur.next = curNode;
        curNode = curNode.next;
        lessCur = lessCur.next;
        lessCur.next = null;
      } else {
        greatOrEqualCur.next = curNode;
        curNode = curNode.next;
        greatOrEqualCur = greatOrEqualCur.next;
        greatOrEqualCur.next = null;
      }
    }
    lessCur.next = greatOrEqualDummy.next;
    return lessDummy.next;
  }
}
