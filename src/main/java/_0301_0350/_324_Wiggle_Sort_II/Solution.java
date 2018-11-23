package _0301_0350._324_Wiggle_Sort_II;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author jacka
 * @version 1.0 on 9/3/2017.
 */
public class Solution {
  public void wiggleSort(int[] nums) {
    final int n = nums.length;
    int midIndex = (n + 1) / 2;
    int mid = findKthElement(nums, midIndex);
    int lower = 0, j = 0, larger = nums.length - 1;
    while (j <= larger) {
      int jVal = nums[newIndex(j, n)];
      if (jVal == mid) {
        j++;
      } else if (jVal > mid) {
        swap(nums, newIndex(lower++, n), newIndex(j++, n));
      } else {
        swap(nums, newIndex(j, n), newIndex(larger--, n));
      }
    }
  }

  private int findKthElement(int[] nums, final int k) {
    return pqSolution(nums, k);
  }

  private int pqSolution(int[] nums, int k) {
    if (k == 0) return nums[0];
    PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        return Integer.compare(o2, o1);
      }
    });
    for (int i : nums) {
      if (pq.size() >= k) {
        if (pq.peek() >= i) {
          pq.poll();
          pq.add(i);
        }
      } else {
        pq.add(i);
      }
    }
    return pq.peek();
  }

  /**
   * If the above description is unclear, maybe this explicit listing helps:
   * Accessing A(0) actually accesses nums[1].
   * Accessing A(1) actually accesses nums[3].
   * Accessing A(2) actually accesses nums[5].
   * Accessing A(3) actually accesses nums[7].
   * Accessing A(4) actually accesses nums[9].
   * Accessing A(5) actually accesses nums[0].
   * Accessing A(6) actually accesses nums[2].
   * Accessing A(7) actually accesses nums[4].
   * Accessing A(8) actually accesses nums[6].
   * Accessing A(9) actually accesses nums[8].
   * @param i
   * @param n
   * @return
   */
  private static int newIndex(int i, final int n) {
    return (2 * i + 1) % (n | 1);
  }


  private void swap(int[] nums, int i, int j) {
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }
}
