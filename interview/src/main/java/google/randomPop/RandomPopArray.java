package google.randomPop;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Random;

/**
 * @author jacka
 * @version 1.0 on 1/12/2018.
 */
public final class RandomPopArray {
  private final Deque<Integer> deque;
  private final Random random = new Random();

  public RandomPopArray(int[] nums) {
    this.deque = new ArrayDeque<>();
    for (int num : nums) {
      deque.addLast(num);
    }
  }

  public boolean isEmpty() {
    return deque.isEmpty();
  }

  public int pop() {
    int n = random.nextInt(1);
    if (n == 0) {
      return deque.removeLast();
    } else {
      return deque.removeFirst();
    }
  }

  public int size() {
    return deque.size();
  }
}
