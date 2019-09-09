package interviews.linkedin._460_LFU_Cache;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 9/8/2019
 */
public final class LFUCacheIV implements LFUCache {
  private final int capacity;
  private final Map<Integer, Node> keyToNode = new HashMap<>();
  private final Map<Integer, Integer> keyToValue = new HashMap<>();
  private final Node head = new Node(0), tail = new Node(0);

  {
    head.next = tail;
  }

  public LFUCacheIV(final int capacity) {
    this.capacity = capacity;
  }

  public int get(int key) {
    if (!keyToNode.containsKey(key)) {
      return -1;
    }
    final int res = keyToValue.get(key);
    final Node toRemove = keyToNode.get(key);
    toRemove.keys.remove(key);
    if (toRemove.next.count != toRemove.count + 1) {
      append(toRemove, new Node(toRemove.count + 1));
    }
    final Node newNode = toRemove.next;
    newNode.keys.add(key);
    keyToNode.put(key, newNode);
    if (toRemove.keys.isEmpty()) {
      remove(toRemove);
    }
    return res;
  }

  private static void append(final Node prev, final Node cur) {
    final Node next = prev.next;
    prev.next = cur;
    cur.prev = prev;

    cur.next = next;
    next.prev = cur;
  }

  private static void remove(final Node cur) {
    final Node prev = cur.prev, next = cur.next;
    prev.next = next;
    next.prev = prev;
  }

  public void put(int key, int value) {
    if (capacity <= 0) {
      return;
    }
    if (keyToValue.containsKey(key)) {
      final Node curNode = keyToNode.get(key);
      curNode.keys.remove(key);
      if (curNode.next.count != curNode.count + 1) {
        append(curNode, new Node(curNode.count + 1));
      }
      final Node newNode = curNode.next;
      newNode.keys.add(key);
      keyToNode.put(key, newNode);
      if (curNode.keys.isEmpty()) {
        remove(curNode);
      }
      keyToValue.put(key, value);
      return;
    }
    if (keyToNode.size() == capacity) {
      // remove oldest
      final Node toRemoveNode = head.next;
      final int toRemoveKey = toRemoveNode.keys.iterator().next();
      toRemoveNode.keys.remove(toRemoveKey);
      keyToValue.remove(toRemoveKey);
      keyToNode.remove(toRemoveKey);
      if (toRemoveNode.keys.isEmpty()) {
        remove(toRemoveNode);
      }
    }
    // insert
    if (head.next.count != 1) {
      append(head, new Node(1));
    }

    final Node toInsertNode = head.next;
    toInsertNode.keys.add(key);
    keyToNode.put(key, toInsertNode);
    keyToValue.put(key, value);
  }

  private static final class Node {
    private Node prev, next;
    private final int count;
    private final LinkedHashSet<Integer> keys = new LinkedHashSet<>();

    private Node(int count) {
      this.count = count;
    }
  }
}
