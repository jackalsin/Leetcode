package interviews.oracle._146_LRU_Cache;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 10/19/2019
 */
public final class LRUCacheI implements LRUCache {
  private final int capacity;
  private final Node head = new Node(0), tail = new Node(0);

  {
    head.next = tail;
    tail.prev = head;
  }

  private final Map<Integer, Node> keyToNode = new HashMap<>();
  private final Map<Integer, Integer> keyToValue = new HashMap<>();

  public LRUCacheI(final int capacity) {
    this.capacity = capacity;
  }

  public int get(int key) {
    if (!keyToNode.containsKey(key)) return -1;
    final int result = keyToValue.get(key);
    final Node toInsert = keyToNode.get(key);
    removeFromDoubleLinkedList(toInsert);
    append(head, toInsert);
    return result;
  }

  private static void append(final Node prev, final Node toInsert) {
    final Node next = prev.next;
    prev.next = toInsert;
    toInsert.prev = prev;

    toInsert.next = next;
    next.prev = toInsert;
  }

  private static void removeFromDoubleLinkedList(final Node toInsert) {
    final Node prev = toInsert.prev, next = toInsert.next;
    prev.next = next;
    next.prev = prev;
  }

  public void put(int key, int value) {
    if (capacity == 0) {
      return;
    }

    if (keyToNode.containsKey(key)) {
      keyToValue.put(key, value);
      final Node toInsert = keyToNode.get(key);
      removeFromDoubleLinkedList(toInsert);
      append(head, toInsert);
      return;
    }
    // first evict
    if (keyToValue.size() == capacity) {
      final Node toRemove = tail.prev;
      removeFromDoubleLinkedList(toRemove);
      keyToNode.remove(toRemove.key);
      keyToValue.remove(toRemove.key);
    }

    keyToValue.put(key, value);
    final Node toInsert = new Node(key);
    keyToNode.put(key, toInsert);
    append(head, toInsert);
  }

  private static final class Node {
    private final int key;
    private Node prev, next;

    private Node(int key) {
      this.key = key;
    }
  }
}
