package _1401_1450._1437_Check_If_All_1s_Are_at_Least_Length_K_Places_Away;


public final class SolutionI implements Solution {
  @Override
  public boolean kLengthApart(int[] nums, int k) {
    int lastSeen = -1;
    for (int i = 0; i < nums.length; ++i) {
      if (nums[i] == 1) {
        if (lastSeen != -1) {
          if (i - lastSeen <= k) return false;
        }
        lastSeen = i;
      }
    }
    return true;
  }
}
