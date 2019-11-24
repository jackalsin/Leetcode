package interviews.oracle._287_Find_the_Duplicate_Number;

/**
 * @author jacka
 * @version 1.0 on 11/24/2019
 */
public final class SolutionII implements Solution {
  @Override
  public int findDuplicate(int[] nums) {
    int slow = 0, fast = 0;
    while (true) {
      slow = nums[slow];
      fast = nums[nums[fast]];
      if (slow == fast) {
        fast = 0;
        while (fast != slow) {
          slow = nums[slow];
          fast = nums[fast];
        }
        return fast;
      }
    }
  }
}
