package _201_250._204_Count_Prime;

/**
 * @author jacka
 * @version 1.0 on 8/6/2017.
 */
public class Solution {
  public int countPrimes(int n) {
//    return countPrimesSlow(n);
    return countPrimesDp(n);
  }

  private int countPrimesDp(int n) {
    boolean[] notPrime = new boolean[n];
    int count = 0;
    for(int i = 2; i < n; i++) {
      if (!notPrime[i]) {
        count++;
        for (int j = 2; j * i < n; j++) {
          notPrime[i * j] = true;
        }
      }
    }
    return count;
  }

  /**
   * Slow solution.
   *
   * @param n
   * @return
   */
  private static int countPrimesSlow(int n) {
    int count = 0;
    for(int i = 2; i < n; ++i) {
      if (isPrime(i)) {
        count++;
      }
    }
    return count;
  }

  static boolean isPrime(int n) {
    if (n < 2) {
      return false;
    } else if (n == 2) {
      return true;
    } else if (n % 2 == 0) {
      return false;
    } else {
      for (int i = 3; i <= n / i; i+=2 ) {
        if (n % i == 0) {
          return false;
        }
      }
      return true;
    }
  }

  public static void main(String[] args) {
    System.out.println(Math.sqrt(25));
  }

}
