package interviews.linkedin._225_Implement_Stack_using_Queues;

import java.util.ArrayDeque;
import java.util.Queue;

public final class PushO1PopON implements MyStack {
  private Queue<Integer> q1 = new ArrayDeque<>(), q2 = new ArrayDeque<>();
  private int top;

  @Override
  public void push(int x) {
    q1.add(x);
    top = x;
  }

  @Override
  public int pop() {
    while (q1.size() > 1) {
      top = q1.remove();
      q2.add(top);
    }
    final int res = q1.remove();
    final Queue<Integer> tmp = q1;
    q1 = q2;
    q2 = tmp;
    return res;
  }

  @Override
  public int top() {
    return top;
  }

  @Override
  public boolean empty() {
    return q1.isEmpty();
  }
}
