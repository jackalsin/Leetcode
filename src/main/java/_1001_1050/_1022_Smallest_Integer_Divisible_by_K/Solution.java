package _1001_1050._1022_Smallest_Integer_Divisible_by_K;

public class Solution {
  public int smallestRepunitDivByK(final int K) {
    final boolean[] visited = new boolean[K];
    int n = 1, len = 1;
    while (n % K != 0) {
      final int next = (n % K) * 10 + 1;
      if (visited[next % K]) {
        return -1;
      }
      visited[next % K] = true;
      n = next;
      len++;
    }
    return len;
  }
}
