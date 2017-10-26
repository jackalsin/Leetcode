package interviews.amazon._460_LFU_Cache;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 10/24/2017.
 */
public final class LFUCache {
  private final Node dummy;
  private final Map<Integer, Node> keyToNode;
  private final Map<Integer, Integer> keyToValue;
  private final int capacity;

  public LFUCache(int capacity) {
    this.capacity = capacity;
    dummy = new Node(-1);
    keyToNode = new HashMap<>();
    keyToValue = new HashMap<>();
  }

  public int get(int key) {
    if (keyToValue.containsKey(key)) {
      increaseCount(key);
      return keyToValue.get(key);
    }
    return -1;
  }

  private void increaseCount(int key) {
    final Node curNode = keyToNode.get(key);
    assert curNode != null;
    curNode.keySet.remove(key);
    if (curNode.next != null && curNode.next.count == curNode.count + 1) {
      curNode.next.keySet.add(key);
      keyToNode.put(key, curNode.next);
    } else {
      final Node actualNextNode = new Node(curNode.count + 1);
      actualNextNode.keySet.add(key);
      add(curNode, actualNextNode);
      keyToNode.put(key, actualNextNode);
    }

    if (curNode.keySet.size() == 0) {
      remove(curNode);
    }
  }

  private void remove(Node toRemove) {
    final Node prev = toRemove.prev;
    final Node next = toRemove.next;
    prev.next = next;
    if (next != null) {
      next.prev = prev;
    }
  }

  public void put(int key, int value) {
    if (capacity == 0) {
      return;
    }
    Node curNode = keyToNode.get(key);
    if (curNode == null) {
      if (keyToValue.size() == capacity) {
        removeOld();
      }
      if (dummy.next == null || dummy.next.count != 0) {
        final Node newNode = new Node(0);
        newNode.keySet.add(key);
        add(dummy, newNode);
        keyToNode.put(key, newNode);
      } else {
        final Node countNode = dummy.next;
        countNode.keySet.add(key);
        keyToNode.put(key, countNode);
      }
    } else { // curNode
      increaseCount(key);
    }
    keyToValue.put(key, value);
  }

  private void add(Node prevNode, Node curNode) {
    Node nextNode = prevNode.next;
    curNode.next = nextNode;
    if (nextNode != null) {
      nextNode.prev = curNode;
    }
    prevNode.next = curNode;
    curNode.prev = prevNode;
  }

  private void removeOld() {
    Node head = dummy.next;
    if (head == null) {
      return;
    }
    int removedKey = 0;
    for (int n : head.keySet) {
      removedKey = n;
      break;
    }
    if (head.keySet.size() == 1) {
      remove(head);
    } else {
      head.keySet.remove(removedKey);
    }
    keyToValue.remove(removedKey);
    keyToNode.remove(removedKey);
  }

  private static final class Node {
    private final Set<Integer> keySet;
    private final int count;
    private Node prev = null, next = null;

    Node(int counts) {
      keySet = new LinkedHashSet<>();
      this.count = counts;
    }

    @Override
    public String toString() {
      return "Node{" +
          "keySet=" + keySet +
          ", count=" + count +
          ", prev=" + (prev == null ? null : prev.count) +
          ", next=" + (next == null ? null : next.count) +
          '}';
    }
  }

}
