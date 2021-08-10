package linkedin._146_LRU_Cache;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 8/27/2019
 */
public final class LRUCacheV implements LRUCache {
  private final int capacity;
  private final Node head = new Node(0), tail = new Node(0);
  private final Map<Integer, Integer> keyToValue = new HashMap<>();
  private final Map<Integer, Node> keyToNode = new HashMap<>();

  {
    head.next = tail;
    tail.prev = head;
  }

  public LRUCacheV(int capacity) {
    this.capacity = capacity;
  }

  public int get(int key) {
    if (!keyToValue.containsKey(key)) return -1;
    final int res = keyToValue.get(key);
    final Node toRemove = keyToNode.get(key);
    removeFromDoubleLinkedList(toRemove);
    append(head, toRemove);
    return res;
  }

  private static void append(final Node prev, final Node toRemove) {
    final Node next = prev.next;
    prev.next = toRemove;
    toRemove.prev = prev;

    next.prev = toRemove;
    toRemove.next = next;
  }

  private static void removeFromDoubleLinkedList(final Node cur) {
    final Node prev = cur.prev, next = cur.next;
    prev.next = next;
    next.prev = prev;
  }

  public void put(int key, int value) {
    if (capacity == 0) return;
    if (keyToValue.containsKey(key)) {
      final Node toRemove = keyToNode.get(key);
      removeFromDoubleLinkedList(toRemove);
      append(head, toRemove);
      keyToValue.put(key, value);
    } else {
      if (keyToValue.size() == capacity) {
        final Node toRemove = tail.prev;
        keyToNode.remove(toRemove.key);
        keyToValue.remove(toRemove.key);
        removeFromDoubleLinkedList(toRemove);
      }

      final Node toAdd = new Node(key);
      keyToValue.put(key, value);
      keyToNode.put(key, toAdd);
      append(head, toAdd);
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
