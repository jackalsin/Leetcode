package _001_050._006_ZigZag_Conversion;

/**
 * @author jacka
 * @version 1.0 on 2017/1/12.
 */
public class Solution {

  public String convert(String s, int numRows) {
    if (s == null || s.length() == 0) {
      return s;
    }
    if (numRows <= 0) {
      throw new IllegalArgumentException("numsRows cannot be non-positive but now is " + numRows);
    }
    if (numRows == 1) {
      return s;
    }
    final int totalSteps = 2 * (numRows - 1);
    StringBuilder sb = new StringBuilder();
    for (int curRow = 0; curRow < numRows; curRow++) {
      int curIndex = curRow, step2 = totalSteps - curRow * 2;
      while (curIndex < s.length()) {
        sb.append(s.charAt(curIndex));
        int index2 = curIndex + step2;
        if (curRow != 0 && (curRow != numRows - 1) && index2 < s.length()) {
          sb.append(s.charAt(index2));
        }
        curIndex += totalSteps;
      }
    }
    return sb.toString();
  }
}
