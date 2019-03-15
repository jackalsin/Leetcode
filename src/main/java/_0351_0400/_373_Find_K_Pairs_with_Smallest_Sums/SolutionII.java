package _0351_0400._373_Find_K_Pairs_with_Smallest_Sums;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * @author jacka
 * @version 1.0 on 3/13/2019.
 */
public final class SolutionII implements Solution {
  @Override
  public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
    final TreeSet<Pair> treeSet = new TreeSet<>((a, b) -> {
      final int sumCmp = Integer.compare(nums1[a.i] + nums2[a.j], nums1[b.i] + nums2[b.j]);
      if (sumCmp == 0) {
        final int iCmp = Integer.compare(a.i, b.i);
        if (iCmp == 0) {
          return Integer.compare(a.j, b.j);
        }
      }
      return sumCmp;
    });
    final List<int[]> result = new ArrayList<>();
    if (k == 0 || nums1.length == 0 || nums2.length == 0) {
      return result;
    }

    // 先加头6个
    treeSet.add(new Pair(0, 0));
    if (nums1.length > 1) {
      treeSet.add(new Pair(1, 0));
      if (nums1.length > 2) {
        treeSet.add(new Pair(2, 0));
      }
    }
    if (nums2.length > 1) {
      treeSet.add(new Pair(0, 1));
      if (nums2.length > 2) {
        treeSet.add(new Pair(0, 2));
      }
      if (nums1.length > 1) {
        treeSet.add(new Pair(1, 1));
      }
    }

    while (result.size() < k && !treeSet.isEmpty()) {
      final Pair p = treeSet.pollFirst();
      assert p != null;
      result.add(new int[]{nums1[p.i], nums2[p.j]});
      if (p.i + 1 < nums1.length && p.j + 1 < nums2.length) {
        if (nums1[p.i + 1] + nums2[p.j] < nums1[p.i] + nums2[p.j + 1]) {
          if (!treeSet.add(new Pair(p.i + 1, p.j))) {
            treeSet.add(new Pair(p.i, p.j + 1));
          }
        } else if (nums1[p.i + 1] + nums2[p.j] > nums1[p.i] + nums2[p.j + 1]) {
          if (!treeSet.add(new Pair(p.i, p.j + 1))) {
            treeSet.add(new Pair(p.i + 1, p.j));
          }
        } else {
          treeSet.add(new Pair(p.i + 1, p.j));
          treeSet.add(new Pair(p.i, p.j + 1));
        }
      } else if (p.i + 1 < nums1.length) {
        treeSet.add(new Pair(p.i + 1, p.j));
      } else if (p.j + 1 < nums2.length) {
        treeSet.add(new Pair(p.i, p.j + 1));
      }
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
  }
}
