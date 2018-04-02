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
    for (final char chr : eq.toCharArray()) {

    }
    return new int[]{globalSign * numOfX, globalSign * numOfY, globalSign * num};
  }
}
