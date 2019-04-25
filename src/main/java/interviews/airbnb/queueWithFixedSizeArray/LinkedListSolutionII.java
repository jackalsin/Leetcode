package interviews.airbnb.queueWithFixedSizeArray;

/**
 * @author jacka
 * @version 1.0 on 2/26/2019.
 */
public final class LinkedListSolutionII implements MyQueue {
  private static final int SIZE = 10;
  private Node head, tail;

  public LinkedListSolutionII() {
    head = tail = new Node();
  }

  public void push(int x) {
    if (tail.end == SIZE) {
      tail.next = new Node();
      tail = tail.next;
    }
    tail.values[tail.end++] = x;
  }

  public int pop() {
    assert !empty();
    if (head.start == SIZE) {
      head = head.next;
    }
    return head.values[head.start++];
  }

  public int peek() {
    assert !empty();
    return head.values[head.start];
  }

  public boolean empty() {
    return head == tail && head.start == head.end;
  }

  private static final class Node {
    private final int[] values = new int[SIZE];
    private int start = 0, end = 0;
    private Node next;
  }
}
