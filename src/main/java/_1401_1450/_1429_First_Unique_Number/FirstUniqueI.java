package _1401_1450._1429_First_Unique_Number;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 4/28/2020
 */
public final class FirstUniqueI implements FirstUnique {
  private final Node head = new Node(-1), tail = new Node(-1);
  private final Map<Integer, Node> keyToNode = new HashMap<>();

  {
    head.next = tail;
    tail.prev = head;
  }

  public FirstUniqueI(final int[] nums) {
    for (int n : nums) {
      add(n);
    }
  }

  public int showFirstUnique() {
    if (head.next == tail) {
      return -1;
    }
    return head.next.key;
  }

  public void add(int key) {
    if (!keyToNode.containsKey(key)) {
      final Node toInsert = new Node(key);
      keyToNode.put(key, toInsert);
      insertBefore(toInsert, tail);
    }
    final Node cur = keyToNode.get(key);
    cur.count++;
    if (cur.count == 2) {
      removeFromDoubleLinkedList(cur);
    }
  }

  private static void removeFromDoubleLinkedList(final Node cur) {
    final Node prev = cur.prev, next = cur.next;
    prev.next = next;
    next.prev = prev;
  }

  private void insertBefore(final Node toInsert, final Node tail) {
    final Node prev = tail.prev;
    prev.next = toInsert;
    toInsert.prev = prev;
    tail.prev = toInsert;
    toInsert.next = tail;
  }

  private static final class Node {
    private final int key;
    private Node prev, next;
    private int count = 0;

    private Node(int key) {
      this.key = key;
    }
  }
}
