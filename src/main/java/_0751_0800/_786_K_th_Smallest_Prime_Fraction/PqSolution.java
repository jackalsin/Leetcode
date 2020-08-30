package _0751_0800._786_K_th_Smallest_Prime_Fraction;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Time Complexity: O((n + k) * log(n))
 *
 * @author jacka
 * @version 1.0 on 8/30/2020
 */
public final class PqSolution implements Solution {
  public int[] kthSmallestPrimeFraction(int[] A, int K) {
    Arrays.sort(A);
    final int n = A.length;
    final Queue<Entry> pq = new PriorityQueue<>();
    for (int j = 0; j < n; ++j) {
      pq.add(new Entry(A[0], A[j], 0, j));
    }
    for (int k = 0; k < K - 1; ++k) {
      final Entry toRemove = pq.remove();
      final int i = toRemove.i, j = toRemove.j;
      if (i + 1 < n) {
        final Entry toInsert = new Entry(A[i + 1], A[j], i + 1, j);
        pq.add(toInsert);
      }
    }
    final Entry e = pq.remove();
    return new int[]{e.p, e.q};
  }

  private static final class Entry implements Comparable<Entry> {
    private final int p, q, i, j;
    private final double val;

    private Entry(int p, int q, int i, int j) {
      this.p = p;
      this.q = q;
      this.i = i;
      this.j = j;
      val = (double) p / q;
    }

    @Override
    public int compareTo(Entry o) {
      return Double.compare(val, o.val);
    }

    @Override
    public String toString() {
      return "Entry{" +
          "p=" + p +
          ", q=" + q +
          ", i=" + i +
          ", j=" + j +
          ", val=" + val +
          '}';
    }
  }
}
