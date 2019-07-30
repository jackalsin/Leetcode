package interviews.linkedin._716_Max_Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author jacka
 * @version 1.0 on 7/29/2019
 */
public final class MaxStackVI implements MaxStack {
  private final TreeMap<Integer, List<Node>> treeMap = new TreeMap<>();

  /**
   * in and out from head
   */
  private final Node head = new Node(-1), tail = new Node(-1);

  {
    head.next = tail;
    tail.prev = head;
  }

  public void push(int x) {
    final Node cur = new Node(x);
    treeMap.computeIfAbsent(x, key -> new ArrayList<>()).add(cur);
    append(head, cur);
  }

  public int pop() {
    assert head.next != tail;
    final Node cur = head.next;
    final List<Node> curList = treeMap.get(cur.key);
    if (curList.size() == 1) {
      treeMap.remove(cur.key);
    } else {
      curList.remove(curList.size() - 1);
    }
    remove(cur);
    return cur.key;
  }

  public int top() {
    return head.next.key;
  }

  public int peekMax() {
    return treeMap.lastKey();
  }

  public int popMax() {
    final Map.Entry<Integer, List<Node>> curEntry = treeMap.lastEntry();
    final List<Node> curLine = curEntry.getValue();
    final Node cur = curLine.remove(curLine.size() - 1);
    if (curLine.isEmpty()) {
      treeMap.remove(curEntry.getKey());
    }
    remove(cur);
    return curEntry.getKey();
  }

  private void remove(final Node cur) {
    final Node prev = cur.prev, next = cur.next;
    prev.next = next;
    next.prev = prev;
  }

  private void append(final Node prev, final Node cur) {
    final Node next = prev.next;
    cur.prev = prev;
    prev.next = cur;

    cur.next = next;
    next.prev = cur;
  }

  private static final class Node {
    private Node prev, next;
    private final int key;

    private Node(int key) {
      this.key = key;
    }
  }
}
