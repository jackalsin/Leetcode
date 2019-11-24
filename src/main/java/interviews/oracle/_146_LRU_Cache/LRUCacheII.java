package interviews.oracle._146_LRU_Cache;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 11/24/2019
 */
public final class LRUCacheII implements LRUCache {
  private final int capacity;
  private final Node head = new Node(-1), tail = new Node(-1);

  // head is the latest
  {
    head.next = tail;
    tail.prev = head;
  }

  private final Map<Integer, Integer> keyToValue = new HashMap<>();
  private final Map<Integer, Node> keyToNode = new HashMap<>();

  public LRUCacheII(final int capacity) {
    this.capacity = capacity;
  }

  public int get(int key) {
    if (!keyToValue.containsKey(key)) {
      return -1;
    }
    final int res = keyToValue.get(key);
    final Node node = keyToNode.get(key);
    removeFromDoubleLinkedList(node);
    insert(head, node);
    return res;
  }

  private static void removeFromDoubleLinkedList(final Node cur) {
    final Node prev = cur.prev, next = cur.next;
    prev.next = next;
    next.prev = prev;
  }

  private static void insert(final Node prev, Node cur) {
    final Node next = prev.next;
    prev.next = cur;
    cur.prev = prev;

    cur.next = next;
    next.prev = cur;
  }

  public void put(int key, int value) {
    if (capacity == 0) {
      return;
    }
    if (keyToValue.containsKey(key)) {
      final Node toInsert = keyToNode.get(key);
      keyToValue.put(key, value);
      removeFromDoubleLinkedList(toInsert);
      insert(head, toInsert);
    } else { // need evict
      if (keyToValue.size() >= capacity) {
        final Node toRemove = tail.prev;
        removeFromDoubleLinkedList(toRemove);
        keyToValue.remove(toRemove.key);
        keyToNode.remove(toRemove.key);
      }
      final Node toInsert = new Node(key);
      keyToNode.put(key, toInsert);
      keyToValue.put(key, value);
      insert(head, toInsert);
    }
  }

  private static final class Node {
    private Node prev, next;
    private final int key;

    private Node(final int val) {
      this.key = val;
    }
  }
}
