package uber._146_LRU_Cache;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public final class LRUCache {
  private final int capacity;
  private final Node head = new Node(0), tail = new Node(0);

  {
    head.next = tail;
    tail.prev = head;
  }

  private final Map<Integer, Node> keyToNode = new HashMap<>();
  private final Map<Integer, Integer> keyToValue = new HashMap<>();

  public LRUCache(int capacity) {
    this.capacity = capacity;
  }

  public int get(int key) {
    if (!keyToValue.containsKey(key)) {
      return -1; // not found
    }

    final int res = keyToValue.get(key);
    final Node toRemove = keyToNode.get(key);
    removeFromDoubleLinkedList(toRemove);
    insertAfter(head, toRemove);
    return res;
  }

  private void insertAfter(final Node head, final Node toRemove) {
    final Node next = head.next;
    head.next = toRemove;
    toRemove.prev = head;

    toRemove.next = next;
    next.prev = toRemove;
  }

  private void removeFromDoubleLinkedList(final Node toRemove) {
    final Node prev = toRemove.prev, next = toRemove.next;
    prev.next = next;
    next.prev = prev;
  }

  public void put(int key, int value) {
    if (capacity == 0) {
      return;
    }
    if (keyToValue.containsKey(key)) {
      keyToValue.put(key, value);
      final Node toRemove = keyToNode.get(key);
      removeFromDoubleLinkedList(toRemove);
      insertAfter(head, toRemove);
    } else {
      if (keyToValue.size() == capacity) {
        final Node toRemove = tail.prev;
        keyToValue.remove(toRemove.key);
        keyToNode.remove(toRemove.key);
        removeFromDoubleLinkedList(toRemove);
      }

      final Node toInsert = new Node(key);
      keyToValue.put(key, value);
      keyToNode.put(key, toInsert);
      insertAfter(head, toInsert);
    }
  }

  private static final class Node {
    private final int key;
    private Node prev, next;

    private Node(int key) {
      this.key = key;
    }
  }
}
