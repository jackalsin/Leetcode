package apple.O1List;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * @author jacka
 * @version 1.0 on 2/20/2021
 */
public final class O1ListImpl<E> implements O1List<E> {
  private final Node<E> head = new Node<>(null),
      tail = new Node<>(null);

  {
    head.next = tail;
    tail.prev = head;
  }

  private final Map<E, Queue<Node<E>>> map = new HashMap<>();

  @Override
  public void addLast(E e) {
    final Node<E> cur = new Node<>(e);
    append(tail.prev, cur);
    map.computeIfAbsent(e, k -> new ArrayDeque<>()).add(cur);
  }

  private static <E> void append(final Node<E> prev, final Node<E> cur) {
    final Node<E> next = prev.next;
    prev.next = cur;
    cur.prev = prev;

    cur.next = next;
    next.prev = cur;
  }

  @Override
  public void delete(E e) {
    assert map.containsKey(e);
    final Queue<Node<E>> stack = map.get(e);
    assert !stack.isEmpty();
    final Node<E> toRemove = stack.remove();
    if (stack.isEmpty()) {
      map.remove(e);
    }
    remove(toRemove);
  }

  private static <E> void remove(final Node<E> cur) {
    final Node<E> prev = cur.prev, next = cur.next;
    prev.next = next;
    next.prev = prev;
  }

  @Override
  public boolean contains(E e) {
    return map.containsKey(e);
  }

  @Override
  public List<E> toList() {
    final List<E> result = new ArrayList<>();
    Node<E> cur = head.next;
    while (cur != tail) {
      result.add(cur.e);
      cur = cur.next;
    }
    return result;
  }

  @Override
  public void printList() {
    System.out.println(toString());
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder();
    Node<E> cur = head.next;
    while (cur != tail) {
      sb.append(",").append(cur.e);
      cur = cur.next;
    }
    return sb.length() == 0 ? "" :
        sb.substring(1);
  }

  private static final class Node<E> {

    private Node<E> prev, next;
    private final E e;

    private Node(E e) {
      this.e = e;
    }
  }
}
