package interviews.byteDance._146_LRU_Cache;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhixi
 * @version 1.0 on 5/7/2020
 */
public final class LRUCacheI implements LRUCache {
  private final int capacity;
  private final Map<Integer, Node> keyToNode = new HashMap<>();
  private final Map<Integer, Integer> keyToValue = new HashMap<>();
  private final Node head = new Node(0), tail = new Node(0);

  {
    head.next = tail;
    tail.prev = head;
  }

  public LRUCacheI(final int capacity) {
    this.capacity = capacity;
  }

  public int get(int key) {
    if (!keyToValue.containsKey(key)) {
      return -1;
    }
    final int res = keyToValue.get(key);
    final Node toRemove = keyToNode.get(key);
    removeFromDoubleLinkedList(toRemove);
    insertAfter(head, toRemove);
    return res;
  }

  private static void insertAfter(final Node prev, final Node toInsert) {
    final Node next = prev.next;
    prev.next = toInsert;
    toInsert.prev = prev;

    toInsert.next = next;
    next.prev = toInsert;
  }

  private static void removeFromDoubleLinkedList(final Node toRemove) {
    final Node prev = toRemove.prev, next = toRemove.next;
    prev.next = next;
    next.prev = prev;
  }

  public void put(int key, int value) {
    if (capacity == 0) {
      return;
    }
    if (keyToValue.containsKey(key)) {
      final Node toRemove = keyToNode.get(key);
      removeFromDoubleLinkedList(toRemove);
      insertAfter(head, toRemove);
    } else {
      if (keyToValue.size() == capacity) {
        final Node toRemove = tail.prev;
        removeFromDoubleLinkedList(toRemove);
        keyToValue.remove(toRemove.key);
        keyToNode.remove(toRemove.key);
      }
      final Node toInsert = new Node(key);
      insertAfter(head, toInsert);
      keyToNode.put(key, toInsert);
    }
    keyToValue.put(key, value);
  }

  private static final class Node {
    private Node prev, next;
    private final int key;

    private Node(int key) {
      this.key = key;
    }
  }
}
