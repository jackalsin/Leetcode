package interviews.linkedin._706_Design_HashMap;

/**
 * @author jacka
 * @version 1.0 on 7/27/2019
 */
public final class MyHashMapI implements Solution {
  private static final int MAX_KEY = 10000;
  private final ListNode[] nodes = new ListNode[MAX_KEY];

  public void put(int key, int value) {
    final int index = getIndex(key);
    if (nodes[index] == null) {
      nodes[index] = new ListNode(0, 0);
    }
    update(nodes[index], key, value);
  }

  private void update(final ListNode head, final int key, final int value) {
    ListNode cur = head;
    while (cur.next != null) {
      if (cur.next.key == key) {
        cur.next.value = value;
        return;
      }
      cur = cur.next;
    }
    cur.next = new ListNode(key, value);
  }

  public int get(int key) {
    final int index = getIndex(key);
    final ListNode head = nodes[index];
    if (head == null) {
      return -1;
    }
    ListNode cur = head;
    while (cur.next != null) {
      if (cur.next.key == key) {
        return cur.next.value;
      }
      cur = cur.next;
    }
    return -1;
  }

  public void remove(int key) {
    final int index = getIndex(key);
    ListNode cur = nodes[index];
    if (cur == null) {
      return;
    }
    while (cur.next != null) {
      if (cur.next.key == key) {
        cur.next = cur.next.next;
        return;
      }
      cur = cur.next;
    }
  }

  private static int getIndex(final int key) {
    return key % MAX_KEY;
  }

  private static final class ListNode {
    private int key, value;
    private ListNode next;

    private ListNode(int key, int value) {
      this.key = key;
      this.value = value;
    }
  }
}
