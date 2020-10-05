package uber._041_First_Missing_Positive;

/**
 * @author jacka
 * @version 1.0 on 3/13/2018.
 */
public class Solution {
  /**
   * Time Complexity: O(N)
   */
  public int firstMissingPositive(int[] nums) {
    // after this, [0, k) should have all the positive
    int k = partition(nums) + 1;

    // flip nums[nums[j] - 1] from 0 to k(exclusive) to negative
    for (int i = 0; i < k; i++) {
      assert nums[i] != Integer.MIN_VALUE;
      final int tmp = Math.abs(nums[i]);
      if (tmp <= k) {
//        nums[tmp - 1] = -nums[tmp - 1]; // This is wrong for [1, 1]. It will flip twice. Then it will become positive
        nums[tmp - 1] = -Math.abs(nums[tmp - 1]);
      }
    }

//    System.out.println(Arrays.toString(nums));
    for (int i = 0; i < k; i++) {
      if (nums[i] > 0) {
        return i + 1;
      }
    }

    return k + 1;
  }

  /**
   * Partition the array, the first k will be all positive.
   *
   * @return k
   */
  private int partition(int[] nums) {
    int p = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] > 0) {
        swap(nums, p, i);
        p++;
      }
    }
    return p - 1;
  }

  private void swap(int[] nums, int i, int j) {
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }
}
