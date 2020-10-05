package microsoft._204_Count_Primes;

public final class SlowSolution implements Solution {

  public int countPrimes(int n) {
    int count = 0;
    for (int i = 2; i < n; i++) {
      if (isPrime(i))
        count++;
    }
    return count;
  }

  private static boolean isPrime(int i) {
    if (i < 2) {
      return false;
    } else if (i == 2) {
      return true;
    } else {
      for (int factor = 2; factor <= i / factor; factor++) {
        if (i % factor == 0) {
          return false;
        }
      }
    }
    return true;
  }
}
