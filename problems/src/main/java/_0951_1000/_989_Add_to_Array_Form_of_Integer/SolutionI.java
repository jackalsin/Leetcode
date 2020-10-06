package _0951_1000._989_Add_to_Array_Form_of_Integer;

import java.util.LinkedList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 10/5/2020
 */
public final class SolutionI implements Solution {
  @Override
  public List<Integer> addToArrayForm(int[] A, int K) {
    final LinkedList<Integer> result = new LinkedList<>();
    final int n = A.length;
    for (int i = n - 1, carry = 0; i >= 0 || carry != 0 || K != 0; --i, K /= 10) {
      final int a = i < 0 ? 0 : A[i], b = K % 10, sum = a + b + carry, c = sum % 10;
      carry = sum / 10;
      result.addFirst(c);
    }
    return result;
  }
}
