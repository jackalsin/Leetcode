package linkedin._716_Max_Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public final class MaxStackII implements MaxStack {
  private final TreeMap<Integer, List<Node>> valToNodes = new TreeMap<>();
  private final Node head = new Node(-1), tail = new Node(-1);

  {
    head.next = tail;
    tail.prev = head;
  }
  public void push(int x) {
    final Node node = new Node(x);
    append(tail.prev, node);
    valToNodes.computeIfAbsent(x, k -> new ArrayList<>()).add(node);
  }

  private static void append(final Node prev, final Node cur) {
    final Node next = prev.next;
    prev.next = cur;
    cur.prev = prev;

    cur.next = next;
    next.prev = cur;
  }

  public int pop() {
    final Node toRemove = tail.prev;
    removeFromDoubleLinkedList(toRemove);
    final List<Node> curList = valToNodes.get(toRemove.val);
    curList.remove(curList.size() - 1);
    if (curList.isEmpty()) {
      valToNodes.remove(toRemove.val);
    }
    return toRemove.val;
  }

  private static void removeFromDoubleLinkedList(final Node toRemove) {
    final Node prev = toRemove.prev, next = toRemove.next;
    prev.next = next;
    next.prev = prev;
  }

  public int top() {
    return tail.prev.val;
  }

  public int peekMax() {
    return valToNodes.lastKey();
  }

  public int popMax() {
    final Map.Entry<Integer, List<Node>> toRemoveEntry = valToNodes.lastEntry();
    final List<Node> curList = toRemoveEntry.getValue();
    final int key = toRemoveEntry.getKey();
    final Node toRemove = curList.remove(curList.size() - 1);
    removeFromDoubleLinkedList(toRemove);
    if (curList.isEmpty()) {
      valToNodes.remove(key);
    }
    return key;
  }

  private static final class Node {
    private final int val;
    private Node prev, next;

    private Node(int val) {
      this.val = val;
    }
  }

}

