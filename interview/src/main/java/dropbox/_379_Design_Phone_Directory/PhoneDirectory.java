package dropbox._379_Design_Phone_Directory;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 5/23/2021
 */
public final class PhoneDirectory implements Solution {
  private final int maxNumber;
  private int next = 0;
  private final Set<Integer> releasedSet = new HashSet<>();
  private final Queue<Integer> releasedQueue = new ArrayDeque<>();

  /**
   * Initialize your data structure here
   *
   * @param maxNumbers - The maximum numbers that can be stored in the phone directory.
   */
  public PhoneDirectory(int maxNumbers) {
    this.maxNumber = maxNumbers;
  }

  /**
   * Provide a number which is not assigned to anyone.
   *
   * @return - Return an available number. Return -1 if none is available.
   */
  public int get() {
    if (releasedSet.size() > 0) {
      final int toRemove = releasedQueue.remove();
      releasedSet.remove(toRemove);
      return toRemove;
    }
    if (next >= maxNumber) return -1;
    return next++;
  }

  /**
   * Check if a number is available or not.
   */
  public boolean check(int number) {
    return number <= maxNumber && (number >= next || releasedSet.contains(number));
  }

  /**
   * Recycle or release a number.
   */
  public void release(int number) {
    if (check(number)) return;
    releasedSet.add(number);
    releasedQueue.add(number);
  }
}
