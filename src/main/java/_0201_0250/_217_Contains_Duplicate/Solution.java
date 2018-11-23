package _0201_0250._217_Contains_Duplicate;

import java.util.HashSet;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 8/13/2017.
 */
public class Solution {
  public boolean containsDuplicate(int[] nums) {
    Set<Integer> visited = new HashSet<>();
    for (int i : nums) {
      if (visited.contains(i)) {
        return true;
      } else {
        visited.add(i);
      }
    }
    return false;
  }
}
