package _451_500._457_Circular_Array_Loop;

public final class SpaceO1Solution implements Solution {
  /**
   * 10 / 10 test cases passed.
   * Status: Accepted
   * Runtime: 1 ms
   * <p>
   * Time Complexity : O(N)
   * Space Complexity : O(1)
   *
   * <a href="https://leetcode.com/problems/circular-array-loop/discuss/94148/Java-SlowFast-Pointer-Solution">Ref </a>
   * @param nums
   * @return
   */
  @Override
  public boolean circularArrayLoop(int[] nums) {
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 0) {
        continue;
      }
      int slow = i, fast = getIndex(nums, slow);
      while (isTheSameSign(nums[slow], nums[fast]) && isTheSameSign(nums[fast], nums[getIndex(nums, fast)])) {
        if (slow == fast) {
          if (fast == getIndex(nums, fast)) {
            break;
          }
          return true;
        }
        slow = getIndex(nums, slow);
        fast = getIndex(nums, getIndex(nums, fast));
      }

      // No loop is found, set all path to zero;
      slow = i;
      final int val = nums[slow];
      while (isTheSameSign(nums[slow], val)) {
        int next = getIndex(nums, slow);
        nums[slow] = 0;
        slow = next;
      }

    }
    return false;
  }

  /**
   * Return true when a and b has same sign, both are positive or negative.
   *
   * @param a
   * @param b
   * @return
   */
  private boolean isTheSameSign(int a, int b) {
    if (a == 0 || b == 0) {
      return false;
    }
    a >>>= 31;
    b >>>= 31;
    return (a ^ b) == 0;
  }

  private static int getIndex(final int[] nums, int i) {
    int n = nums.length;
    final long potentialNext = (long) i + (long) nums[i];
    return (int) (potentialNext >= 0 ? (potentialNext % n) : (n + potentialNext % n));
  }
}
