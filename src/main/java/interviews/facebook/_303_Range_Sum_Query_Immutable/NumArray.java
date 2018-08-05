package interviews.facebook._303_Range_Sum_Query_Immutable;

public class NumArray {
  private final int[] preSum;

  public NumArray(int[] nums) {
    preSum = new int[nums.length + 1];

    for (int i = 0; i < nums.length; i++) {
      preSum[i + 1] = preSum[i] + nums[i];
    }
  }

  public int sumRange(int i, int j) {
    return preSum[j + 1] - preSum[i];
  }
}
