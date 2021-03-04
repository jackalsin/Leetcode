package apple._307_Range_Sum_Query_Mutable;

/**
 * @author jacka
 * @version 1.0 on 3/4/2021
 */
public final class SegmentTreeArraySolution implements NumArray {
  private final int[] st;
  private final int[] nums;

  public SegmentTreeArraySolution(final int[] nums) {
    final int leaves = nums.length, height = (int) Math.ceil(Math.log(leaves) / Math.log(2));
    st = new int[2 * (2 << height) + 1];
    this.nums = nums;
    for (int i = 0; i < nums.length; ++i) {
      update(0, nums.length - 1, i, 0, nums[i]);
    }
  }

  public void update(int index, int val) {
    update(0, nums.length - 1, index, 0, val - nums[index]);
    nums[index] = val;
  }

  private void update(final int ss, final int se, final int i, final int segmentCur, final int diff) {
    if (i > se || i < ss || ss > se) {
      return;
    }
    st[segmentCur] += diff;
    if (ss == se) {
      return;
    }
    final int mid = ss + (se - ss) / 2;
    update(ss, mid, i, segmentCur * 2 + 1, diff);
    update(mid + 1, se, i, segmentCur * 2 + 2, diff);
  }

  public int sumRange(int qs, int qe) {
    return sumRange(qs, qe, 0, nums.length - 1, 0);
  }

  private int sumRange(final int qs, final int qe, final int ss, final int se, final int segmentCur) {
    if (ss > qe || se < qs || ss > se) {
      return 0;
    }
    if (qs <= ss && se <= qe) {
      return st[segmentCur];
    }
    final int mid = ss + (se - ss) / 2;
    return sumRange(qs, qe, ss, mid, 2 * segmentCur + 1)
        + sumRange(qs, qe, mid + 1, se, 2 * segmentCur + 2);
  }
}
