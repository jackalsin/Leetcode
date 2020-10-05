package explore.LRUCache;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 4/24/2020
 */
public final class LRUCache {
  private final int capacity;
  private final Map<Integer, Node> keyToNode = new HashMap<>();
  private final Map<Integer, Integer> keyToValue = new HashMap<>();
  private final Node head = new Node(-1),
      tail = new Node(-1);

  /*head -> Most recently, tail oldest */ {
    head.next = tail;
    tail.prev = head;
  }

  public LRUCache(int capacity) {
    this.capacity = capacity;
  }

  public int get(int key) {
    if (!keyToValue.containsKey(key)) {
      return -1;
    }
    final int res = keyToValue.get(key);
    final Node toRemove = keyToNode.get(key);
    removeFromDoubleLinkedList(toRemove);
    append(head, toRemove);
    return res;
  }

  private static void append(final Node head, final Node toRemove) {
    final Node next = head.next;
    head.next = toRemove;
    toRemove.prev = head;
    toRemove.next = next;
    next.prev = toRemove;
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
    if (!keyToValue.containsKey(key)) {
      if (keyToValue.size() == capacity) {
        // need remove the oldest
        final Node toRemove = tail.prev;
        removeFromDoubleLinkedList(toRemove);
        keyToValue.remove(toRemove.key);
        keyToNode.remove(toRemove.key);
      }

      final Node toInsert = new Node(key);
      append(head, toInsert);
      keyToNode.put(key, toInsert);
      keyToValue.put(key, value);
    } else {
      final Node toInsert = keyToNode.get(key);
      removeFromDoubleLinkedList(toInsert);
      append(head, toInsert);
      keyToValue.put(key, value);
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
