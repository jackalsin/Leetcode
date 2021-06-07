package _0351_0400._379_Design_Phone_Directory;

import java.util.BitSet;

/**
 * @author jacka
 * @version 1.0 on 5/26/2021
 */
public final class SegmentTreeRandomLengthSolution implements PhoneDirectory {
  private final int maxId;
  private final BitSet bitSet;

  public SegmentTreeRandomLengthSolution(final int maxID) {
    this.maxId = maxID;
    final int h = (int) (Math.ceil(Math.log(maxID) / Math.log(2)) + 1),
        total = (int) Math.pow(2, h) - 1;
    bitSet = new BitSet(total);
    //    System.out.println(parentCount + ", " + total + ", h = " + h);
  }

  public int get() {
    final int res = next();
    if (res == -1) return res;
    set(res, true, 0, 0, maxId - 1);
//    System.out.println(bitSet);
    return res;
  }

  /**
   * Set child index c to val
   */
  private void set(int c, boolean val, final int si, final int ss, final int se) {
    assert ss <= se;
    if (ss == se) {
      bitSet.set(si, val);
      return;
    }
    final int mid = ss + (se - ss) / 2;
    if (c <= mid) {
      set(c, val, 2 * si + 1, ss, mid);
    } else {
      set(c, val, 2 * si + 2, mid + 1, se);
    }
    bitSet.set(si, bitSet.get(2 * si + 1) && bitSet.get(2 * si + 2));
  }

  private int next() {
    int p = 0, left = 0, right = maxId - 1;
    // 如果maxId是1，而0被占据，则应该
    if (bitSet.get(p)) return -1;
    while (left < right) {
      final int mid = left + (right - left) / 2;
      if (!bitSet.get(2 * p + 1)) {
        p = 2 * p + 1;
        right = mid;
      } else {
        assert !bitSet.get(2 * p + 2);
        p = 2 * p + 2;
        left = mid + 1;
      }
    }
    return left;
  }

  public boolean check(int number) {
    if (number < 0 || number >= maxId) return false;
    return !get(number, 0, 0, maxId - 1);
  }

  public void release(int number) {
    if (number < 0 || number >= maxId) return;
    set(number, false, 0, 0, maxId - 1);
  }

  private boolean get(final int number, final int si, final int ss, final int se) {
    if (ss == se) {
      return bitSet.get(si);
    }
    final int mid = ss + (se - ss) / 2;
    if (number <= mid) {
      return get(number, si * 2 + 1, ss, mid);
    } else {
      return get(number, si * 2 + 2, mid + 1, se);
    }
  }
}
