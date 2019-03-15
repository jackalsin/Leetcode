package _0351_0400._373_Find_K_Pairs_with_Smallest_Sums;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 3/13/2019.
 */
public final class SolutionIII implements Solution {
  @Override
  public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
    final Queue<Pair> pq = new PriorityQueue<>((a, b) -> {
      final int sumCmp = Integer.compare(nums1[a.i] + nums2[a.j], nums1[b.i] + nums2[b.j]);
      if (sumCmp == 0) {
        final int iCmp = Integer.compare(a.i, b.i);
        if (iCmp == 0) {
          return Integer.compare(a.j, b.j);
        }
        return iCmp;
      }
      return sumCmp;
    });
    final List<int[]> result = new ArrayList<>();
    if (k == 0 || nums1.length == 0 || nums2.length == 0) {
      return result;
    }
    final Set<Pair> pqVals = new HashSet<>();
    // 先加头6个
    pq.add(new Pair(0, 0));
    pqVals.add(new Pair(0, 0));
    if (nums1.length > 1) {
      pq.add(new Pair(1, 0));
      pqVals.add(new Pair(1, 0));
      if (nums1.length > 2) {
        pq.add(new Pair(2, 0));
        pqVals.add(new Pair(2, 0));
      }
    }
    if (nums2.length > 1) {
      pq.add(new Pair(0, 1));
      pqVals.add(new Pair(0, 1));
      if (nums2.length > 2) {
        pq.add(new Pair(0, 2));
        pqVals.add(new Pair(0, 2));
      }
      if (nums1.length > 1) {
        pq.add(new Pair(1, 1));
        pqVals.add(new Pair(1, 1));
      }
    }

    while (result.size() < k && !pq.isEmpty()) {
      final Pair p = pq.remove();
      pqVals.remove(p);
      assert p != null;
//      result.add(new int[]{nums1[p.i], nums2[p.j]});
      result.add(new int[]{p.i, p.j});
      final Pair pairI1J = new Pair(p.i + 1, p.j), pairIJ1 = new Pair(p.i, p.j + 1);
      if (p.i + 1 < nums1.length && p.j + 1 < nums2.length) {
        if (nums1[p.i + 1] + nums2[p.j] < nums1[p.i] + nums2[p.j + 1]) {
          if (pqVals.contains(pairI1J)) {
            if (pqVals.add(pairIJ1)) {
              pq.add(pairIJ1);
            }
          } else {
            if (pqVals.add(pairI1J)) {
              pq.add(pairI1J);
            }
          }
        } else if (nums1[p.i + 1] + nums2[p.j] > nums1[p.i] + nums2[p.j + 1]) {
          if (pqVals.contains(pairIJ1)) {
            if (pqVals.add(pairI1J)) {
              pq.add(pairI1J);
            }
          } else {
            if (pqVals.add(pairIJ1)) {
              pq.add(pairIJ1);
            }
          }
        } else { // 此处不确定，先骚一把
          if (pqVals.add(pairI1J)) {
            pq.add(pairI1J);
          }
          if (pqVals.add(pairIJ1)) {
            pq.add(pairIJ1);
          }
        }
      } else if (p.i + 1 < nums1.length) {
        if (pqVals.add(pairI1J)) {
          pq.add(pairI1J);
        }
      } else if (p.j + 1 < nums2.length) {
        if (pqVals.add(pairIJ1)) {
          pq.add(pairIJ1);
        }
      }
    }
    // system out
//    result.forEach(x -> System.out.println(Arrays.toString(x)));
    for (int i = 0; i < result.size(); i++) {
      final int[] index = result.get(i);
      result.set(i, new int[]{nums1[index[0]], nums2[index[1]]});
    }
    return result;
  }

  private static final class Pair {
    private final int i, j;

    private Pair(int i, int j) {
      this.i = i;
      this.j = j;
    }

    @Override
    public String toString() {
      return "Pair{" +
          "i=" + i +
          ", j=" + j +
          '}';
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;

      Pair pair = (Pair) o;

      if (i != pair.i) return false;
      return j == pair.j;
    }

    @Override
    public int hashCode() {
      int result = i;
      result = 31 * result + j;
      return result;
    }
  }
}
