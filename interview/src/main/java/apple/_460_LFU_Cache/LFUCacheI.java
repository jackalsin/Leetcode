package apple._460_LFU_Cache;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 2/25/2021
 */
public final class LFUCacheI implements LFUCache {
  private final int capacity;
  private final Node head = new Node(0),
      tail = new Node(0);
  private final Map<Integer, Node> keyToNode = new HashMap<>();
  private final Map<Integer, Integer> keyToValue = new HashMap<>();

  {
    head.next = tail;
    tail.prev = head;
  }

  public LFUCacheI(int capacity) {
    this.capacity = capacity;
  }

  public int get(int key) {
    if (!keyToNode.containsKey(key)) {
      return -1;
    }
    final Node cur = keyToNode.get(key);
    if (cur.next.count != cur.count + 1) {
      final Node next = new Node(cur.count + 1);
      append(cur, next);
    }
    cur.keys.remove(key);
    cur.next.keys.add(key);
    keyToNode.put(key, cur.next);
    if (cur.keys.isEmpty()) {
      remove(cur);
    }

    return keyToValue.get(key);
  }

  private static void append(final Node prev, final Node cur) {
    final Node next = prev.next;
    prev.next = cur;
    cur.prev = prev;

    cur.next = next;
    next.prev = cur;
  }

  public void put(int key, int value) {
    if (capacity == 0) {
      return;
    }
    if (keyToNode.containsKey(key)) {
      final Node cur = keyToNode.get(key);
      if (cur.next.count != cur.count + 1) {
        final Node next = new Node(cur.count + 1);
        append(cur, next);
      }
      final Node next = cur.next;
      next.keys.add(key);
      cur.keys.remove(key);
      if (cur.keys.isEmpty()) {
        keyToNode.remove(key);
        remove(cur);
      }
      keyToNode.put(key, next);
    } else {
      if (keyToNode.size() == capacity) {
        final Node node = head.next;
        final LinkedHashSet<Integer> keys = node.keys;
        final int toRemoveKey = keys.iterator().next();
        keys.remove(toRemoveKey);
        keyToNode.remove(toRemoveKey);
        keyToValue.remove(toRemoveKey);
        if (keys.isEmpty()) {
          remove(node);
        }
      }
      final Node next = head.next;
      if (next.count != 1) {
        final Node toAdd = new Node(1);
        append(head, toAdd);
      }
      head.next.keys.add(key);
      keyToNode.put(key, head.next);
    }

    keyToValue.put(key, value);
  }

  private static void remove(final Node cur) {
    final Node prev = cur.prev, next = cur.next;
    cur.prev = null;
    cur.next = null;
    prev.next = next;
    next.prev = prev;
  }

  private static final class Node {
    private Node prev, next;
    private final int count;
    private final LinkedHashSet<Integer> keys = new LinkedHashSet<>();

    private Node(int count) {
      this.count = count;
    }

    @Override
    public String toString() {
      return "count = " + count + ", keys = " + keys;
    }
  }
}
