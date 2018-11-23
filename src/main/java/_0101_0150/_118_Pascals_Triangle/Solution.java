package _0101_0150._118_Pascals_Triangle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 6/23/2017.
 */
public class Solution {
  public List<List<Integer>> generate(int numRows) {
    List<List<Integer>> result = new ArrayList<>();
    if (numRows <= 0) return result;
    result.add(Arrays.asList(1));
    for (int i = 2; i <= numRows; i++) {
      List<Integer> prevRow = result.get(result.size() - 1);
      List<Integer> curRow = new ArrayList<>();
      for (int j = 0; j < i; j++) {
        if (j == 0 || j == i - 1) {
          curRow.add(1);
        } else {
          curRow.add(prevRow.get(j - 1) + prevRow.get(j));
        }
      }
      result.add(curRow);
    }
    return result;
  }
}
