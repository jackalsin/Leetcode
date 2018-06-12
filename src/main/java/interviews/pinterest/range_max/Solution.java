package interviews.pinterest.range_max;

import java.util.Arrays;

public class Solution {
  private final SegmentTree tree;
  private final int[] nums;

  public Solution(final int[] nums) {
    tree = new SegmentTree(nums);
    this.nums = nums;
  }

  public int query(int start, int end) {
    return tree.query(start, end, 0, nums.length - 1, 0);
  }

  private static final class SegmentTree {
    private final int[] st;

    public SegmentTree(int[] nums) {
      int n = nums.length, h = (int) Math.ceil(Math.log(n) / Math.log(2));
      st = new int[2 * (2 << n) + 1];
      Arrays.fill(st, Integer.MIN_VALUE);

      for (int i = 0; i < nums.length; i++) {
        update(0, nums.length - 1, 0, i, nums[i]);
      }

    }

    private void update(int ss, int se, int sc, int i, int num) {
      if (ss <= i && i <= se) {
        st[sc] = Math.max(num, st[sc]);
        if (ss == se) {
          return;
        }

        final int mid = (se - ss) / 2 + ss;
        update(ss, mid, 2 * sc + 1, i, num);
        update(mid + 1, se, 2 * sc + 2, i, num);
      }
    }

    private int query(int qs, int qe, int ss, int se, int sc) {
      if (qe < ss || qs > se) {
        return Integer.MIN_VALUE;
      }

      if (qs <= ss && se <= qe) {
        return st[sc];
      }

      final int mid = (se - ss) / 2 + ss,
          left = query(qs, qe, ss, mid, sc * 2 + 1),
          right = query(qs, qe, mid + 1, se, sc * 2 + 2);
      return Math.max(left, right);
    }
  }
}
