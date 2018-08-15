package interviews.codeForce.minStepsToNonDecreasing;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {

  public int minStepsToNonIncreasing(final int[] nums) {
    int sum = 0;
    final Queue<Integer> pq = new PriorityQueue<>();

    for (int num : nums) {
      if (!pq.isEmpty() && pq.peek() < num) {
        int diff = num - pq.peek();
        sum += diff;
        pq.remove();
        pq.add(num);
      }
      pq.add(num);
    }
    return sum;
  }

  public int minStepsToNonDecreasing(final int[] nums) {
    int sum = 0;
    final Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

    for (int num : nums) {
      if (!pq.isEmpty() && pq.peek() > num) {
        int dif = pq.peek() - num;
        sum += dif;
        pq.remove(); // pop出最大的，最大值会被移动到次最大与nums[i]之间
        pq.add(num);
      }
      pq.add(num);
    }
    System.out.println(pq.toString());
    return sum;
  }
}
