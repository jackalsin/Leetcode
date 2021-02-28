package _1451_1500._1470_Shuffle_the_Array;

/**
 * @author jacka
 * @version 1.0 on 2/28/2021
 */
public final class SolutionI implements Solution {
  private static final int N = 10, MASK = 0b11_1111_1111;

  public int[] shuffle(int[] nums, int n) {
    for (int i = 0, j = n; i < n; ++i, ++j) {
      nums[i] = (nums[i] << N) | nums[j];
    }

    for (int i = 2 * n - 2, j = n - 1; i >= 0; i -= 2, --j) {
      final int leftVal = (nums[j] >> N) & MASK,
          rightVal = nums[j] & MASK;
      nums[i] = leftVal;
      nums[i + 1] = rightVal;
    }
    return nums;
  }
}
