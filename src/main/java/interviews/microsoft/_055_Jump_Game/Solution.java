package interviews.microsoft._055_Jump_Game;

public class Solution {
  public boolean canJump(int[] nums) { // TODO: Redo
    int maxArrive = 0;
    for (int i = 0; i < nums.length; i++) {
      if (maxArrive < i) {
        return false;
      }

      maxArrive = Math.max(maxArrive, i + nums[i]);
    }
    return true;
  }
}
