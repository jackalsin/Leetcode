package pinterest._146_LRU_Cache;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public final class LRUCache {
  private final int capacity;
  private final Node head = new Node(0), tail = new Node(Integer.MAX_VALUE);
  private final Map<Integer, Node> keyToNode = new HashMap<>();
  private final Map<Integer, Integer> keyToValue = new HashMap<>();

  public LRUCache(int capacity) {
    this.capacity = capacity;
    head.next = tail;
    tail.prev = head;
  }

  public int get(int key) {
    if (keyToValue.containsKey(key)) {
      final Node node = keyToNode.get(key);
      removeFromDoubleLinkedList(node);
      insertToHead(node);
      return keyToValue.get(key);
    } else {
      return -1;
    }
  }

  private void insertToHead(final Node node) {
    final Node second = head.next;

    head.next = node;
    node.prev = head;

    node.next = second;
    second.prev = node;
  }

  private void removeFromDoubleLinkedList(final Node node) {
    final Node prev = node.prev, next = node.next;
    node.prev = null;
    node.next = null;
    prev.next = next;
    next.prev = prev;
  }

  public void put(int key, int value) {
    if (keyToValue.containsKey(key)) {
      final Node node = keyToNode.get(key);
      removeFromDoubleLinkedList(node);
      insertToHead(node);
      keyToValue.put(key, value);
    } else {
      if (capacity == 0) {
        return;
      }
      if (keyToNode.size() >= capacity) {
        final Node oldestNode = tail.prev;
        removeFromDoubleLinkedList(oldestNode);
        removeFromBothMap(oldestNode);
      }
      // insert an new node.
      keyToValue.put(key, value);

      final Node newNode = new Node(key);
      keyToNode.put(key, newNode);
      insertToHead(newNode);
    }
  }

  private void removeFromBothMap(final Node node) {
    keyToNode.remove(node.key);
    keyToValue.remove(node.key);
  }

  private static final class Node {
    private final int key;
    private Node prev, next;

    private Node(int key) {
      this.key = key;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (!(o instanceof Node)) return false;
      Node node = (Node) o;
      return key == node.key;
    }

    @Override
    public int hashCode() {
      return Objects.hash(key);
    }
  }
}
