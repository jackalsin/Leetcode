package interviews.google._307_Range_Sum_Query_Mutable;

/**
 * @author jacka
 * @version 1.0 on 1/30/2018.
 */
public class NumArray {
  private final int n;
  private final int[] tree;

  public NumArray(int[] nums) {
    n = nums.length;
    tree = new int[nums.length + 1];
    for (int i = 0; i < n; i++) {
      update(i, nums[i]);
    }
  }

  public void update(int i, int val) {
    ++i;
    while (i <= n) {
      tree[i] += val;
      i += (i & -i);
    }
  }

  public int sumRange(int i, int j) {
    int sum = 0;
    ++i;
    while (i != 0) {
      sum += tree[i];
      i -= (i & -i);
    }
    return sum;
  }

  public static void main(String[] args) {
    int a = 13;
    System.out.println(Integer.toBinaryString(a));
    while (a != 0) {
      System.out.print(Integer.toBinaryString(a & -a) + " ");
      a -= (a & -a);
    }
  }
}
