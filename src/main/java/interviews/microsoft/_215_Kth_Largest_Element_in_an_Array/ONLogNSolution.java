package interviews.microsoft._215_Kth_Largest_Element_in_an_Array;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public final class ONLogNSolution implements Solution {

  public int findKthLargest(int[] nums, int k) {
    assert 0 < nums.length;
    assert 0 < k && k <= nums.length;
    final Queue<Integer> pq = new PriorityQueue<>(new Comparator<>() {

      @Override
      public int compare(Integer o1, Integer o2) {
        return Integer.compare(o1, o2);
      }
    });

    for (int num : nums) {
      pq.add(num);
      if (pq.size() > k) {
        pq.remove();
      }
    }
    return pq.peek();
  }
}
