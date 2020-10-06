package template._01;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author jacka
 * @version 1.0 on 9/19/2020
 */
public final class SolutionI implements Solution {
  public static int maxMin(List<Integer> arr, int k) {
    // Write your code here
    final Queue<Integer> pq = new PriorityQueue<>((x, y) -> Integer.compare(x, y));
    for (int i = 0; i < k; ++i) {
      pq.add(arr.get(i));
    }
    assert !pq.isEmpty();
    int max = pq.peek();

    for (int i = k; i < arr.size(); ++i) {
      pq.remove(arr.get(i - k));
      pq.add(arr.get(i));
      max = Math.max(max, pq.peek());
    }
    return max;
  }
//
//  public static int maxMin(List<Integer> arr, int k) {
//    // Write your code here
//    int max = 0;
//    for (int i = 0; i + k <= arr.size(); ++i) {
//      int min = arr.get(i);
//      for (int j = 1; j < k; ++j) {
//        min = Math.min(min, arr.get(j + i));
//      }
//      max = Math.max(max, min);
//    }
//    return max;
//  }


  public static void main(final String[] args) {
    final int case1 = maxMin(List.of(1, 2, 3, 4, 5), 2);
    System.out.println(case1);
  }
}
