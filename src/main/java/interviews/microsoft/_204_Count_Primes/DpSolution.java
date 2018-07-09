package interviews.microsoft._204_Count_Primes;

public final class DpSolution implements Solution {

  public int countPrimes(int n) {
    final boolean[] isNotPrime = new boolean[n];
    int count = 0;
    for (int i = 2; i < n; i++) {
      if (!isNotPrime[i]) {
        count++;
        for (int j = 2; j * i < n; j++) {
          isNotPrime[i * j] = true;
        }
      }
    }
    return count;
  }

}
