package dynamicProgramming._062_Unique_Paths;

public class Solution {
  public int uniquePaths(int m, int n) {
    if (m == 0 || n == 0) {
      return 0;
    }
    if (m < n) {
      return uniquePaths(n, m);
    }
    m--;
    n--;
    long res = 1;
    for (int i = m + 1, j = 1; i <= m + n; i++, j++) {
      res *= i;
      res /= j;
    }
    return (int) res;
  }
}
