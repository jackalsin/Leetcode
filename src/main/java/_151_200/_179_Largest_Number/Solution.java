package _151_200._179_Largest_Number;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 8/2/2017.
 */
public class Solution {
  public String largestNumber(int[] nums) {
    if (nums == null || nums.length == 0) {
      return "0";
    }
    List<String> stringNums = new ArrayList<>();
    for (int child: nums) {
      stringNums.add(String.valueOf(child));
    }
    Collections.sort(stringNums, new Comparator<String>() {
      @Override
      public int compare(String o1, String o2) {
        String s1 = o1 + o2;
        String s2 = o2 + o1;
        return s2.compareTo(s1);
      }
    });
    if (stringNums.get(0).equals("0")) {
      return "0";
    }
    StringBuilder sb = new StringBuilder();
    for (String child : stringNums) {
      sb.append(child);
    }

    return sb.toString();
  }
}
