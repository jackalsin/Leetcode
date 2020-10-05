package airbnb.queueWithFixedSizeArray;

public final class LinkedListSolutionIII implements MyQueue {
  private static final int N = 5;
  private Node head = new Node(), tail = head;
  private int start = 0, end = 0;

  public void push(int x) {
    tail.vals[end++] = x;
    if (end == N) {
      tail.next = new Node();
      tail = tail.next;
      end = 0;
    }
  }

  public int pop() {
    final int res = head.vals[start++];
    if (start == N) {
      start = 0;
      head = head.next;
    }
    return res;
  }

  public int peek() {
    return head.vals[start];
  }

  public boolean empty() {
    return head == tail && start == end;
  }

  private static final class Node {
    private final int[] vals = new int[N];
    private Node next;
  }
}
