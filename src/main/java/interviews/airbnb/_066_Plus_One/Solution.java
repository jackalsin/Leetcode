package interviews.airbnb._066_Plus_One;

import java.util.LinkedList;

/**
 * @author jacka
 * @version 1.0 on 1/23/2019.
 */
public class Solution {

  public int[] plusOne(int[] digits) {
    if (digits == null) {
      return null;
    }
    if (digits.length == 0) {
      return new int[]{};
    }

    final LinkedList<Integer> result = new LinkedList<>();
    digits[digits.length - 1]++;
    for (int i = digits.length - 1, carry = 0; i >= 0 || carry > 0; i--) {
      final int sum = (i >= 0 ? digits[i] : 0) + carry, cur = sum % 10;
      carry = sum / 10;
      result.addFirst(cur);
    }
    final int[] res = new int[result.size()];
    for (int i = 0; i < res.length; i++) {
      res[i] = result.removeFirst();
    }
    return res;
  }
}
