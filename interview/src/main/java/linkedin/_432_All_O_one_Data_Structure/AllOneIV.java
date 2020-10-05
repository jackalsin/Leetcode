package linkedin._432_All_O_one_Data_Structure;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 9/5/2019
 */
public final class AllOneIV implements AllOne {
  private final Node head = new Node(0), tail = new Node(0);

  {
    head.next = tail;
    tail.prev = head;
  }

  private final Map<String, Node> keyToNode = new HashMap<>();

  public void inc(String key) {
    assert key != null && !key.isEmpty();
    final Node prev = keyToNode.getOrDefault(key, head);

    prev.keys.remove(key);
    if (prev.next.count != prev.count + 1) {
      append(prev, new Node(prev.count + 1));
    }
    final Node cur = prev.next;
    cur.keys.add(key);
    keyToNode.put(key, cur);
    if (prev != head && prev.keys.isEmpty()) {
      remove(prev);
    }
  }

  public void dec(String key) {
    assert key != null && !key.isEmpty();
    if (!keyToNode.containsKey(key)) return;
    final Node cur = keyToNode.remove(key); // remove
    if (cur.prev.count != cur.count - 1) {
      final Node prev = new Node(cur.count - 1);
      append(cur.prev, prev);
    }
    final Node prev = cur.prev;
    cur.keys.remove(key);
    if (cur.count != 1) {
      prev.keys.add(key);
    }

    if (cur.keys.isEmpty()) {
      remove(cur);
    }
    keyToNode.put(key, prev);
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

  public String getMaxKey() {
    if (head.next == tail) {
      return "";
    }
    return tail.prev.keys.iterator().next();
  }

  public String getMinKey() {
    if (head.next == tail) {
      return "";
    }
    return head.next.keys.iterator().next();
  }

  private static final class Node {
    private final int count;
    private final Set<String> keys = new HashSet<>();
    private Node prev, next;

    private Node(int count) {
      this.count = count;
    }

    @Override
    public String toString() {
      return "Node{" +
          "count=" + count +
          ", keys=" + keys +
          ", prev=" + (prev == null ? "null" : prev.count) +
          ", next=" + (next == null ? "null" : next.count) +
          '}';
    }
  }
}
