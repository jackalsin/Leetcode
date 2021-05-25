package _0351_0400._379_Design_Phone_Directory;

import java.util.BitSet;

/**
 * @author jacka
 * @version 1.0 on 5/24/2021
 */
public final class BitSetSolution implements PhoneDirectory {
  private final int maxNumberExclusive;
  private final BitSet released;
  private int next = 0;

  public BitSetSolution(final int maxNumber) {
    this.maxNumberExclusive = maxNumber;
    released = new BitSet(maxNumber);
  }

  public int get() {
    if (!released.isEmpty()) {
      final int val = released.nextSetBit(0);
      released.clear(val);
      return val;
    }
    if (next >= maxNumberExclusive) return -1;
    return next++;
  }

  public boolean check(int number) {
    return next <= number && number < maxNumberExclusive || released.get(number);
  }

  public void release(int number) {
    if (number < next) {
      released.set(number);
    }
  }
}
