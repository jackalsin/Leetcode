package _0951_1000._952_Largest_Component_Size_by_Common_Factor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 9/27/2020
 */
public final class SolutionI implements Solution {
  private final boolean[] isPrime = new boolean[100001];

  {
    Arrays.fill(isPrime, true);
    isPrime[0] = isPrime[1] = false;
    // all primes less than 100000
    for (int i = 2; i <= 100000; i++) {
      if (isPrime[i]) {
        for (int j = 2; j * i <= 100000; j++) {
          isPrime[j * i] = false;
        }
      }
    }
  }

  public int largestComponentSize(int[] A) {
    /*Union find if have multiple roots, we can pick one as default root and union that one with other roots*/
    final Map<Integer, Integer> valToRoot = new HashMap<>();
    final int max = getMax(A);
    final UnionFind uf = new UnionFind(max + 1);
    for (final int a : A) {
      if (a <= 1) {
        valToRoot.put(a, a);
        continue;
      }
      final List<Integer> primeFactors = getPrimeFactors(a);
      valToRoot.put(a, primeFactors.get(0));
      for (int i = 0; i < primeFactors.size() - 1; ++i) {
        uf.union(primeFactors.get(i), primeFactors.get(i + 1));
      }
    }
    int result = 0;
    final Map<Integer, Integer> counts = new HashMap<>();
    for (int a : A) {
      final int root = uf.root(valToRoot.get(a)),
          count = counts.getOrDefault(root, 0) + 1;
      counts.put(root, count);
      result = Math.max(result, count);
    }
    return result;
  }

  private static int getMax(final int[] a) {
    int res = a[0];
    for (int i = 1; i < a.length; ++i) {
      res = Math.max(res, a[i]);
    }
    return res;
  }

  /**
   * Val to it's prime factor
   */
//  private final Map<Integer, Set<Integer>> primeFactors = new HashMap<>();
  private List<Integer> getPrimeFactors(final int val) {
    if (isPrime[val]) return List.of(val);
    final List<Integer> primeFactors = new ArrayList<>();
    int cur = val;
    for (int i = 2; i * i <= cur; ++i) {
      while (cur % i == 0 && isPrime[i]) {
        primeFactors.add(i);
        cur /= i;
      }
    }
    if (cur > 1) {
      primeFactors.add(cur);
    }
    return primeFactors;
  }

  private static final class UnionFind {
    private final int[] roots, sizes;

    private UnionFind(final int n) {
      this.roots = new int[n];
      for (int i = 0; i < n; ++i) {
        roots[i] = i;
      }
      this.sizes = new int[n];
      Arrays.fill(sizes, 1);
    }

    private void union(final int p, final int q) {
      final int rootP = root(p), rootQ = root(q), sizeP = sizes[rootP], sizeQ = sizes[rootQ];
      if (sizeP < sizeQ) {
        roots[rootP] = rootQ;
        sizes[rootQ] += sizes[rootP];
      } else {
        roots[rootQ] = rootP;
        sizes[rootP] += sizes[rootQ];
      }
    }

    private int root(int p) {
      while (p != roots[p]) {
        roots[p] = roots[roots[p]];
        p = roots[p];
      }
      return p;
    }
  }
}
