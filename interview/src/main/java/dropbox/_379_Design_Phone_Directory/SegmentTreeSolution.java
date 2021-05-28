package dropbox._379_Design_Phone_Directory;

import java.util.BitSet;

/**
 * @author jacka
 * @version 1.0 on 5/27/2021
 */
public final class SegmentTreeSolution implements Solution {
  private final int maxId;
  private final BitSet bitSet;

  public SegmentTreeSolution(final int maxId) {
    this.maxId = maxId;
    bitSet = new BitSet(maxId * 2 - 1);
  }

  public int get() {
    int index = 0;
    if (bitSet.get(index)) return -1;
    while (index < maxId - 1) {
      if (!bitSet.get(index * 2 + 1)) {
        index = index * 2 + 1;
      } else if (!bitSet.get(index * 2 + 2)) {
        index = index * 2 + 2;
      } else {
        return -1;
      }
    }
    bitSet.set(index);
    setTree(index);
    return index - maxId + 1;
  }

  private void setTree(int index) {
    while (index > 0) {
      final int p = (index - 1) / 2;
      if (index % 2 == 1) { // left child
        if (bitSet.get(index) && bitSet.get(index + 1)) {
          bitSet.set(p);
        } else {
          bitSet.clear(p);
        }
      } else {
        if (bitSet.get(index) && bitSet.get(index - 1)) {
          bitSet.set(p);
        } else {
          bitSet.clear(p);
        }
      }
      index = p;
    }
  }

  public boolean check(int number) {
    if (number < 0 || number >= maxId) return false;
    return !bitSet.get(number + maxId - 1);
  }

  public void release(int number) {
    if (number < 0 || number >= maxId) return;
    if (bitSet.get(number + maxId - 1)) {
      bitSet.clear(number + maxId - 1);
      setTree(number);
    }
  }
}
