package linkedin._146_LRU_Cache;

import java.util.HashMap;
import java.util.Map;

public final class LRUCacheII implements LRUCache {
  private final int capacity;
  private final Node head = new Node(0), tail = new Node(Integer.MAX_VALUE);
  private final Map<Integer, Integer> keyToValue = new HashMap<>();
  private final Map<Integer, Node> keyToNode = new HashMap<>();

  public LRUCacheII(final int capacity) {
    this.capacity = capacity;
    head.next = tail;
    tail.prev = head;
  }

  @Override
  public int get(int key) {
    if (keyToValue.containsKey(key)) {
      final Node cur = keyToNode.get(key);
      removeFromDoubleLinkedList(cur);
      insertToHead(cur);
      return keyToValue.get(key);
    }
    return -1;
  }

  private void insertToHead(final Node cur) {
    final Node prev = head, next = head.next;
    prev.next = cur;
    cur.prev = prev;

    cur.next = next;
    next.prev = cur;
  }

  private void removeFromDoubleLinkedList(Node cur) {
    final Node prev = cur.prev, next = cur.next;
    prev.next = next;
    next.prev = prev;
  }

  @Override
  public void put(int key, int value) {
    if (capacity == 0) {
      return;
    }
    if (keyToValue.containsKey(key)) {
      keyToValue.put(key, value);
      final Node cur = keyToNode.get(key);
      removeFromDoubleLinkedList(cur);
      insertToHead(cur);
    } else {
      if (keyToValue.size() == capacity) {
        final Node oldestNode = tail.prev;
        final int oldestKey = oldestNode.key;
        removeFromDoubleLinkedList(oldestNode);
        keyToValue.remove(oldestKey);
        keyToNode.remove(oldestKey);
      }

      keyToValue.put(key, value);
      final Node newNode = new Node(key);
      keyToNode.put(key, newNode);
      insertToHead(newNode);
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
