package interviews.linkedin._716_Max_Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public final class MaxStackIII implements MaxStack {
  private final Node head = new Node(0), tail = new Node(Integer.MAX_VALUE);
  private final TreeMap<Integer, List<Node>> map = new TreeMap<>();

  {
    head.next = tail;
    tail.prev = head;
  }

  public void push(int x) {
    final Node newNode = new Node(x);
    map.computeIfAbsent(x, a -> new ArrayList<>()).add(newNode);
    insertToHead(newNode);
  }

  private void insertToHead(final Node newNode) {
    final Node prev = head, next = head.next;
    prev.next = newNode;
    newNode.prev = prev;

    newNode.next = next;
    next.prev = newNode;
  }


  public int pop() {
    final Node toRemove = head.next;
    removeFromDoubleLinkedList(toRemove);
    final int key = toRemove.key;
    final List<Node> curList = map.get(key);
    if (curList.size() == 1) {
      map.remove(key);
    } else {
      curList.remove(curList.size() - 1);
    }

    return toRemove.key;
  }

  private static void removeFromDoubleLinkedList(Node toRemove) {
    final Node prev = toRemove.prev, next = toRemove.next;
    prev.next = next;
    next.prev = prev;
  }


  public int top() {
    return head.next.key;
  }


  public int peekMax() {
    final List<Node> curList = map.lastEntry().getValue();
    return curList.get(curList.size() - 1).key;
  }


  public int popMax() {
    final List<Node> curList = map.lastEntry().getValue();
    final Node toRemove = curList.get(curList.size() - 1);
    removeFromDoubleLinkedList(toRemove);
    if (curList.size() == 1) {
      map.remove(toRemove.key);
    } else {
      curList.remove(curList.size() - 1);
    }
    return toRemove.key;
  }

  private static final class Node {
    private final int key;

    private Node prev, next;

    private Node(int key) {
      this.key = key;
    }
  }
}

