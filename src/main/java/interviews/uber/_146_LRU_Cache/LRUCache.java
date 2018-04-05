package interviews.uber._146_LRU_Cache;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public final class LRUCache {
  private static final int INVALID = -1;
  private final Node head = new Node(INVALID, INVALID), tail = new Node(INVALID, INVALID);
  private final Map<Integer, Node> keyToNode = new HashMap<>();
  private final int capacity;

  public LRUCache(int capacity) {
    head.next = tail;
    tail.prev = head;
    this.capacity = capacity;
  }

  /**
   * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
   */
  public int get(int key) {
    if (keyToNode.containsKey(key)) {
      final Node node = keyToNode.get(key);
      remove(node);
      addToHead(node);
      return node.val;
    } else {
      return -1;
    }
  }

  private void addToHead(final Node node) {
    final Node next = head.next;

    // hook the tail
    next.prev = node;
    node.next = next;

    // hook head
    head.next = node;
    node.prev = head;
  }

  private void remove(final Node node) {
    final Node prev = node.prev, next = node.next;
    prev.next = next;
    next.prev = prev;
  }

  /**
   * put(key, value) - Set or insert the value if the key is not already present. When the cache reached its
   * capacity, it should invalidate the least recently used item before inserting a new item.
   */
  public void put(int key, int value) {
    if (keyToNode.containsKey(key)) {
      final Node node = keyToNode.get(key);
      node.val = value;

      remove(node);
      addToHead(node);
    } else {
      final Node newNode = new Node(key, value);
      if (keyToNode.size() == capacity) {
        final Node toRemoveNode = tail.prev;
        keyToNode.remove(toRemoveNode.key);
        remove(toRemoveNode);
      }
      addToHead(newNode);
      keyToNode.put(key, newNode);
    }
  }

  private static final class Node {
    private final int key;
    private int val;
    private Node prev, next;

    private Node(final int key, final int val) {
      this.key = key;
      this.val = val;
    }
  }
}
