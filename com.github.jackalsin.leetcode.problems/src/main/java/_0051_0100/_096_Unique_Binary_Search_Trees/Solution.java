package _0051_0100._096_Unique_Binary_Search_Trees;

/**
 * @author jacka
 * @version 1.0 on 6/1/2017.
 */
public class Solution {
  /**
   * Related Link: https://discuss.leetcode.com/topic/8398/dp-solution-in-6-lines-with-explanation-f-i-n-g-i-1-g-n-i
   * <p>
   * Assuming doing it from 1 to n, choose each one as a root. Since root is different, they
   * won't be the same.
   * Then, the left side will be under the left node, and the right node will be in the right node.
   *
   * @param n number of nodes.
   * @return number of unique structure.
   */
//  public int numTrees(int n) {
//    if (n <= 0) {
//      return n;
//    }
//    final int[] uniques = new int[n + 1];
//    for(int i = 0; i < n + 1; i++) {
//      if (i < 2) {
//        uniques[i] = 1;
//      } else {
//        for (int j = 0; j <= i-1; j++) {
//          uniques[i] += uniques[j] * uniques[i - 1 - j];
//        }
//      }
//    }
//    return uniques[n];
//  }
  public int numTrees(int n) {
    final long[] combination = new long[n + 1];
    combination[0] = 1;
    for (int i = 0; i < n; i++) {
      combination[i + 1] = (2L * (2 * i + 1) * combination[i] / (i + 1));
    }
    return (int) (combination[n] / (n + 1));
  }
}
