package _201_250._215_Kth_Largest_Element_in_an_Array;

import java.util.Arrays;
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
//    return pqSolution(nums, k);
    return quickSelectSolution(nums, k);
  }

  private int quickSelectSolution(int[] nums, int k) {
    if(nums == null || nums.length == 0) {
      return -1;
    } else {
      return quickSelectSolution(nums, k, 0, nums.length - 1);
    }
  }

  private int quickSelectSolution(int[] nums, int k, int start, int end) {
    if (start >= end) {
      return nums[start];
    }
    int left = start, right = end, pivotVal = nums[start + (end - start)/2];
    while (left <= right) {
      while (left <= right && nums[left] < pivotVal) {
        left++;
      }
      while (left <= right && nums[right] > pivotVal) {
        right--;
      }

      if (left <= right) {
        swap(nums, left++, right--);
      }
    }
    /* If not satisfied, recursion */
    if (end - left >= k - 1) {
      return quickSelectSolution(nums, k, left, end);
    }

    if (end - right <= k - 1) {
      return quickSelectSolution(nums, k - (end - right), start, right);
    }
    return nums[left - 1];
  }

  private static void swap(int[] nums, int i, int j) {
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
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
