package facebook._268_Missing_Number;

public class Solution {
  public int missingNumber(int[] nums) {
    int res = 0;
    final int n = nums.length;
    for (int i = 1; i <= n; i++) {
      res ^= i;
    }
    for (int num : nums) {
      res ^= num;
    }
    return res;
  }
}
