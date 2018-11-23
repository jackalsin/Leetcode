package _0301_0350._307_Range_Sum_Query_Mutable;

/**
 * @author jacka
 * @version 1.0 on 9/13/2017.
 */
public final class NumArray {
  private final int[] segmentTrees;
  private final int n;
  private final int[] values;

  public NumArray(int[] nums) {
    n = nums.length;
    this.values = nums;
    final int height = (int) Math.ceil(Math.log(values.length) / Math.log(2));
    this.segmentTrees = new int[2 * (2 << height) + 1];
    if (n == 0) return;
    constructHelper(values, 0, values.length - 1, 0);
  }

  public int sumRange(int i, int j) {
    return getSumRange(i, j, 0, n - 1, 0);
  }

  public void update(int i, int val) {
    updateHelper(0, n - 1, i, 0, val - values[i]);
    values[i] = val;
  }

  private int getSumRange(final int queryStart, final int queryEnd, int segmentStart, int segmentEnd,
                          int segmentCur) {
    assert segmentStart <= segmentEnd;
    if (queryStart <= segmentStart && segmentEnd <= queryEnd) {
      return segmentTrees[segmentCur];
    } else if (queryStart > segmentEnd || queryEnd < segmentStart) {
      return 0;
    } else {
      int mid = (segmentEnd -segmentStart) / 2 + segmentStart;
      return getSumRange(queryStart, queryEnd, segmentStart, mid, 2 * segmentCur + 1)
          + getSumRange(queryStart, queryEnd, mid + 1, segmentEnd, 2 * segmentCur + 2);
    }

  }

  private void updateHelper(final int segmentStart, final int segmentEnd, final int i,
                            int segmentCur, final int diff) {
    if (i >= segmentStart && i <= segmentEnd) {
      segmentTrees[segmentCur] += diff;
      if(segmentStart != segmentEnd) {
        int mid = (segmentEnd - segmentStart) / 2 + segmentStart;
        updateHelper(segmentStart, mid, i, 2 * segmentCur + 1, diff);
        updateHelper(mid + 1, segmentEnd, i, 2 * segmentCur + 2, diff);
      }
    }
  }

  /**
   * To construct
   * @param values  leaf values
   * @param valStart  start index of leaf values, inclusive
   * @param valEnd    end index of leaf values, inclusive
   * @param segmentCur  segmentTree array index
   * @return  sum of the array range [start, end
   */
  private int constructHelper(int[] values, int valStart, int valEnd, int segmentCur) {
    if (valStart == valEnd) {
      segmentTrees[segmentCur] = values[valStart];
    } else {
      int mid = (valEnd - valStart) / 2 + valStart;
      segmentTrees[segmentCur] = constructHelper(values, valStart, mid, 2 * segmentCur + 1) +
          constructHelper(values, mid + 1, valEnd, 2 * segmentCur + 2);
    }
    return segmentTrees[segmentCur];
  }
}
