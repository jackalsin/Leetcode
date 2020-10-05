package microsoft.noodleEssence.wrongPointer;

import java.util.ArrayList;
import java.util.List;

public class Solution {
  public List<Integer> inorder(DoubleLinkedListNode head) {
    final List<Integer> result = new ArrayList<>();
    DoubleLinkedListNode dummy = new DoubleLinkedListNode(0);
    dummy.next = head;
    head.prev = dummy;
    DoubleLinkedListNode cur = head, prev = dummy;
    while (cur != null) {
//      DoubleLinkedListNode next = cur.next;

      if (prev.next.prev != prev) {
        // find the problem link
        if (cur.prev.next == cur) { // next is okay, cur的next pointer is wrong
          while (cur.prev != prev) {
            cur = cur.prev;
          }
          // cur points to the correct next point
          continue; // move to next loop
        } else {
          // next is valid, let's carry on
        }
      }

      result.add(cur.val);
      prev = cur;
      cur = cur.next;
    }

    return result;
  }
}
