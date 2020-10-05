package _0101_0150._141_Linked_List_Cycle;

import definition.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 7/1/2017.
 */
public class Solution {
  public boolean hasCycle(ListNode head) {
    return o1Space(head);
  }

  private boolean o1Space(ListNode head) {
    ListNode curNode = head;
    ListNode latter = head;
    while (latter != null && latter.next != null) {
      curNode = curNode.next;
      latter = latter.next.next;
      if (curNode == latter) return true;
    }
    return false;
  }

  private boolean ONSpace(ListNode head) {
    Set<ListNode> hasVisited = new HashSet<>();
    ListNode cur = head;
    while (cur != null) {
      if (hasVisited.contains(cur)) return false;
      hasVisited.add(cur);
      cur = cur.next;
    }
    return true;
  }
}
