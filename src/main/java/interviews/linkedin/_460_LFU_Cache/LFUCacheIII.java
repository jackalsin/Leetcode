package interviews.linkedin._460_LFU_Cache;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 7/21/2019
 */
public final class LFUCacheIII implements LFUCache {
  private final Node head = new Node(Integer.MIN_VALUE),
      tail = new Node(Integer.MIN_VALUE);

  {
    tail.prev = head;
    head.next = tail;
  }

  private final Map<Integer, Node> keyToNode = new HashMap<>();

  private final Map<Integer, Integer> keyToValue = new HashMap<>();
  private final int capacity;

  public LFUCacheIII(final int capacity) {
    this.capacity = capacity;
  }

  public int get(int key) {
    if (capacity == 0 || !keyToNode.containsKey(key)) {
      return -1;
    }
    final int res = keyToValue.get(key);
    final Node oldNode = keyToNode.get(key);
    if (oldNode.count + 1 != oldNode.next.count) {
      insert(oldNode, new Node(oldNode.count + 1));
    }
    oldNode.keys.remove(key);
    if (oldNode.keys.isEmpty()) {
      removeFromDoubleLinkedList(oldNode);
    }
    final Node newNode = oldNode.next;
    newNode.keys.add(key);
    keyToNode.put(key, newNode);
    return res;
  }

  private static void insert(final Node prev, final Node cur) {
    final Node next = prev.next;
    prev.next = cur;
    cur.prev = prev;

    cur.next = next;
    next.prev = cur;
  }

  public void put(int key, int value) {
    if (capacity == 0) return;
    if (keyToNode.containsKey(key)) {
      keyToValue.put(key, value);
      final Node oldNode = keyToNode.get(key);
      if (oldNode.count + 1 != oldNode.next.count) {
        insert(oldNode, new Node(oldNode.count + 1));
      }
      final Node newNode = oldNode.next;
      newNode.keys.add(key);
      oldNode.keys.remove(key);
      if (oldNode.keys.isEmpty()) {
        removeFromDoubleLinkedList(oldNode);
      }
      keyToNode.put(key, newNode);

    } else {

      if (keyToNode.size() == capacity) {
        final Node toRemoveNode = head.next;
        final Set<Integer> keys = toRemoveNode.keys;
        final int toRemoveKey = keys.iterator().next();
        keyToNode.remove(toRemoveKey);
        keyToValue.remove(toRemoveKey);
        keys.remove(toRemoveKey);
        if (keys.isEmpty()) {
          removeFromDoubleLinkedList(toRemoveNode);
        }
      }

      if (head.next.count != 1) {
        insert(head, new Node(1));
      }
      final Node newNode = head.next;
      newNode.keys.add(key);
      keyToNode.put(key, newNode);
      keyToValue.put(key, value);
    }
  }

  private static void removeFromDoubleLinkedList(final Node cur) {
    final Node prev = cur.prev, next = cur.next;
    prev.next = next;
    next.prev = prev;
  }

  private static final class Node {
    private final int count;
    private final LinkedHashSet<Integer> keys = new LinkedHashSet<>();
    private Node prev, next;

    private Node(int count) {
      this.count = count;
    }
  }
}
