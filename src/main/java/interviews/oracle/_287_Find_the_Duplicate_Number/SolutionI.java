package interviews.oracle._287_Find_the_Duplicate_Number;

/**
 * @author jacka
 * @version 1.0 on 10/23/2019
 */
public final class SolutionI implements Solution {
  @Override
  public int findDuplicate(int[] nums) {
    int slow = 0, fast = 0;
    while (true) {
      slow = nums[slow];
      fast = nums[nums[fast]];
      if (slow == fast) { // meet point
        fast = 0;
        while (slow != fast) {
          fast = nums[fast];
          slow = nums[slow];
        }
        return slow;
      }
    }
  }
}
