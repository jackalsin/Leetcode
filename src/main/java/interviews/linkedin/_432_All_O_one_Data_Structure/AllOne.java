package interviews.linkedin._432_All_O_one_Data_Structure;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author zhiwei.xin
 * @version 1.0 on 9/15/18
 */
public final class AllOne {
  // TODO: Revisit
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
    assert !key.isEmpty();

    final Node prevCountNode = keyToNode.getOrDefault(key, head);
    prevCountNode.keys.remove(key);

    if (prevCountNode.count + 1 != prevCountNode.next.count) {
      final Node newCountNode = new Node(prevCountNode.count + 1);
      insertToDoubleLinkedList(prevCountNode, newCountNode);
    }

    final Node newCountNode = prevCountNode.next;
    keyToNode.put(key, newCountNode);
    newCountNode.keys.add(key);

    if (prevCountNode.keys.isEmpty() && head != prevCountNode) {
      removeFromDoubleLinkedList(prevCountNode);
    }
  }

  private void removeFromDoubleLinkedList(Node cur) {
    final Node prev = cur.prev, next = cur.next;
    prev.next = next;
    next.prev = prev;
  }

  private void insertToDoubleLinkedList(Node prev, Node cur) {
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
    if (!keyToNode.containsKey(key)) {
      return;
    }

    final Node prevCountNode = keyToNode.get(key);
    prevCountNode.keys.remove(key);
    if (prevCountNode.prev.count + 1 != prevCountNode.count) {
      final Node newCountNode = new Node(prevCountNode.count - 1);
      insertToDoubleLinkedList(prevCountNode.prev, newCountNode);
      newCountNode.keys.add(key);
    }

    if (prevCountNode.keys.isEmpty()) {
      removeFromDoubleLinkedList(prevCountNode);
    }
    keyToNode.put(key, prevCountNode.prev);

    if (prevCountNode.count == 1) {
      keyToNode.remove(key);
    } else {
      prevCountNode.prev.keys.add(key);
    }
  }

  /**
   * Returns one of the keys with maximal value.
   */
  public String getMaxKey() {
    if (tail.prev == head) {
      return "";
    }
    for (String key : tail.prev.keys) {
      return key;
    }
    throw new IllegalStateException();
  }

  /**
   * Returns one of the keys with Minimal value.
   */
  public String getMinKey() {
    if (head.next == tail) {
      return "";
    }
    for (String key : head.next.keys) {
      return key;
    }
    throw new IllegalStateException();
  }

  private static final class Node {
    private final int count;
    private Node next, prev;
    private final Set<String> keys = new LinkedHashSet<>();

    private Node(int count) {
      this.count = count;
    }
  }

}
