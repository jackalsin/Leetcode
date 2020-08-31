package _0801_0850._806_Number_of_Lines_To_Write_String;

/**
 * @author jacka
 * @version 1.0 on 8/30/2020
 */
public final class SolutionI implements Solution {
  private static final int W = 100;

  public int[] numberOfLines(int[] widths, String S) {
    int curLineWidth = 0, lineNum = 0;
    if (S == null || S.isEmpty()) return new int[]{lineNum, curLineWidth};
    lineNum++;
    for (final char chr : S.toCharArray()) {
      final int w = widths[chr - 'a'];
      if (curLineWidth + w > W) {
        lineNum++;
        curLineWidth = w;
      } else {
        curLineWidth += w;
      }
    }
    return new int[]{lineNum, curLineWidth};
  }
}
