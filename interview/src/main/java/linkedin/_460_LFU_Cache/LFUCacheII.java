package linkedin._460_LFU_Cache;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/**
 * @author zhiwei.xin
 * @version 1.0 on 9/13/18
 */
public final class LFUCacheII implements LFUCache {
  private final int capacity;
  private final Node head = new Node(0), tail = new Node(0);
  private final Map<Integer, Node> keyToNode = new HashMap<>();
  private final Map<Integer, Integer> keyToValue = new HashMap<>();

  {
    head.next = tail;
    tail.prev = head;
  }

  public LFUCacheII(int capacity) {
    this.capacity = capacity;
  }

  public int get(int key) {
    if (keyToValue.containsKey(key)) {
      final int res = keyToValue.get(key);
      final Node toRemove = keyToNode.get(key);
      toRemove.keys.remove(key);
      if (toRemove.next.count != toRemove.count + 1) {
        final Node newNode = new Node(toRemove.count + 1);
        insertAfter(toRemove, newNode);
      }

      if (toRemove.keys.isEmpty()) {
        removeFromDoubleLinkedList(toRemove);
      }
      final Node newNode = toRemove.next;
      newNode.keys.add(key);
      keyToNode.put(key, newNode);
      return res;
    }
    return -1;
  }

  private void insertAfter(final Node prev, final Node cur) {
    final Node next = prev.next;

    prev.next = cur;
    cur.prev = prev;

    cur.next = next;
    next.prev = cur;
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
    if (keyToNode.containsKey(key)) {
      keyToValue.put(key, value);

      final Node toRemove = keyToNode.get(key);
      toRemove.keys.remove(key);
      if (toRemove.next.count != toRemove.count + 1) {
        insertAfter(toRemove, new Node(toRemove.count + 1));
      }

      final Node newNode = toRemove.next;
      newNode.keys.add(key);
      keyToNode.put(key, newNode);

      if (toRemove.keys.isEmpty()) {
        removeFromDoubleLinkedList(toRemove);
      }

    } else {
      if (capacity <= keyToNode.size()) {
        final Node toRemove = head.next;
        int keyToRemove = -1;
        for (int k : toRemove.keys) {
          keyToRemove = k;
          break;
        }
        keyToNode.remove(keyToRemove);
        keyToValue.remove(keyToRemove);
        toRemove.keys.remove(keyToRemove);
        if (toRemove.keys.isEmpty()) {
          removeFromDoubleLinkedList(toRemove);
        }
      } // end of capacity

      if (head.next.count != 1) {
        insertAfter(head, new Node(1));
      }
      final Node newNode = head.next;
      keyToValue.put(key, value);
      keyToNode.put(key, newNode);
      newNode.keys.add(key);

    }

  }

  private static final class Node {
    private final int count;
    private Node prev, next;
    private final LinkedHashSet<Integer> keys = new LinkedHashSet<>();

    private Node(int count) {
      this.count = count;
    }
  }
}
