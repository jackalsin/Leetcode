package interviews.linkedin._716_Max_Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public final class MaxStackI implements MaxStack {
  // head is the stack low
  private final Node head = new Node(-1), tail = new Node(-1);
  private final TreeMap<Integer, List<Node>> maxStack = new TreeMap<>(
      (x, y) -> Integer.compare(y, x)
  );


  /**
   * initialize your data structure here.
   */
  public MaxStackI() {
    head.next = tail;
    tail.prev = head;
  }

  public void push(int x) {
    final Node newNode = new Node(x);
    insertAfter(tail.prev, newNode);
    final List<Node> curList = maxStack.getOrDefault(x, new ArrayList<>());
    curList.add(newNode);
    maxStack.put(x, curList);
  }


  public int pop() {
    final Node toRemove = tail.prev;
    removeFromDoubleLinkedList(toRemove);

    final List<Node> curList = maxStack.get(toRemove.val);
    curList.remove(curList.size() - 1);
    if (curList.isEmpty()) {
      maxStack.remove(toRemove.val);
    }
    return toRemove.val;
  }

  public int top() {
    return tail.prev.val;
  }

  public int peekMax() {
    return maxStack.firstKey();
  }

  public int popMax() {
    final Map.Entry<Integer, List<Node>> entry = maxStack.firstEntry();

    final List<Node> curList = entry.getValue();
    removeFromDoubleLinkedList(curList.get(curList.size() - 1));
    curList.remove(curList.size() - 1);

    if (curList.isEmpty()) {
      maxStack.remove(entry.getKey());
    }

    return entry.getKey();
  }


  private void removeFromDoubleLinkedList(Node toRemove) {
    final Node prev = toRemove.prev, next = toRemove.next;
    prev.next = next;
    next.prev = prev;
  }


  private void insertAfter(final Node prev, Node newNode) {
    final Node after = prev.next;
    prev.next = newNode;
    newNode.prev = prev;

    newNode.next = after;
    after.prev = newNode;
  }

  private static final class Node {
    private final int val;
    private Node prev, next;

    private Node(int val) {
      this.val = val;
    }
  }
}

