package _301_350._313_Super_Ugly_Number;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 9/18/2017.
 */
public class Solution {
  public int nthSuperUglyNumber(int n, int[] primes) {
    final int size = primes.length;
    final int[] curPointers = new int[size];
    final int[] ugly = new int[n];
    ugly[0] = 1;
    for (int i = 1; i < n; ++i) {
      int min = getMin(ugly, curPointers, primes);
      ugly[i] = min;
      for (int ptrJ = 0; ptrJ < curPointers.length; ++ptrJ) {
        if (min == primes[ptrJ] * ugly[curPointers[ptrJ]]) {
          curPointers[ptrJ]++;
        }
      }
    }
    return ugly[n - 1];
  }

  private int getMin(int[] ugly, int[] curPointers, int[] primes) {
    int min = Integer.MAX_VALUE;

    for (int primeIndex = 0; primeIndex < primes.length; ++primeIndex) {
      int prime = primes[primeIndex];
      int uglyNum = ugly[ curPointers[primeIndex]  ];
      min = Math.min(min, prime * uglyNum);
    }
    return min;
  }
}
