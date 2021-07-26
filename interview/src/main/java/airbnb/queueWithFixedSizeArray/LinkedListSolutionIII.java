package airbnb.queueWithFixedSizeArray;

import java.util.LinkedList;

public final class LinkedListSolutionIII implements MyQueue {
  private static final int N = 5;
  private final LinkedList<int[]> lists = new LinkedList<>();
  private int start = 0, end = 0;

  @Override
  public void push(int x) {
    if (lists.isEmpty() || end == N) {
      lists.add(new int[N]);
      end = 0;
    }
    lists.peekLast()[end++] = x;
  }

  @Override
  public int pop() {
    if (empty()) return -1;
    final int res = lists.peekFirst()[start++];
    if (start == N) {
      lists.removeFirst();
      start = 0;
    }
    return res;
  }

  @Override
  public int peek() {
    if (empty()) return -1;
    return lists.peekFirst()[start];
  }

  @Override
  public boolean empty() {
    return lists.isEmpty() || (lists.size() == 1 && start == end);
  }

}
