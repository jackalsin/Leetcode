package interviews.airbnb._460_LFU_Cache;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 2/9/2019.
 */
public final class LFUCache {
  private final int capacity;

  private final Node head = new Node(0), tail = new Node(0);
  private final Map<Integer, Node> keyToCountNode = new HashMap<>();
  private final Map<Integer, Integer> keyToValue = new HashMap<>();

  {
    head.next = tail;
    tail.prev = head;
  }

  public LFUCache(int capacity) {
    this.capacity = capacity;
  }

  public int get(int key) {
    if (!keyToValue.containsKey(key)) {
      return -1;
    }
    final int res = keyToValue.get(key);
    final Node toRemove = keyToCountNode.get(key);

    if (toRemove.next.count != toRemove.count + 1) {
      final Node newNode = new Node(toRemove.count + 1);
      insertAfter(toRemove, newNode);
    }
    toRemove.keys.remove(key);
    toRemove.next.keys.add(key);
    keyToCountNode.put(key, toRemove.next);
    if (toRemove.keys.isEmpty()) {
      removeFromDoubleLinkedList(toRemove);
    }
    return res;
  }

  private void insertAfter(Node prev, Node toRemove) {
    final Node next = prev.next;
    prev.next = toRemove;
    toRemove.prev = prev;

    toRemove.next = next;
    next.prev = toRemove;
  }

  private static void removeFromDoubleLinkedList(Node toRemove) {
    final Node prev = toRemove.prev, next = toRemove.next;
    prev.next = next;
    next.prev = prev;
  }

  public void put(int key, int value) {
    if (capacity == 0) {
      return;
    }
    if (keyToValue.containsKey(key)) {
      keyToValue.put(key, value);
      final Node curNode = keyToCountNode.get(key);
      if (curNode.next.count != curNode.count + 1) {
        final Node newNode = new Node(curNode.count + 1);
        insertAfter(curNode, newNode);
      }
      curNode.keys.remove(key);
      if (curNode.keys.isEmpty()) {
        removeFromDoubleLinkedList(curNode);
      }
      curNode.next.keys.add(key);
      keyToValue.put(key, value);
      keyToCountNode.put(key, curNode.next);
      return;
    }
    if (keyToValue.size() >= capacity) {
      final Node toRemoveNode = head.next;
      int toRemoveKey = -1;
      for (int n : toRemoveNode.keys) {
        toRemoveKey = n;
        break;
      }
      toRemoveNode.keys.remove(toRemoveKey);
      if (toRemoveNode.keys.isEmpty()) {
        removeFromDoubleLinkedList(toRemoveNode);
      }
      keyToValue.remove(toRemoveKey);
      keyToCountNode.remove(toRemoveKey);
    }

    keyToValue.put(key, value);
    if (head.next.count != 1) {
      insertAfter(head, new Node(1));
    }
    keyToCountNode.put(key, head.next);
    head.next.keys.add(key);
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
