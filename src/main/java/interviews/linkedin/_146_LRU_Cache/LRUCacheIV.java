package interviews.linkedin._146_LRU_Cache;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 8/3/2019
 */
public final class LRUCacheIV implements LRUCache {
  private final int capacity;

  private final Node head = new Node(-1), tail = new Node(-1);

  {
    head.next = tail;
    tail.prev = head;
  }

  private final Map<Integer, Integer> keyToValue = new HashMap<>();

  private final Map<Integer, Node> keyToNode = new HashMap<>();

  public LRUCacheIV(int capacity) {
    this.capacity = capacity;
  }

  public int get(int key) {
    if (!keyToValue.containsKey(key)) return -1;
    final Node toRemove = keyToNode.get(key);
    removeFromDoubleLinkedList(toRemove);
    append(tail.prev, toRemove);
    return keyToValue.get(key);
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
      final Node toRemove = keyToNode.get(key);
      removeFromDoubleLinkedList(toRemove);
      append(tail.prev, toRemove);
      keyToValue.put(key, value);
    } else {
      if (keyToNode.size() == capacity) { // remove oldest
        final Node toRemove = head.next;
        removeFromDoubleLinkedList(toRemove);
        keyToNode.remove(toRemove.key);
        keyToValue.remove(toRemove.key);
      }
      keyToValue.put(key, value);
      final Node curNode = new Node(key);
      keyToNode.put(key, curNode);
      append(tail.prev, curNode);
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
