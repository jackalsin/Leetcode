package _0701_0750._725_Split_Linked_List_in_Parts;

import definition.ListNode;

public class Solution {
  public ListNode[] splitListToParts(ListNode root, int k) {
    assert 1 <= k && k <= 50;
    final int len = getLen(root), smallLen = len / k, bigLen = smallLen + 1, bigCount = len % k, smallCount =
        k - bigCount;
    final ListNode[] res = new ListNode[k];
    ListNode cur = root, prev = null;
    for (int i = 0; i < bigCount; i++) {
      res[i] = cur;
      for (int j = 0; j < bigLen; j++) {
        if (cur == null) break; //label
        prev = cur;
        cur = cur.next;
      }
      if (prev != null) {
        prev.next = null;
      }
    }

    for (int i = bigCount; i < k; i++) {
      res[i] = cur;
      for (int j = 0; j < smallLen; j++) {
        if (cur == null) break;
        prev = cur;
        cur = cur.next;
      }
      if (prev != null) {
        prev.next = null;
      }
    }
    return res;
  }

  private int getLen(final ListNode root) {
    ListNode curNode = root;
    int len = 0;
    while (curNode != null) {
      len++;
      curNode = curNode.next;
    }
    return len;
  }
}
