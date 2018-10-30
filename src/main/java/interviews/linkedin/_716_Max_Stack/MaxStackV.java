package interviews.linkedin._716_Max_Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public final class MaxStackV implements MaxStack {
  private final TreeMap<Integer, List<Node>> valToNodes = new TreeMap<>();
  private final Node head = new Node(0), tail = new Node(0);

  {
    head.next = tail;
    tail.prev = head;
  }

  public void push(int x) {
    final Node newNode = new Node(x);
    valToNodes.computeIfAbsent(x, key -> new ArrayList<>()).add(newNode);
    insertAfter(tail.prev, newNode);
  }

  private static void insertAfter(final Node prev, Node cur) {
    final Node next = prev.next;
    prev.next = cur;
    cur.prev = prev;

    next.prev = cur;
    cur.next = next;
  }


  public int pop() {
    final Node toRemove = tail.prev;
    removeFromDoubleLinkedList(toRemove);
    final int key = toRemove.key;
    final List<Node> curList = valToNodes.get(key);
    if (curList.size() == 1) {
      valToNodes.remove(key);
    } else {
      curList.remove(curList.size() - 1);
    }
    return key;
  }

  private void removeFromDoubleLinkedList(final Node cur) {
    final Node prev = cur.prev, next = cur.next;
    prev.next = next;
    next.prev = prev;
  }


  public int top() {
    return tail.prev.key;
  }


  public int peekMax() {
    final List<Node> curList = valToNodes.lastEntry().getValue();

    return curList.get(0).key;
  }


  public int popMax() {
    final List<Node> curList = valToNodes.lastEntry().getValue();
    final int key = curList.get(0).key;
    final Node toRemove = curList.remove(curList.size() - 1);
    removeFromDoubleLinkedList(toRemove);
    if (curList.isEmpty()) {
      valToNodes.remove(key);
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

