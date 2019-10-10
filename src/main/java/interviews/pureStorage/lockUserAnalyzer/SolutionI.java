package interviews.pureStorage.lockUserAnalyzer;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 10/9/2019
 */
public final class SolutionI implements Solution {
  public static final String ACQUIRE = "ACQUIRE",
      RELEASE = "RELEASE";

  public int isValidLockSeq(String[] seq) {
    if (seq == null || seq.length == 0) {
      return 0;
    }
    final Deque<Integer> stack = new ArrayDeque<>();
    final Set<Integer> acquiredLocks = new HashSet<>();
    for (int i = 0; i < seq.length; i++) {
      String s = seq[i];
      final String[] items = s.split(" ");
      final int lock = Integer.parseInt(items[1]);
      if (ACQUIRE.equals(items[0])) {
        if (acquiredLocks.contains(lock)) {
          return i + 1;
        }
        acquiredLocks.add(lock);
        stack.push(lock);
      } else {
        if (stack.isEmpty() || !stack.peek().equals(lock) || !acquiredLocks.contains(lock)) {
          return i + 1;
        }
        stack.pop();
        acquiredLocks.remove(lock);
      }
    }
    return stack.isEmpty() ? 0 : seq.length + 1;
  }
}
