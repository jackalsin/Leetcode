package interviews.linkedin._432_All_O_one_Data_Structure;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author zhiwei.xin
 * @version 1.0 on 9/15/18
 */
public final class AllOneI {

  private final Node head = new Node(0), tail = new Node(0);

  {
    head.next = tail;
    tail.prev = head;
  }

  private final Map<String, Node> keyToCount = new HashMap<>();

  /**
   * Inserts a new key <Key> with value 1. Or increments an existing key by 1.
   */
  public void inc(String key) {
    if (keyToCount.containsKey(key)) {
      final Node oldNode = keyToCount.get(key);
      oldNode.keys.remove(key);
      final Node newNode = oldNode.next.count == oldNode.count + 1 ? oldNode.next : new Node(oldNode.count + 1);
      newNode.keys.add(key);
      if (oldNode.next != newNode) {
        insertAfter(oldNode, newNode);
      }

      keyToCount.put(key, newNode);

      if (oldNode.keys.isEmpty()) {
        removeFromDoubleLinkedList(oldNode);
      }

    } else {
      final Node newNode = head.next.count == 1 ? head.next : new Node(1);
      newNode.keys.add(key);
      if (head.next != newNode) {
        insertAfter(head, newNode);
      }
      keyToCount.put(key, newNode);
    }
  }

  private void removeFromDoubleLinkedList(final Node cur) {
    final Node prev = cur.prev, next = cur.next;
    prev.next = next;
    next.prev = prev;
  }

  private void insertAfter(final Node prev, final Node cur) {
    final Node next = prev.next;

    prev.next = cur;
    cur.prev = prev;

    cur.next = next;
    next.prev = cur;
  }

  /**
   * Decrements an existing key by 1. If Key's value is 1, remove it from the data structure.
   */
  public void dec(String key) {
    if (!keyToCount.containsKey(key)) {
      return;
    }
    // todo : remove from hashmap
    final Node oldNode = keyToCount.get(key);

    if (oldNode.prev.count != oldNode.count - 1) {
      final Node newNode = new Node(oldNode.count - 1);
      insertAfter(oldNode.prev, newNode);
    }
    final Node newNode = oldNode.prev;
    newNode.keys.add(key);
    oldNode.keys.remove(key);

    if (oldNode.keys.isEmpty()) {
      removeFromDoubleLinkedList(oldNode);
    }
    if (oldNode.count == 1) {
      keyToCount.remove(key);
    } else {
      keyToCount.put(key, newNode);
    }
  }

  /**
   * Returns one of the keys with maximal value.
   */
  public String getMaxKey() {
    if (tail.prev == head) {
      return "";
    }

    String res = null;
    final Set<String> curSet = tail.prev.keys;
    for (String key : curSet) {
      res = key;
      break;
    }
    return res;
  }

  /**
   * Returns one of the keys with Minimal value.
   */
  public String getMinKey() {
    if (tail.prev == head) {
      return "";
    }

    String res = null;
    final Set<String> curSet = head.next.keys;
    for (String key : curSet) {
      res = key;
      break;
    }
    return res;
  }

  private static final class Node {
    private final int count;
    private final Set<String> keys = new HashSet<>();
    private Node prev, next;

    public Node(int count) {
      this.count = count;
    }
  }
}
