package _0101_0150._120_Triangle;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 6/23/2017.
 */
public class Solution {
  public int minimumTotal(List<List<Integer>> triangle) {
    if (triangle.size() == 0) return 0;
    List<Integer> sum = new ArrayList<>(triangle.get(triangle.size() - 1));
    for (int i = triangle.size() - 2; i >= 0; i--) {
      List<Integer> curRow = triangle.get(i);
      for (int col = 0; col < curRow.size(); col++) {
        curRow.set(col, curRow.get(col) + Math.min(sum.get(col), sum.get(col + 1)));
      }
      sum = curRow;
    }
    // return mini
    return sum.get(0);
  }
}
