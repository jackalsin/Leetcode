package _1051_1100._1073_Adding_Two_Negabinary_Numbers;

import java.util.LinkedList;

/**
 * @author zhixi
 * @version 1.0 on 11/29/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int[] addNegabinary(int[] arr1, int[] arr2) {
    final LinkedList<Integer> result = new LinkedList<>();
    final int len1 = arr1.length, len2 = arr2.length;
    for (int i = len1 - 1, j = len2 - 1, carry = 0; i >= 0 || j >= 0 || carry != 0; --i, --j) {
      final int val1 = i >= 0 ? arr1[i] : 0,
          val2 = j >= 0 ? arr2[j] : 0,
          sum = val1 + val2 + carry;
      if (sum >= 0) {
        result.addFirst(sum % 2);
        carry = -sum / 2;
      } else {
        assert sum == -1;
        result.addFirst(1);
        carry = 1;
      }
    }
    // remove first zero
    while (result.size() > 1 && result.getFirst() == 0) {
      result.removeFirst();
    }
    final int[] res = new int[result.size()];
    int i = 0;
    for (int v : result) {
      res[i] = v;
      ++i;
    }
    return res;
  }
}
