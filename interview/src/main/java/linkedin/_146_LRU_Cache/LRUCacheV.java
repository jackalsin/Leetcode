package linkedin._146_LRU_Cache;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 8/27/2019
 */
public final class LRUCacheV implements LRUCache {
  private final int capacity;
  private final Map<Integer, Node> keyToNode = new HashMap<>();
  private final Map<Integer, Integer> keyToValue = new HashMap<>();
  private final Node head = new Node(-1), tail = new Node(-1);

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
    if (keyToNode.containsKey(key)) {
      keyToValue.put(key, value);
      final Node toRemove = keyToNode.get(key);
      removeFromDoubleLinkedList(toRemove);
      append(head, toRemove);
    } else {
      if (keyToNode.size() == capacity) {
        final Node toRemoveNode = tail.prev;
        final int toRemoveKey = toRemoveNode.key;
        keyToNode.remove(toRemoveKey);
        keyToValue.remove(toRemoveKey);
        removeFromDoubleLinkedList(toRemoveNode);
      }
      final Node toInsertNode = new Node(key);
      append(head, toInsertNode);
      keyToNode.put(key, toInsertNode);
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
