package _0801_0850._817_Linked_List_Components;

import definition.ListNode;

import java.util.HashSet;
import java.util.Set;

public final class OnePassSolution implements Solution {
  public int numComponents(ListNode head, int[] G) {
    final Set<Integer> setG = new HashSet<>();

    for (int i : G) {
      setG.add(i);
    }
    ListNode cur = head;
    int res = 0;
    while (cur != null) {
      if (setG.contains(cur.val) && (cur.next == null || !setG.contains(cur.next.val))) res++;
      cur = cur.next;
    }
    return res;
  }
}
