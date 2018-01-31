package interviews.google._307_Range_Sum_Query_Mutable;

/**
 * @author jacka
 * @version 1.0 on 1/30/2018.
 */
public final class NumArray {
  private final int n;
  private final int[] tree;
  private final int[] num;

  public NumArray(int[] nums) {
    n = nums.length;
    this.num = nums;
    tree = new int[nums.length + 1];
    for (int i = 0; i < n; i++) {
      updateByDiff(i, nums[i]);
    }

//    System.out.println(Arrays.toString(tree));
  }

  public void update(int i, int val) {
    updateByDiff(i, val - num[i]);
    num[i] = val;
  }

  void updateByDiff(int i, int diff) {
    ++i;
    while (i <= n) {
      tree[i] += diff;
      i += (i & -i);
    }
  }

  public int sumRange(int i, int j) {
    return getPreSum(j) - getPreSum(i - 1);
  }

  public int getPreSum(int i) {
    ++i;
    int sum = 0;
    while (i > 0) {
      sum += tree[i];
      i -= (i & -i);
    }
    return sum;
  }
}
