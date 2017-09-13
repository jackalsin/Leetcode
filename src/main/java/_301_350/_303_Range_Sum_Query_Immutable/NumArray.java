package _301_350._303_Range_Sum_Query_Immutable;

/**
 * @author jacka
 * @version 1.0 on 9/12/2017.
 */
public class NumArray {
  private final int[] sum;
  public NumArray(int[] nums) {
    if (nums == null) throw new NullPointerException();
    sum = new int[nums.length];
    for (int i = 0; i < nums.length; ++i) {
      sum[i] += (i == 0 ? 0 : sum[i - 1]) + nums[i];
    }
  }

  public int sumRange(int i, int j) {

    return sum[j] - (i == 0 ? 0 : sum[i - 1]);
  }
}
