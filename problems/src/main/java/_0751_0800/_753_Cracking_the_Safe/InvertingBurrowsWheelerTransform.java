package _0751_0800._753_Cracking_the_Safe;

import java.util.Arrays;

/**
 * @author jacka
 * @version 1.0 on 1/9/2018.
 */
public final class InvertingBurrowsWheelerTransform {

  /**
   * https://www.youtube.com/watch?v=iPLQgXUiU14
   */
  public String crackSafe(int n, int k) {
    int M = (int) Math.pow(k, n - 1);
    int[] P = new int[M * k];
    for (int i = 0; i < k; ++i) {
      for (int q = 0; q < M; ++q) {
        P[i * M + q] = q * k + i;
      }
    }
    System.out.println(Arrays.toString(P));
    StringBuilder ans = new StringBuilder();
    for (int i = 0; i < M * k; ++i) {
      int j = i;
      while (P[j] >= 0) {
        ans.append(String.valueOf(j / M));
        int v = P[j];
        P[j] = -1;
        j = v;
      }
    }

    for (int i = 0; i < n - 1; ++i) {
      ans.append("0");
    }
    return new String(ans);
  }

}
