package _0201_0250._202_Happy_Number;

import java.util.HashSet;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 8/5/2017.
 */
public class Solution {

  public boolean isHappy(int n) {
    Set<Integer> seen = new HashSet<>();
    while (true) {
      int sum = 0;
      while (n != 0) {
        int digit = n % 10;
        sum += digit * digit;
        n /= 10;
      }
      if (sum == 1) {
        return true;
      } else if (seen.contains(sum)) {
        return false;
      } else {
        seen.add(sum);
        n = sum;
      }
    }
  }
}
