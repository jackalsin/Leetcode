package _351_400._379_Design_Phone_Directory;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class PhoneDirectory {

  private final Set<Integer> available;
  private final Deque<Integer> released;
  private final int maxNumbers;
  private int size;
  private int oneTimeTailExclusive;

  /**
   * Initialize your data structure here
   *
   * @param maxNumbers - The maximum numbers that can be stored in the phone directory.
   */
  public PhoneDirectory(int maxNumbers) {
    this.maxNumbers = maxNumbers;
    available = new HashSet<>();
    released = new ArrayDeque<>();
  }

  /**
   * Provide a number which is not assigned to anyone.
   *
   * @return - Return an available number. Return -1 if none is available.
   */
  public int get() {
    int result = -1;
    if (size == maxNumbers) {
      return result;
    }
    if (oneTimeTailExclusive < maxNumbers) {
      result = oneTimeTailExclusive++;
    } else {
      result = released.pollFirst();
    }
    available.remove(result);
    size++;
    return result;
  }

  /**
   * Check if a number is available or not.
   */
  public boolean check(int number) {
    if (oneTimeTailExclusive <= number) return true;
    return available.contains(number);
  }

  /**
   * Recycle or release a number.
   */
  public void release(int number) {
    if (number < maxNumbers && !check(number)) {
      available.add(number);
      released.add(number);
      size--;
    }
  }
}
