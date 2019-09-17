package interviews.linkedin._716_Max_Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author jacka
 * @version 1.0 on 9/16/2019
 */
public final class MaxStackVI implements MaxStack {
  private final TreeMap<Integer, List<Node>> treeMap = new TreeMap<>();
  private final Node head = new Node(0), tail = new Node(0);

  {
    head.next = tail;
    tail.prev = head;
  }

  public void push(int x) {
    // from tail
    final Node cur = new Node(x);
    treeMap.computeIfAbsent(x, key -> new ArrayList<>()).add(cur);
    append(tail.prev, cur);
  }

  public int pop() {
    final Node toRemove = tail.prev;
    final int key = toRemove.key;
    final List<Node> curVal = treeMap.get(key);
    curVal.remove(curVal.size() - 1);
    if (curVal.isEmpty()) {
      treeMap.remove(key);
    }
    remove(toRemove);
    return key;
  }

  public int top() {
    return tail.prev.key;
  }

  public int peekMax() {
    assert !treeMap.isEmpty();
    return treeMap.lastKey();
  }

  public int popMax() {
    assert !treeMap.isEmpty();
    final Map.Entry<Integer, List<Node>> toRemoveEntry = treeMap.lastEntry();
    final int toRemoveKey = toRemoveEntry.getKey();
    final List<Node> toRemoveNodes = toRemoveEntry.getValue();
    final Node toRemoveNode = toRemoveNodes.remove(toRemoveNodes.size() - 1);
    if (toRemoveNodes.isEmpty()) {
      treeMap.remove(toRemoveKey);
    }
    remove(toRemoveNode);
    return toRemoveKey;
  }

  private static void remove(final Node cur) {
    final Node prev = cur.prev, next = cur.next;
    prev.next = next;
    next.prev = prev;
  }

  private static void append(final Node prev, final Node cur) {
    final Node next = prev.next;
    prev.next = cur;
    cur.prev = prev;

    cur.next = next;
    next.prev = cur;
  }

  private static final class Node {
    private Node prev, next;
    private final int key;

    private Node(final int key) {
      this.key = key;
    }
  }
}
