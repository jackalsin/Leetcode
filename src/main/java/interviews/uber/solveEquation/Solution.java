package interviews.uber.solveEquation;

/**
 * @author jacka
 * @version 1.0 on 3/23/2018.
 */
public class Solution { // todo: https://qiuzhihui.gitbooks.io/r-book/content/jie-er-yuan-yi-ci-fang-cheng.html

  public double solve(final String equation, int xVal) {
    final String[] eqs = equation.split("=");
    final int[] left = processOneSide(eqs[0], 1);
    final int[] right = processOneSide(eqs[1], -1);
    final int numOfX = left[0] + right[0], numOfY = left[1] + right[1], num = left[2] + right[2];
    return (-numOfX * xVal - num) / (double) numOfY;
  }


  /**
   * @param eq
   * @param globalSign
   * @return {num of x, num of y, num};
   */
  private int[] processOneSide(String eq, final int globalSign) {
    int num = 0, numOfX = 0, numOfY = 0;
    int o1 = 1, curNum = 0;
    char[] charArray = eq.toCharArray();
    for (int i = 0; i < charArray.length; i++) {
      final char chr = charArray[i];
      if (Character.isDigit(chr)) {
        curNum = chr - '0';
        while (i + 1 < charArray.length && Character.isDigit(charArray[i + 1])) {
          curNum = curNum * 10 + charArray[i + 1] - '0';
        }
      } else if (chr == 'x') {
        numOfX += o1 * (curNum == 0 ? 1 : curNum);
        curNum = 0;
      } else if (chr == 'y') {
        numOfY += o1 * (curNum == 0 ? 1 : curNum);
        curNum = 0;
      } else if (chr == '(') {
        final int start = i;
        int count = 1;
        while (i + 1 < charArray.length && count > 0) {
          if (charArray[i + 1] == '(') {
            count++;
          } else if (charArray[i + 1] == ')') {
            count--;
          }
          i++;
        }
        assert charArray[i] == ')';
//        int[] res = processOneSide(eq.substring(start + 1, i), 1);
        int[] res = processOneSide(eq.substring(start + 1, i), o1);
        numOfX += res[0];
        numOfY += res[1];
        num += res[2];
        o1 = 1;
      } else if (chr == '+') {
        num += o1 * curNum;
        o1 = 1;
        curNum = 0;
      } else if (chr == '-') {
        num += o1 * curNum;
        o1 = -1;
        curNum = 0;
      }
    }
    return new int[]{globalSign * numOfX, globalSign * numOfY, globalSign * num};
  }
}
