package interviews.microsoft.noodleEssence._146_LRU_Cache;

import java.util.HashMap;
import java.util.Map;

public final class LRUCache {
  private final int capacity;
  private Node head = new Node(0), tail = new Node(Integer.MAX_VALUE);
  private final Map<Integer, Node> keyToNode = new HashMap<>();
  private final Map<Integer, Integer> keyToValue = new HashMap<>();

  public LRUCache(int capacity) {
    head.next = tail;
    tail.prev = head;
    this.capacity = capacity;
  }

  public int get(int key) {
    if (!keyToValue.containsKey(key)) {
      return -1;
    }
    final int res = keyToValue.get(key);
    final Node node = keyToNode.get(key);
    removeFromDoubleLinkedList(node);
    insertToHead(node);
    return res;
  }

  private void insertToHead(Node node) {
    final Node next = head.next;
    head.next = node;
    node.prev = head;

    node.next = next;
    next.prev = node;
  }

  private void removeFromDoubleLinkedList(final Node cur) {
    final Node prev = cur.prev, next = cur.next;
    prev.next = next;
    next.prev = prev;
  }

  public void put(int key, int value) {
    if (capacity == 0) {
      return;
    }
    if (keyToValue.containsKey(key)) {
      keyToValue.put(key, value);
      final Node node = keyToNode.get(key);
      removeFromDoubleLinkedList(node);
      insertToHead(node);
    } else {
      if (keyToValue.size() == capacity) {
        final Node toRemove = tail.prev;
        removeFromDoubleLinkedList(toRemove);
        final int toRemoveKey = toRemove.key;
        keyToValue.remove(toRemoveKey);
        keyToNode.remove(toRemoveKey);
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
