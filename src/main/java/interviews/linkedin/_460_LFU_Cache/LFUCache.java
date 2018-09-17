package interviews.linkedin._460_LFU_Cache;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author zhiwei.xin
 * @version 1.0 on 9/13/18
 */
public final class LFUCache {
  private final Node head = new Node(0), tail = new Node(Integer.MAX_VALUE);
  private final int capacity;

  private final Map<Integer, Integer> keyToValue = new HashMap<>();
  private final Map<Integer, Node> keyToNode = new HashMap<>();

  public LFUCache(int capacity) {
    this.capacity = capacity;
    head.next = tail;
    tail.prev = head;
  }

  public int get(int key) {
    if (keyToValue.containsKey(key)) {
      final int val = keyToValue.get(key);
      increaseCount(key);
      // update the key order
      keyToNode.get(key).keys.add(key);
      return val;
    } else {
      return -1; // return -1 when not found;
    }
  }

  private void increaseCount(final int key) {
    final Node prevCountNode = keyToNode.get(key);
    final int newCount = prevCountNode.count + 1;
    prevCountNode.keys.remove(key);

    // find new Node
    if (prevCountNode.next.count != newCount) {
      insertToDoubleLinkedList(prevCountNode, new Node(newCount));
    }
    final Node newCountNode = prevCountNode.next;
    newCountNode.keys.add(key);
    keyToNode.put(key, newCountNode);

    if (prevCountNode.keys.size() == 0) {
      removeFromDoubleLinkedList(prevCountNode);
    }
  }

  private void insertToDoubleLinkedList(final Node prev, final Node toInsert) {
    final Node next = prev.next;
    prev.next = toInsert;
    toInsert.prev = prev;

    toInsert.next = next;
    next.prev = toInsert;
  }

  private void removeFromDoubleLinkedList(final Node toRemove) {
    final Node prev = toRemove.prev, next = toRemove.next;
    prev.next = next;
    next.prev = prev;
  }

  public void put(int key, int value) {
    if (this.capacity == 0) {
      return;
    }
    if (keyToValue.containsKey(key)) {
      increaseCount(key);
      keyToValue.put(key, value);
    } else {
      if (keyToValue.size() == this.capacity) {
        final int oldestKey = getOldestNode();
        final Node oldestNode = keyToNode.remove(oldestKey);
        keyToValue.remove(oldestKey);
        oldestNode.keys.remove(oldestKey);
        if (oldestNode.keys.isEmpty()) {
          removeFromDoubleLinkedList(oldestNode);
        }
      } // end of remove

      if (head.next.count != 1) {
        final Node countNode1 = new Node(1);
        insertToDoubleLinkedList(head, countNode1);
      }

      final Node countNode1 = head.next;
      countNode1.keys.add(key);
      keyToValue.put(key, value);
      keyToNode.put(key, countNode1);

    }

  }

  private int getOldestNode() {
    final Set<Integer> oldestKeys = head.next.keys;
    for (int key : oldestKeys) return key;
    throw new IllegalStateException();
  }

  private static final class Node {
    private final int count;
    private final Set<Integer> keys = new LinkedHashSet<>();
    private Node prev, next;

    private Node(int count) {
      this.count = count;
    }
  }
}
