package interviews.linkedin._225_Implement_Stack_using_Queues;

import java.util.ArrayDeque;
import java.util.Queue;

public final class PushONPopO1 implements MyStack {

  private final Queue<Integer> q1 = new ArrayDeque<>();

  @Override
  public void push(int x) {
    final int size = q1.size();
    q1.add(x);
    for (int i = 0; i < size; ++i) {
      q1.add(q1.remove());
    }
  }

  @Override
  public int pop() {
    return q1.remove();
  }

  @Override
  public int top() {
    return q1.peek();
  }

  @Override
  public boolean empty() {
    return q1.isEmpty();
  }
}
