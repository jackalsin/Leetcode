package _0901_0950._927_Three_Equal_Parts;

/**
 * @author zhixi
 * @version 1.0 on 9/21/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int[] threeEqualParts(int[] A) {
    int countOfOne = 0;
    for (int a : A) {
      if (a == 1) countOfOne++;
    }
    final int n = A.length;
    if (countOfOne == 0) {
      return new int[]{0, n - 1};
    }
    if (countOfOne % 3 != 0) {
      return new int[]{-1, -1};
    }
    final int k = countOfOne / 3;
    // find the first 1
    countOfOne = 0;
    int i = 0, first = 0, second = 0, third = 0;
    for (; i < n; ++i) {
      if (A[i] == 1) {
        countOfOne++;
        if (countOfOne == 1) {
          first = i;
        } else if (countOfOne == k + 1) {
          second = i;
        } else if (countOfOne == k * 2 + 1) {
          third = i;
        }
      }
    }
//    System.out.println("first = " + first + ", second = " + second + ", third = " + third);
    while (third < n) {
      if (A[first] == A[second] && A[second] == A[third]) {
        first++;
        second++;
        third++;
      } else {
        return new int[]{-1, -1};
      }
    }
    return new int[]{first - 1, second};
  }
}
