package linkedin._716_Max_Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public final class MaxStackII implements MaxStack {
  private final TreeMap<Integer, List<Node>> treemap = new TreeMap<>((x, y) -> Integer.compare(y, x));
  private final Node head = new Node(-1), tail = new Node(-1);

  {
    tail.prev = head;
    head.next = tail;
  }

  public void push(int x) {
    final Node cur = new Node(x);
    treemap.computeIfAbsent(x, a -> new ArrayList<>()).add(cur);
    insertAfter(tail.prev, cur);
  }

  private void insertAfter(final Node prev, final Node cur) {
    final Node next = prev.next;
    prev.next = cur;
    cur.prev = prev;

    next.prev = cur;
    cur.next = next;
  }

  public int pop() {
    final Node cur = tail.prev;
    removeFromDoubleLinkedList(cur);
    final List<Node> curList = treemap.get(cur.val);
    if (curList.size() == 1) {
      treemap.remove(cur.val);
    } else {
      curList.remove(curList.size() - 1);
    }
    return cur.val;
  }

  private void removeFromDoubleLinkedList(final Node cur) {
    final Node prev = cur.prev, next = cur.next;
    prev.next = next;
    next.prev = prev;
  }

  public int top() {
    return tail.prev.val;
  }

  public int peekMax() {
    return treemap.firstKey();
  }

  public int popMax() {
    final Map.Entry<Integer, List<Node>> entry = treemap.firstEntry();
    final int maxKey = entry.getKey();
    final List<Node> curList = entry.getValue();
    final Node cur = curList.get(curList.size() - 1);
    if (curList.size() == 1) {
      treemap.remove(maxKey);
    } else {
      curList.remove(curList.size() - 1);
    }
    removeFromDoubleLinkedList(cur);
    return maxKey;
  }

  private static final class Node {
    private final int val;
    private Node prev, next;

    private Node(int val) {
      this.val = val;
    }
  }
}

