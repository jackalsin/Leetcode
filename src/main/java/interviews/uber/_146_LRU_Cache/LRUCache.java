package interviews.uber._146_LRU_Cache;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public final class LRUCache {
  private static final int INVALID_GET = -1;
  private final int capacity;
  private final Map<Integer, Node> keyToNode = new HashMap<>();
  private final Node head = new Node(-1, -1), tail = new Node(-1, -1);

  public LRUCache(int capacity) {
    this.capacity = capacity;
    head.next = tail;
    tail.prev = head;
  }

  public int get(int key) {
    final Node resultNode = keyToNode.get(key);
    if (capacity == 0 || resultNode == null) {
      return INVALID_GET;
    }

    removeFromLinkedList(resultNode);
    addToHead(resultNode);
    return resultNode.value;
  }

  public void put(int key, int value) {
    if (keyToNode.containsKey(key)) {
      removeFromLinkedList(key);
      final Node node = keyToNode.get(key);
      node.value = value;
      addToHead(node);
      return;
    }

    if (capacity == keyToNode.size()) {
      final int toRemoveKey = tail.prev.key;
      removeFromLinkedList(toRemoveKey);
      keyToNode.remove(toRemoveKey);
    }

    final Node toAdd = new Node(key, value);
    keyToNode.put(key, toAdd);
    addToHead(toAdd);
  }

  private void addToHead(Node toAdd) {
    insert(head, toAdd, head.next);
  }

  private void insert(final Node prev, final Node cur, final Node next) {
    prev.next = cur;
    cur.prev = prev;
    next.prev = cur;
    cur.next = next;
  }

  private void removeFromLinkedList(int key) {
    removeFromLinkedList(keyToNode.get(key));
  }

  private void removeFromLinkedList(Node toAdd) {
    if (toAdd.prev != null) {
      assert toAdd.next != null;
      final Node prev = toAdd.prev, next = toAdd.next;
      toAdd.prev = null;
      toAdd.next = null;

      prev.next = next;
      next.prev = prev;
    }
  }

  private static final class Node {
    private final int key;
    private int value;
    private Node prev, next;

    private Node(int key, int value) {
      this.key = key;
      this.value = value;
    }

    @Override
    public boolean equals(Object o) {
      if (!(o instanceof Node)) {
        return false;
      }

      Node other = (Node) o;
      return key == other.key && value == other.value;
    }

    @Override
    public int hashCode() {
      return Objects.hashCode(this);
    }

    @Override
    public String toString() {
      return "Node{" +
          "key=" + key +
//          ", value=" + value +
          ", next=" + next +
          '}';
    }
  }
}
