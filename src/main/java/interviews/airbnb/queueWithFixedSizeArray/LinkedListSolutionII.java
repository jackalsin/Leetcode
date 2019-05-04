package interviews.airbnb.queueWithFixedSizeArray;

/**
 * @author jacka
 * @version 1.0 on 2/26/2019.
 */
public final class LinkedListSolutionII implements MyQueue {
  private static final int SIZE = 5;
  private Node head, tail;

  public LinkedListSolutionII() {
    head = tail = new Node();
  }

  public void push(int x) {
    prune();
    tail.vals[tail.end++] = x;
  }

  public int pop() {
    prune();
    return head.vals[head.start++];
  }

  public int peek() {
    return head.vals[head.start];
  }

  public boolean empty() {
    prune();
    return head == tail && head.start == head.end;
  }

  private void prune() {
    if (head.start == SIZE) {
      if (head.next == null) {
        tail = new Node();
        head.next = tail;
      }
      head = head.next;
    }

    if (tail.end == SIZE) {
      if (tail.next == null) {
        tail.next = new Node();
      }
      tail = tail.next;
    }
    assert head.start != SIZE && tail.end != SIZE;
  }

  private static final class Node {
    private final int[] vals = new int[SIZE];
    private int start = 0, end = 0;
    private Node next;
  }
}
