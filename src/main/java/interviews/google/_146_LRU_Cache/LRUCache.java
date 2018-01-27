package interviews.google._146_LRU_Cache;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 1/15/2018.
 */
public final class LRUCache {

  private static final int INVALID = -1;
  /* Head is the most recently used. */
  private Node head = new Node(INVALID, INVALID), tail = new Node(INVALID, INVALID);
  private final Map<Integer, Node> keyToValue = new HashMap<>();
  private final int capacity;

  public LRUCache(int capacity) {
    this.capacity = capacity;
    head.next = tail;
    tail.prev = head;
  }

  public int get(int key) {
    Node res = keyToValue.get(key);
    if (res == null) {
      return INVALID;
    } else {
      removeFromLink(res);
      addToFirst(res);
      return res.val;
    }
  }

  public void put(int key, int value) {
    if (keyToValue.containsKey(key)) {
      final Node target = keyToValue.get(key);
      removeFromLink(target);
      target.val = value;
      addToFirst(target);
    } else {
      if (keyToValue.size() == capacity) {
        final Node toRemove = tail.prev;
        keyToValue.remove(toRemove.key);
        removeFromLink(toRemove);
      }
      final Node newNode = new Node(key, value);
      keyToValue.put(key, newNode);
      addToFirst(newNode);
    }
  }

  private void addToFirst(Node node) {
    Node next = head.next;
    head.next = node;
    node.prev = head;
    node.next = next;
    next.prev = node;
  }

  private void removeFromLink(Node toRemove) {
    final Node next = toRemove.next, prev = toRemove.prev;
    next.prev = prev;
    prev.next = next;
  }

  private static final class Node {
    private int key, val;
    private Node prev, next;

    public Node(int key, int val) {
      this.key = key;
      this.val = val;
    }

    @Override
    public String toString() {
      return "Node{" +
          "key=" + key +
          ", val=" + val +
          ", prev=" + (prev == null ? null : prev.val) +
          ", next=" + (next == null ? null : next.val) +
          '}';
    }
  }
}
