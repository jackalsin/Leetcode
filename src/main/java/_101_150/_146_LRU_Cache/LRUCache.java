package _101_150._146_LRU_Cache;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 7/1/2017.
 */
public final class LRUCache {
  private static final int INVALID = -1;

  private final int capacity;

  private final Map<Integer, Node> keyToValue;

  private static int size;

  private Node head, tail;

  public LRUCache(int capacity) {
    if (capacity <= 0) {
      throw new IllegalArgumentException("Capacity must be greater than 0, but now is " + capacity);
    }
    size = 0;
    this.capacity = capacity;
    keyToValue = new HashMap<>();
    head = new Node();
    tail = new Node();
    head.next = tail;
    tail.prev = head;
  }

  public int get(int key) {
    Node res = keyToValue.get(key);
    if (res == null) {
      return INVALID;
    } else {
      update(res);
      return res.value;
    }
  }


  public void put(int key, int value) {
    Node node = keyToValue.get(key);
    if (node == null) {
      node = new Node(key, value);
      keyToValue.put(key, node);
      add(node);
      size++;
    } else {
      node.value = value;
      update(node);
    }

    if (size > capacity) {
      Node toRemove = tail.prev;
      remove(toRemove);
      keyToValue.remove(toRemove.key);
      size--;
    }
  }

  private void update(Node res) {
    remove(res);
    add(res);
  }

  /**
   * Add the a node right after the head.
   *
   * @param toAdd
   */
  private void add(Node toAdd) {
    Node sec = head.next;
    head.next = toAdd;
    toAdd.prev = head;
    toAdd.next = sec;
    sec.prev = toAdd;
  }

  private void remove(Node toRemove) {
    Node prev = toRemove.prev, next = toRemove.next;
    prev.next = next;
    next.prev = prev;
    toRemove.prev = null;
    toRemove.next = null;
  }

  private static final class Node {
    int key, value;
    Node prev, next;

    Node(int key, int value) {
      this.key = key;
      this.value= value;
    }

    Node() {
      this(0, 0);
    }
    @Override
    public String toString() {
      return "(" + key + ", " + size + ")";
    }
  }

}
