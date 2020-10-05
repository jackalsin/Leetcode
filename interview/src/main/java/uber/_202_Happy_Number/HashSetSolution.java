package uber._202_Happy_Number;

import java.util.HashSet;
import java.util.Set;

public final class HashSetSolution implements Solution {
  private final Set<Long> visited = new HashSet<>();

  public boolean isHappy(int n) {
    if (n <= 0) {
      return false;
    }
    return isHappyHelper(n);
  }

  private boolean isHappyHelper(long n) {
    if (n == 1) {
      return true;
    }
    long res = 0;

    while (n != 0) {
      int digit = (int) (n % 10);
      res += digit * digit;
      n /= 10;
    }
    if (visited.contains(res)) {
      return false;
    }
    visited.add(res);
    return isHappyHelper(res);
  }
}
