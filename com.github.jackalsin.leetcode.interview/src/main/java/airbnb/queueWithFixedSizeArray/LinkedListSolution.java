package airbnb.queueWithFixedSizeArray;

/**
 * @author jacka
 * @version 1.0 on 2/26/2019.
 */
public final class LinkedListSolution implements MyQueue {
  private static final int N = 10;

  private Node head, tail;

  public LinkedListSolution() {
    head = tail = new Node();
  }

  public void push(int x) {
    if (tail.end == N) {
      tail.next = new Node();
      tail = tail.next;
    }
    tail.values[tail.end++] = x;
  }


  public int pop() {
    if (head.start == N) {
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
    private Node next;
    private int start = 0, end = 0;
    private final int[] values = new int[N];
  }
}
