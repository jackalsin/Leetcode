package _751_800._779_K_th_Symbol_in_Grammar;

/**
 * @author jacka
 * @version 1.0 on 3/7/2018.
 */
public class Solution {
  public int kthGrammar(int N, int K) {
    return kthGrammar(N, K, 0);
  }

  private int kthGrammar(final int N, final int K, final int parent) {
    if (N == 1) {
      return parent;
    }
    final int sizeOfNLevel = 1 << (N - 1);
    final int left = parent % 2 == 0 ? 0 : 1, right = parent % 2 == 0 ? 1 : 0;
    if (K <= sizeOfNLevel / 2) {
      return kthGrammar(N - 1, K, left);
    } else {
      return kthGrammar(N - 1, K - sizeOfNLevel / 2, right);
    }
  }
}
