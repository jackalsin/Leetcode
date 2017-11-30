package _451_500._480_Sliding_Window_Median;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
  public double[] medianSlidingWindow(int[] nums, int k) {
    final Queue<Integer> small = new PriorityQueue<>(new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        return Integer.compare(o2, o1);
      }
    }), big = new PriorityQueue<>();
    final double[] result = new double[Math.max(1, nums.length - k + 1)];

    for (int i = 0; i < Math.min(k, nums.length); i++) {
      add(small, big, nums[i]);
    }

    result[0] = small.size() == big.size() ? ((double) small.peek() + (double) big.peek()) / 2 : (double) small.peek();

    for (int i = k; i < nums.length; i++) {
      int toRemove = nums[i - k];
      if (small.contains(toRemove)) {
        small.remove(toRemove);
      } else {
        big.remove(toRemove);
      }

      add(small, big, nums[i]);
      result[i - k + 1] = small.size() == big.size() ?
          ((double) small.peek() + (double) big.peek()) / 2 : (double) small.peek();
    }
    return result;
  }

  private static void add(final Queue<Integer> small, final Queue<Integer> big, int val) {
    big.add(val);
    if (small.size() < big.size()) {
      small.add(big.remove());
    }

    if (!small.isEmpty() && !big.isEmpty() && small.peek() > big.peek()) {
      int smallPeek = small.remove(), bigPeek = big.remove();
      big.add(smallPeek);
      small.add(bigPeek);
    }
  }
}
