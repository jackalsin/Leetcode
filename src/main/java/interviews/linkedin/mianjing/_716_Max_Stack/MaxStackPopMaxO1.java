package interviews.linkedin.mianjing._716_Max_Stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.TreeMap;

public final class MaxStackPopMaxO1 implements MaxStack {
  private final Node head, tail;
  private final TreeMap<Integer, Deque<Node>> valToStacks = new TreeMap<>();

  public MaxStackPopMaxO1() {
    head = new Node(0);
    tail = new Node(Integer.MAX_VALUE);
    head.next = tail;
    tail.prev = head;
  }

  @Override
  public void push(int x) {
    final Node toInsert = new Node(x);
    valToStacks.computeIfAbsent(x, k -> new ArrayDeque<>()).push(toInsert);
    insertToTail(toInsert);
  }

  private void insertToTail(Node toInsert) {
    final Node prev = tail.prev, next = tail;
    prev.next = toInsert;
    toInsert.prev = prev;

    next.prev = toInsert;
    toInsert.next = next;
  }

  @Override
  public int pop() {
    final Node toRemove = tail.prev;
    removeFromDoubleLinkedList(toRemove);
    final int key = toRemove.val;
    final Deque<Node> stack = valToStacks.get(key);
    stack.pop();
    if (stack.isEmpty()) {
      valToStacks.remove(key);
    }
    return key;
  }

  private void removeFromDoubleLinkedList(Node toRemove) {
    final Node prev = toRemove.prev, next = toRemove.next;
    prev.next = next;
    next.prev = prev;
  }

  @Override
  public int top() {
    return tail.prev.val;
  }

  @Override
  public int peekMax() {
    return valToStacks.lastEntry().getValue().peek().val;
  }

  @Override
  public int popMax() {
    final Deque<Node> toRemoveStack = valToStacks.lastEntry().getValue();
    final Node toRemove = toRemoveStack.pop();
    if (toRemoveStack.isEmpty()) {
      valToStacks.remove(toRemove.val);
    }
    removeFromDoubleLinkedList(toRemove);
    return toRemove.val;
  }

  private static final class Node {
    private final int val;
    private Node prev, next;

    Node(final int val) {
      this.val = val;
    }
  }

}
