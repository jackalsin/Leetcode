package interviews.facebook._307_Range_Sum_Query_Mutable;

public final class NumArray {
  private final int[] nums, tree;
  private final int n;

  public NumArray(int[] nums) {
    n = nums.length;
    this.nums = nums;
    tree = new int[n + 1];
    for (int i = 0; i < n; i++) {
      updateByDiff(i, nums[i]);
    }
  }

  public void update(int i, int val) {
    updateByDiff(i, val - nums[i]);
    nums[i] = val;
  }

  private void updateByDiff(int i, int diff) {
    ++i;
    while (i <= n) {
      tree[i] += diff;
      i += (i & (-i));
    }
  }

  public int sumRange(int i, int j) {
    return getPreSum(j) - getPreSum(i - 1);
  }

  private int getPreSum(int i) {
    ++i;
    int sum = 0;
    while (i > 0) {
      sum += tree[i];
      i -= (i & -i);
    }

    return sum;
  }
}
