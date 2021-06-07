package dropbox._379_Design_Phone_Directory;

import java.util.BitSet;

/**
 * @author jacka
 * @version 1.0 on 6/6/2021
 */
public final class SegmentTreeSolutionI implements Solution {
  private final int maxId;
  private final BitSet bitSet;

  public SegmentTreeSolutionI(final int capacity) {
    this.maxId = capacity;
    final int h = (int) (1 + Math.ceil(Math.log(maxId) / Math.log(2))),
        total = (int) Math.pow(2, h);
    bitSet = new BitSet(total);
  }

  public int get() {
    final int next = next();
    if (next != -1) set(next, true, 0, 0, maxId - 1);
    return next;
  }

  public boolean check(int number) {
    if (number < 0 || number >= maxId) return false;
    return !get(number, 0, 0, maxId - 1);
  }

  public void release(int number) {
    if (number < 0 || number >= maxId) return;
    set(number, false, 0, 0, maxId - 1);
  }

  private void set(final int i, final boolean val, final int si, final int ss, final int se) {
    assert ss <= se;
    if (ss == se) {
      bitSet.set(si, val);
      return;
    }
    final int mid = ss + (se - ss) / 2;
    if (i <= mid) {
      set(i, val, si * 2 + 1, ss, mid);
    } else {
      set(i, val, si * 2 + 2, mid + 1, se);
    }
    bitSet.set(si, bitSet.get(2 * si + 1) && bitSet.get(2 * si + 2));
  }

  private boolean get(final int i, final int si, final int ss, final int se) {
    if (ss == se) return bitSet.get(si);
    final int mid = ss + (se - ss) / 2;
    if (i <= mid) return get(i, si * 2 + 1, ss, mid);
    else return get(i, si * 2 + 2, mid + 1, se);
  }

  private int next() {
    int left = 0, right = maxId - 1, p = 0;
    if (bitSet.get(p)) return -1;
    while (left < right) {
      final int mid = left + (right - left) / 2;
      if (!bitSet.get(2 * p + 1)) {
        p = 2 * p + 1;
        right = mid;
      } else {
        assert !bitSet.get(2 * p + 2);
        left = mid + 1;
        p = 2 * p + 2;
      }
    }
    return left;
  }
}
