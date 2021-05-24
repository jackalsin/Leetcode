package _0351_0400._379_Design_Phone_Directory;

import java.util.LinkedHashSet;

/**
 * @author jacka
 * @version 1.0 on 5/23/2021
 */
public final class LinkedHashSetSolution implements PhoneDirectory {
  private final int maxNumber;
  private final LinkedHashSet<Integer> set = new LinkedHashSet<>();
  private int next = 0;

  public LinkedHashSetSolution(final int maxNumber) {
    this.maxNumber = maxNumber;
  }

  public int get() {
    if (!set.isEmpty()) {
      int res = -1;
      for (final int toRemove : set) {
        res = toRemove;
        break;
      }
      set.remove(res);
      return res;
    }
    if (next >= maxNumber) return -1;
    return next++;
  }

  public boolean check(int number) {
    return number >= 0 && number <= maxNumber && (set.contains(number) || number >= next);
  }

  public void release(int number) {
    if (number < 0 || number >= next || check(number)) return;
    set.add(number);
  }
}
