package byteDance._480_Sliding_Window_Median;

import java.util.Comparator;
import java.util.TreeMap;

/**
 * @author jacka
 * @version 1.0 on 3/22/2021
 */
public final class SolutionI implements Solution {
  @Override
  public double[] medianSlidingWindow(int[] nums, int k) {
    k = Math.min(nums.length, k); // in case of k > nums.length
    final double[] result = new double[nums.length - k + 1];
    final Pq left = new Pq((x, y) -> Integer.compare(y, x)),
        right = new Pq();
    for (int i = 0; i < nums.length; ++i) {
      left.add(nums[i]);
      right.add(left.remove());
      if (right.size() > left.size()) {
        left.add(right.remove());
      }
      if (i >= k - 1) {
        if (i >= k) {
          final int toRemove = nums[i - k];
          if (left.peek() >= toRemove) {
            left.remove(toRemove);
          } else {
            right.remove(toRemove);
          }
          if (left.count > right.count + 1) {
            right.add(left.remove());
          } else if (left.count == right.count + 1 || left.count == right.count) {
          } else {
            assert left.count < right.count;
            left.add(right.remove());
          }
        }
//        System.out.println("left = " + left + ", right = " + right);
        result[i - k + 1] = k % 2 == 0 ? (((double) left.peek() + right.peek()) / 2d) : left.peek();
      } // end of k
    }
    return result;
  }

  private static final class Pq {
    private final TreeMap<Integer, Integer> pq;
    private int count = 0;

    private Pq() {
      this.pq = new TreeMap<>();
    }

    private Pq(final Comparator<Integer> cmp) {
      this.pq = new TreeMap<>(cmp);
    }

    private int peek() {
      return pq.firstKey();
    }

    private void add(final int v) {
      pq.put(v, pq.getOrDefault(v, 0) + 1);
      count++;
    }

    private int remove(final int key) {
      final Integer oldVal = pq.get(key);
      assert oldVal != null;
      count--;
      if (oldVal == 1) {
        pq.remove(key);
      } else {
        pq.put(key, oldVal - 1);
      }
      return key;
    }

    private int remove() {
      final Integer e = pq.firstKey();
      return remove(e);
    }

    private int size() {
      return count;
    }

    @Override
    public String toString() {
      return "Pq{" +
          "pq=" + pq +
          ", count=" + count +
          '}';
    }
  }
}
