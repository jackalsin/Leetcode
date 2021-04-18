package uber.codeSignal.binaryAdd;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author jacka
 * @version 1.0 on 4/17/2021
 */
public final class BinaryAdderStack implements BinaryAdder {
  private final int len;

  private final Deque<Integer> stack = new ArrayDeque<>();

  public BinaryAdderStack(final String num) {
    if (num == null) throw new NullPointerException();
    if (num.isEmpty()) throw new IllegalArgumentException();
    len = num.length();
    for (int i = 0; i < len; ++i) {
      if (num.charAt(i) == '1') stack.push(i);
    }
  }

  public int oneCount() {
    return stack.size();
  }

  public void addOne() {
    int cur = len - 1;
    while (!stack.isEmpty() && stack.peek() == cur) {
      stack.pop();
      cur--;
    }
    stack.push(cur);
  }
}
