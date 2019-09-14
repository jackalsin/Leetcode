package interviews.linkedin._706_Design_HashMap;

/**
 * @author jacka
 * @version 1.0 on 9/14/2019
 */
public final class MyHashMapLinkedListI implements Solution {
  private static final int CAPACITY = 10;
  private final ListNode[] nodes = new ListNode[CAPACITY];

  public void put(int key, int value) {
    final int index = key % CAPACITY;
    if (nodes[index] == null) {
      nodes[index] = new ListNode(key, value);
      return;
    }
    ListNode cur = nodes[index], prev = nodes[index];
    while (cur != null) {
      if (cur.key == key) {
        cur.val = value;
        return;
      }
      prev = cur;
      cur = cur.next;
    }
    // add new
    prev.next = new ListNode(key, value);
  }

  public int get(int key) {
    final int index = key % CAPACITY;
    ListNode cur = nodes[index];
    while (cur != null) {
      if (cur.key == key) {
        return cur.val;
      }
      cur = cur.next;
    }
    return -1;
  }

  public void remove(int key) {
    final int index = key % CAPACITY;
    ListNode cur = nodes[index];
    if (cur == null) {
      return;
    }
    if (cur.key == key) {
      nodes[index] = cur.next;
    }
    ListNode prev = cur;
    cur = cur.next;
    while (cur != null) {
      if (cur.key == key) {
        prev.next = cur.next;
      }
      prev = prev.next;
      cur = cur.next;
    }
  }

  private static final class ListNode {
    ListNode next;
    private final int key;
    private int val;

    private ListNode(int key, int val) {
      this.key = key;
      this.val = val;
    }
  }
}
