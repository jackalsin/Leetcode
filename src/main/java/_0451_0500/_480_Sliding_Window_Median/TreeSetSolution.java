package _0451_0500._480_Sliding_Window_Median;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * This is a wrong solution due to it can have duplicated elements
 */
public class TreeSetSolution implements Solution {
  @Override
  public double[] medianSlidingWindow(int[] nums, int k) {
    final TreeSet<Integer> small = new TreeSet<>(new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        return Integer.compare(o2, o1);
      }
    }), big = new TreeSet<>();
    final double[] result = new double[Math.max(1, nums.length - k + 1)];

    for (int i = 0; i < Math.min(k, nums.length); i++) {
      add(small, big, nums[i]);
    }

    result[0] = small.size() == big.size() ? ((double) small.first() + (double) big.first()) / 2 : (double) small.first();

    for (int i = k; i < nums.length; i++) {
      int toRemove = nums[i - k];
      if (small.contains(toRemove)) {
        small.remove(toRemove);
      } else {
        big.remove(toRemove);
      }

      add(small, big, nums[i]);
      result[i - k + 1] = small.size() == big.size() ?
          ((double) small.first() + (double) big.first()) / 2 : (double) small.first();
    }
    return result;
  }

  private static void add(final TreeSet<Integer> small, final TreeSet<Integer> big, int val) {
    big.add(val);
    if (small.size() < big.size()) {
      small.add(big.pollFirst());
    }

    if (!small.isEmpty() && !big.isEmpty() && small.first() > big.first()) {
      int smallPeek = small.pollFirst(), bigPeek = big.pollFirst();
      big.add(smallPeek);
      small.add(bigPeek);
    }
  }


}
