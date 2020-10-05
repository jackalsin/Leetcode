package uber._202_Happy_Number;

public final class FloydCycleAlgorithmSolution implements Solution {
  @Override
  public boolean isHappy(int n) {
    if (n <= 0) {
      return false;
    }

    return isHappyHelper(n);
  }

  private boolean isHappyHelper(int n) {
    long slow = n, fast = n;
    do {
      slow = squareSum(slow);
      fast = squareSum(fast);
      fast = squareSum(fast);
      if (slow == 1) {
        return true;
      }
    } while (slow != fast);
    return false;
  }

  private long squareSum(long n) {
    assert n >= 0;
    long res = 0;
    while (n != 0) {
      final long digit = n % 10;
      res += digit * digit;
      n /= 10;
    }
    return res;
  }
}
