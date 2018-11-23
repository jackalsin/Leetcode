package _0201_0250._228_Summary_Ranges;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 8/17/2017.
 */
public class Solution {
  public List<String> summaryRanges(int[] nums) {
    List<String> result = new ArrayList<>();
    if (nums.length == 0) {
      return result;
    }
    int start = nums[0];
    int end = nums[0];
    for (int i = 1; i < nums.length; ++i) {
      int cur = nums[i];
      if (end + 1 == cur) {
        end = cur;
      } else {
        result.add(getRepresentation(start, end));
        start = end = cur;
      }
    }
    result.add(getRepresentation(start, end));
    return result;
  }

  private String getRepresentation(int start, int end) {
    if (start == end) {
      return new StringBuilder().append(start).toString();
    } else {
      return new StringBuilder().append(start).append("->").append(end).toString();
    }
  }

}
