package _101_150._136_Single_Number;

import java.util.HashSet;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 7/1/2017.
 */
public class Solution {
  public int singleNumber(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    } else {
      Set<Integer> visited = new HashSet<>();
      for (int child: nums) {
        if (visited.contains(child)) {
          visited.remove(child);
        } else {
          visited.add(child);
        }
      }
      for (int i : visited) {
        return i;
      }
      throw new IllegalStateException();
    }
  }
}
