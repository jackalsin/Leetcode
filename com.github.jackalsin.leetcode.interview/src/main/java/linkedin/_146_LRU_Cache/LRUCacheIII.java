package linkedin._146_LRU_Cache;

import java.util.HashMap;
import java.util.Map;

public final class LRUCacheIII implements LRUCache {
  private final int capacity;
  private final Node head = new Node(0), tail = new Node(Integer.MAX_VALUE);

  {
    head.next = tail;
    tail.prev = head;
  }

  private final Map<Integer, Integer> keyToValue = new HashMap<>();
  private final Map<Integer, Node> keyToNode = new HashMap<>();

  public LRUCacheIII(final int capacity) {
    this.capacity = capacity;
  }

  public int get(int key) {
    if (keyToValue.containsKey(key)) {
      final Node curNode = keyToNode.get(key);
      removeFromDoubleLinkedList(curNode);
      insertToHead(curNode);
      return keyToValue.get(key);
    }
    return -1;
  }

  private void insertToHead(final Node curNode) {
    insert(head, curNode);
  }

  private void insert(final Node prev, final Node curNode) {
    final Node next = prev.next;
    prev.next = curNode;
    curNode.prev = head;

    curNode.next = next;
    next.prev = curNode;

  }

  private void removeFromDoubleLinkedList(final Node curNode) {
    final Node prev = curNode.prev, next = curNode.next;
    prev.next = next;
    next.prev = prev;
  }

  public void put(int key, int value) {
    if (capacity == 0) {
      return;
    }
    if (keyToValue.containsKey(key)) {
      final Node curNode = keyToNode.get(key);
      removeFromDoubleLinkedList(curNode);
      insertToHead(curNode);
      keyToValue.put(key, value);
      return;
    }

    if (keyToValue.size() >= capacity) {
      final Node toRemove = tail.prev;
      removeFromDoubleLinkedList(toRemove);
      keyToNode.remove(toRemove.key);
      keyToValue.remove(toRemove.key);
    }
    keyToValue.put(key, value);
    final Node newNode = new Node(key);
    insertToHead(newNode);
    keyToNode.put(key, newNode);
  }

  private static final class Node {
    private final int key;
    private Node prev, next;

    private Node(int key) {
      this.key = key;
    }
  }
}
