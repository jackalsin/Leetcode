package _201_250._215_Kth_Largest_Element_in_an_Array;

import java.util.PriorityQueue;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 8/11/2017.
 */
public class Solution {
  /**
   * Find the kth largest element in an unsorted array. Note that it is the kth largest element
   * in the sorted order, not the kth distinct element.
   *
   * Given [3,2,1,5,6,4] and k = 2, return 5.
   *
   * @param nums
   * @param k   the kth, 1 means the largest
   * @return    the kth largest
   */
  public int findKthLargest(int[] nums, final int k) {
    return pqSolution(nums, k);
  }

  /**
   * Time complexity O(nlogk)
   * @param nums
   * @param k
   * @return
   */
  private int pqSolution(int[] nums, int k) {
    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(k);
    for (int num : nums) {
      if (priorityQueue.size() == k && priorityQueue.peek() < num) {
        priorityQueue.poll();
        priorityQueue.add(num);
      } else if (priorityQueue.size() < k) {
        priorityQueue.add(num);
      }
    }
    return priorityQueue.isEmpty() ? 0 : priorityQueue.peek();
  }
}
