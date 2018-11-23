package _0351_0400._373_Find_K_Pairs_with_Smallest_Sums;

import java.util.*;

public class Solution {

  /**
   * You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.
   * <p>
   * Define a pair (u,v) which consists of one element from the first array and one element from the second array.
   * <p>
   * Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.
   * <p>
   * Example 1:
   * Given nums1 = [1,7,11], nums2 = [2,4,6],  k = 3
   * <p>
   * Return: [1,2],[1,4],[1,6]
   * <p>
   * The first 3 pairs are returned from the sequence:
   * [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
   * Example 2:
   * Given nums1 = [1,1,2], nums2 = [1,2,3],  k = 2
   * <p>
   * Return: [1,1],[1,1]
   * <p>
   * The first 2 pairs are returned from the sequence:
   * [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
   * Example 3:
   * Given nums1 = [1,2], nums2 = [3],  k = 3
   * <p>
   * Return: [1,3],[2,3]
   * <p>
   * All possible pairs are returned from the sequence:
   * [1,3],[2,3]
   *
   * @param nums1
   * @param nums2
   * @param k
   * @return
   */
  public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
    Queue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        return Integer.compare(o1[0] + o1[1], o2[0] + o2[1]);
      }
    });
    final List<int[]> result = new ArrayList<>();
    if (k == 0 || nums1.length == 0 || nums2.length == 0) {
      return result;
    }

    for (int i = 0; i < nums1.length && i < k; i++) {
      pq.add(new int[]{nums1[i], nums2[0], 0});
    }
    while (result.size() < k && !pq.isEmpty()) {
      int[] curArray = pq.remove();
      result.add(new int[]{curArray[0], curArray[1]});
      final int curNums2Index = curArray[2];
      if (curNums2Index == nums2.length - 1) continue;
      pq.add(new int[]{curArray[0], nums2[curNums2Index + 1], curNums2Index + 1});
    }

    return result;
  }


  /**
   * Wrong solution.
   * <p>
   * The number in one array can be reused as long as the paired number is different.
   *
   * @param nums1
   * @param nums2
   * @param k
   * @return
   */
  private List<int[]> wrongSolution(int[] nums1, int[] nums2, int k) {
    int i1 = 0, i2 = 0;
    List<int[]> result = new ArrayList<>();
    if (nums1.length == 0 || nums2.length == 0) {
      return result;
    }

    while (result.size() < k && (i1 < nums1.length || i2 < nums2.length)) {
      System.out.println("k = " + result.size());
      if (i1 == nums1.length - 1) {
        result.add(new int[]{nums1[i1], nums2[i2++]});
      } else if (i2 == nums2.length - 1) {
        result.add(new int[]{nums1[i1++], nums2[i2]});
      } else {
        if (nums1[i1 + 1] + nums2[i2] < nums1[i1] + nums2[i2 + 1]) {
          result.add(new int[]{nums1[i1++], nums2[i2]});
        } else {
          result.add(new int[]{nums1[i1], nums2[i2++]});
        }
      }
    }

    return result;
  }
}