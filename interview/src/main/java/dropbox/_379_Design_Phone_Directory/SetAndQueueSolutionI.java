package dropbox._379_Design_Phone_Directory;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 6/6/2021
 */
public final class SetAndQueueSolutionI implements Solution {
  private final int maxCapacity;
  private final Queue<Integer> q = new ArrayDeque<>();
  private final Set<Integer> released = new HashSet<>();
  private int next = 0;

  public SetAndQueueSolutionI(final int maxCapcity) {
    this.maxCapacity = maxCapcity;
  }

  public int get() {
    if (!q.isEmpty()) {
      final int toRemove = q.remove();
      released.remove(toRemove);
      return toRemove;
    }
    if (next >= maxCapacity) return -1;
    return next++;
  }


  public boolean check(int n) {
    if (n < 0 || n >= maxCapacity) return false;
    if (released.contains(n)) return true;
    return n >= next;
  }


  public void release(int number) {
    if (released.add(number)) {
      q.add(number);
    }
  }
}
