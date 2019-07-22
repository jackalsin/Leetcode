package interviews.linkedin._432_All_O_one_Data_Structure;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author zhiwei.xin
 * @version 1.0 on 9/15/18
 */
public final class AllOneII implements AllOne {
  private final Node head = new Node(0), tail = new Node(0);

  {
    head.next = tail;
    tail.prev = head;
  }

  private final Map<String, Node> keyToNode = new HashMap<>();

  /**
   * Inserts a new key <Key> with value 1. Or increments an existing key by 1.
   */
  public void inc(String key) {
    if (keyToNode.containsKey(key)) {
      final Node oldNode = keyToNode.get(key);
      oldNode.keys.remove(key);
      if (oldNode.next.count != oldNode.count + 1) {
        insertAfter(oldNode, new Node(oldNode.count + 1));
      }
      final Node newNode = oldNode.next;
      newNode.keys.add(key);
      keyToNode.put(key, newNode);

      if (oldNode.keys.isEmpty()) {
        removeFromDoubleLinkedList(oldNode);
      }
    } else {
      if (head.next.count != 1) {
        insertAfter(head, new Node(1));
      }
      final Node newNode = head.next;
      newNode.keys.add(key);
      keyToNode.put(key, newNode);
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
    if (keyToNode.containsKey(key)) {
      final Node oldNode = keyToNode.get(key);
      oldNode.keys.remove(key);

      if (oldNode.count == 1) {
        keyToNode.remove(key);
        if (oldNode.keys.isEmpty()) {
          removeFromDoubleLinkedList(oldNode);
        }
        return;
      }

      if (oldNode.prev.count + 1 != oldNode.count) {
        insertAfter(oldNode.prev, new Node(oldNode.count - 1));
      }
      final Node newNode = oldNode.prev;
      newNode.keys.add(key);
      keyToNode.put(key, newNode);

      if (oldNode.keys.isEmpty()) {
        removeFromDoubleLinkedList(oldNode);
      }
    }
  }

  /**
   * Returns one of the keys with maximal value.
   */
  public String getMaxKey() {
    final Set<String> keys = tail.prev.keys;
    for (String key : keys) {
      return key;
    }
    return "";
  }

  /**
   * Returns one of the keys with Minimal value.
   */
  public String getMinKey() {
    final Set<String> keys = head.next.keys;
    for (String key : keys) {
      return key;
    }
    return "";
  }

  private static final class Node {
    private final int count;
    private Node prev, next;
    private final Set<String> keys = new HashSet<>();

    private Node(int count) {
      this.count = count;
    }
  }
}
