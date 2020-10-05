package linkedin._146_LRU_Cache;

import java.util.HashMap;
import java.util.Map;

public final class LRUCacheI implements LRUCache {
  private final int capacity;

  private final Node head = new Node(0),
      tail = new Node(Integer.MAX_VALUE);
  private final Map<Integer, Integer> keyToValue = new HashMap<>();
  private final Map<Integer, Node> keyToNode = new HashMap<>();

  public LRUCacheI(int capacity) {
    this.capacity = capacity;
    head.next = tail;
    tail.prev = head;
  }

  public int get(int key) {
    if (keyToValue.containsKey(key)) {
      final int res = keyToValue.get(key);
      final Node toRemove = keyToNode.get(key);

      remove(toRemove);
      insertToHead(toRemove);
      return res;
    } else {
      return -1;
    }
  }

  private void insertToHead(Node toRemove) {
    final Node prev = head, next = head.next;
    prev.next = toRemove;
    toRemove.prev = prev;

    next.prev = toRemove;
    toRemove.next = next;
  }

  private void remove(final Node toRemove) {
    final Node prev = toRemove.prev, next = toRemove.next;
    prev.next = next;
    next.prev = prev;

    toRemove.prev = null;
    toRemove.next = null;
  }

  public void put(int key, int value) {
    if (capacity == 0) {
      return;
    }
    if (keyToValue.containsKey(key)) {
      keyToValue.put(key, value);
      final Node toRemove = keyToNode.get(key);
      remove(toRemove);
      insertToHead(toRemove);
    } else {
      if (keyToValue.size() == capacity) {
        final Node toRemove = tail.prev;
        keyToNode.remove(toRemove.key);
        keyToValue.remove(toRemove.key);
        remove(toRemove);
      }
      final Node toInsert = new Node(key);
      keyToValue.put(key, value);
      keyToNode.put(key, toInsert);
      insertToHead(toInsert);
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
