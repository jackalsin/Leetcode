package _701_750._716_Max_Stack;

import java.util.LinkedList;
import java.util.TreeMap;

/**
 * @author zhiwei.xin
 * @version 1.0 on 9/4/18
 */
public final class MaxStackPopMaxO1 implements MaxStack {
  private final Node head = new Node(0), tail = new Node(Integer.MAX_VALUE);
  private final TreeMap<Integer, LinkedList<Node>> map = new TreeMap<>();

  public MaxStackPopMaxO1() {
    head.next = tail;
    tail.prev = head;
  }

  @Override
  public void push(int x) {
    final Node newNode = new Node(x);
    insert(newNode);

    map.computeIfAbsent(x, k -> new LinkedList<>()).add(newNode);

  }

  private void insert(Node newNode) {
    final Node prev = tail.prev, next = tail;
    prev.next = newNode;
    newNode.prev = prev;

    next.prev = newNode;
    newNode.next = next;
  }

  @Override

  public int pop() {
    final Node newNode = tail.prev;
    delete(newNode);
    final int key = newNode.val;

    map.get(key).removeLast();
    if (map.get(key).isEmpty()) {
      map.remove(key);
    }
    return key;
  }

  private void delete(Node node) {
    final Node prev = node.prev, next = node.next;

    prev.next = next;
    next.prev = prev;
  }

  @Override
  public int top() {
    return tail.prev.val;
  }

  @Override
  public int peekMax() {
    return map.lastEntry().getValue().getLast().val;
  }

  @Override
  public int popMax() {
    final Node toRemove = map.lastEntry().getValue().removeLast();
    if (map.lastEntry().getValue().isEmpty()) {
      map.remove(toRemove.val);
    }
    delete(toRemove);
    return toRemove.val;
  }

  private static final class Node {
    private final int val;
    private Node prev, next;

    private Node(final int val) {
      this.val = val;
    }
  }
}
