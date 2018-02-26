package _301_350._307_Range_Sum_Query_Mutable;

import java.util.Arrays;

public class SegmentTreeArraySolution {
  private final int[] nums;
  private final int[] st;

  public SegmentTreeArraySolution(int[] nums) {
    this.nums = nums;
    final int leaves = nums.length, height = (int) Math.ceil(Math.log(leaves) / Math.log(2));
    st = new int[2 * (2 << height) + 1];
    if (leaves == 0) return;
    for (int i = 0; i < nums.length; i++) {
      updateHelper(0, nums.length - 1, i, 0, nums[i]);
    }

    System.out.println(Arrays.toString(st));
  }

  public void update(int i, int val) {
    updateHelper(0, nums.length - 1, i, 0, val - nums[i]);
    nums[i] = val;
  }

  private void updateHelper(int segmentStart, int segmentEnd, int i, int segmentCur, int diff) {
//    System.out.println("segmentStart = " + segmentStart + " segmentEnd = " + segmentEnd
//        + " i =" + i + " segmentCur = " + segmentCur + " diff" + diff);
    if (i >= segmentStart && i <= segmentEnd) {
      st[segmentCur] += diff;
      if (segmentStart == segmentEnd) return; // avoid range check
      final int mid = segmentStart + (segmentEnd - segmentStart) / 2;
      updateHelper(segmentStart, mid, i, 2 * segmentCur + 1, diff);
      updateHelper(mid + 1, segmentEnd, i, 2 * segmentCur + 2, diff);
    }
  }

  public int sumRange(int i, int j) {
    return sumRange(i, j, 0, nums.length - 1, 0);
  }

  private int sumRange(final int queryStart, final int queryEnd, final int segmentStart, final int segmentEnd, final
  int segmentCur) {
    if (queryStart > segmentEnd || queryEnd < segmentStart) {
      return 0;
    }

    if (queryStart <= segmentStart && queryEnd >= segmentEnd) {
      return st[segmentCur];
    }

    final int mid = segmentStart + (segmentEnd - segmentStart) / 2;
    return sumRange(queryStart, queryEnd, segmentStart, mid, segmentCur * 2 + 1) +
        sumRange(queryStart, queryEnd, mid + 1, segmentEnd, segmentCur * 2 + 2);
  }
}
