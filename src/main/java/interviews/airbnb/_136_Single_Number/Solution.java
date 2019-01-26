package interviews.airbnb._136_Single_Number;

/**
 * @author jacka
 * @version 1.0 on 1/26/2019.
 */
public class Solution {
  public int singleNumber(int[] nums) {
    int res = 0;
    for (int num : nums) {
      res ^= num;
    }
    return res;
  }
}
