package _0251_0300._282_Expression_Add_Operators;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 9/3/2017.
 */
public class Solution {
  public List<String> addOperators(String num, int target) {
    List<String> result = new ArrayList<>();
    addOperatorsHelper(num, new StringBuilder(), result, 0, 0, target, 1);
    return result;
  }

  private void addOperatorsHelper(String num, StringBuilder path, final List<String> result,
                                  long sum, final int start, final int target, long product) {
    if (sum == target) {
      if (num.length() == start) {
        result.add(path.substring(1));
      }
    }
    for (int i = start + 1; i <= num.length(); ++i) {
      if (i - start > 1 && num.charAt(start) == '0') continue; // skip "00", "01"
      long prev = Long.valueOf(num.substring(start, i));
      int prevIndex = path.length() - 1;
      path.append("+").append(prev);
      addOperatorsHelper(num, path, result, sum + prev, i, target, prev);
      if (start != 0) {
        path.replace(prevIndex + 1, prevIndex + 2, "-");
        addOperatorsHelper(num, path, result, sum - prev, i, target, -prev);
        path.replace(prevIndex + 1, prevIndex + 2, "*");

        addOperatorsHelper(num, path, result, sum - product + product * prev,
            i, target, product * prev);
      }
      path.delete(prevIndex + 1, path.length());
    }
  }
}
