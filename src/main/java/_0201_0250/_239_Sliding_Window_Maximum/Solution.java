package _0201_0250._239_Sliding_Window_Maximum;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;

/**
 * @author jacka
 * @version 1.0 on 8/19/2017.
 */
public class Solution {
  /**
   * TreeSet和PriorityQueue 的区别主要是TreeSet存唯一的
   * @param nums
   * @param k
   * @return
   */
  public int[] maxSlidingWindow(int[] nums, int k) {
//    return nLogN(nums, k);
    return oN(nums, k);
  }

  private int[] oN(int[] nums, int k) {
    if (k > nums.length || k < 1) return new int[]{};
    final int[] output = new int[nums.length - k + 1];
    Deque<Integer> deque = new ArrayDeque<>();
    for(int i = 0; i < nums.length; ++i) {
      while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
        deque.removeFirst();
      }
      /* try to keep the deque is descending */
      while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
        deque.removeLast();
      }
      deque.addLast(i);

      if (i >= k - 1) {
        output[i - k + 1] = nums[deque.peekFirst()];
      }
    }
    return output;
  }

  private static int[] nLogN(int[] nums, int k) {
    if (k > nums.length || k < 1) return new int[]{};
    final int[] outputs = new int[nums.length - k + 1];
    PriorityQueue<Integer> window = new PriorityQueue<>(new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        return Integer.compare(o2, o1);
      }
    });
    for(int i = 0; i < k - 1; ++i) {
      window.add(nums[i]);
    }

    for (int i = k - 1; i < nums.length; ++i) {
      window.add(nums[i]);
      outputs[i - k + 1] = window.peek();
      window.remove(nums[i - k + 1]);

    }
    return outputs;
  }
}
