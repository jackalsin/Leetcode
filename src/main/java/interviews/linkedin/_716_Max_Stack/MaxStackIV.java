package interviews.linkedin._716_Max_Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public final class MaxStackIV implements MaxStack {
  private final Node head = new Node(0), tail = new Node(0);
  private final TreeMap<Integer, List<Node>> treeMap = new TreeMap<>();

  {
    head.next = tail;
    tail.prev = head;
  }

  public void push(int x) {
    final Node newNode = new Node(x);
    insertAfter(tail.prev, newNode);
    treeMap.computeIfAbsent(x, k -> new ArrayList<>()).add(newNode);
  }

  private void insertAfter(final Node prev, final Node cur) {
    final Node next = prev.next;
    prev.next = cur;
    cur.prev = prev;

    next.prev = cur;
    cur.next = next;
  }


  public int pop() {
    final Node toRemove = tail.prev;
    removeFromDoubleLinkedList(toRemove);
    final List<Node> curList = treeMap.get(toRemove.val);
    if (curList.size() == 1) {
      treeMap.remove(toRemove.val);
    } else {
      curList.remove(curList.size() - 1);
    }

    return toRemove.val;
  }

  private void removeFromDoubleLinkedList(final Node toRemove) {
    final Node prev = toRemove.prev, next = toRemove.next;
    prev.next = next;
    next.prev = prev;
  }


  public int top() {
    return tail.prev.val;
  }


  public int peekMax() {
    return treeMap.lastEntry().getKey();
  }


  public int popMax() {
    final Map.Entry<Integer, List<Node>> entry = treeMap.lastEntry();
    final List<Node> curList = entry.getValue();
    final Node toRemove = curList.get(curList.size() - 1);
    if (curList.size() == 1) {
      treeMap.remove(toRemove.val);
    } else {
      curList.remove(curList.size() - 1);
    }
    removeFromDoubleLinkedList(toRemove);
    return entry.getKey();
  }

  private static final class Node {
    private final int val;

    private Node prev, next;

    private Node(final int val) {
      this.val = val;
    }
  }
}

