package _0101_0150._119_Pascals_Triangle_II;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 6/23/2017.
 */
public class Solution {
  public List<Integer> getRow(int rowIndex) {
    List<Integer> result = new ArrayList<>();
    if (rowIndex < 0) return result;
    else if (rowIndex == 0) {
      return Collections.singletonList(1);
    } else {
      List<Integer> prevRow = getRow(rowIndex - 1);
      for (int i = 0; i < rowIndex + 1; i++) {
        if (i == 0 || i == rowIndex) {
          result.add(1);
        } else {
          result.add(prevRow.get(i - 1) + prevRow.get(i));
        }
      }
      return result;
    }
  }
}
