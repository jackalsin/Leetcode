package interviews.linkedin._716_Max_Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public final class MaxStackV implements MaxStack {
  private final TreeMap<Integer, List<Node>> map = new TreeMap<>();

  private final Node head = new Node(0), tail = new Node(0);

  {
    head.next = tail;
    tail.prev = head;
  }

  public void push(int x) {
    final Node newNode = new Node(x);
    insertAfter(tail.prev, newNode);
    map.computeIfAbsent(x, k -> new ArrayList<>()).add(newNode);
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
    final List<Node> curList = map.get(toRemove.key);
    if (curList.size() == 1) {
      map.remove(toRemove.key);
    } else {
      curList.remove(curList.size() - 1);
    }
    return toRemove.key;
  }

  private static void removeFromDoubleLinkedList(final Node cur) {
    final Node prev = cur.prev, next = cur.next;

    prev.next = next;
    next.prev = prev;
  }


  public int top() {
    return tail.prev.key;
  }


  public int peekMax() {
    return map.lastEntry().getKey();
  }


  public int popMax() {
    final Map.Entry<Integer, List<Node>> entry = map.lastEntry();
    final int key = entry.getKey();
    final List<Node> curList = entry.getValue();
    removeFromDoubleLinkedList(curList.get(curList.size() - 1));
    if (curList.size() == 1) {
      map.remove(key);
    } else {
      curList.remove(curList.size() - 1);
    }
    return key;
  }

  private static final class Node {
    private final int key;
    private Node prev, next;

    private Node(int key) {
      this.key = key;
    }
  }
}

