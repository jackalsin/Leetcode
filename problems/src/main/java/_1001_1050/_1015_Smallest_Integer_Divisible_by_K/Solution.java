package _1001_1050._1015_Smallest_Integer_Divisible_by_K;

public class Solution {
  public int smallestRepunitDivByK(final int K) {
    final boolean[] visited = new boolean[K];
    int n = 0, len = 0;
    while (true) {
      final int mod = (n * 10 + 1) % K;
      len++;
      if (mod == 0) {
        return len;
      }
      if (visited[mod]) {
        return -1;
      }
      visited[mod] = true;
      n = mod;
    }
  }
}
