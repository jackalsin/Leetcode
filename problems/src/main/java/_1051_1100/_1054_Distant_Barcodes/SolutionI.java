package _1051_1100._1054_Distant_Barcodes;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author jacka
 * @version 1.0 on 10/31/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int[] rearrangeBarcodes(int[] barcodes) {
    final Map<Integer, Integer> count = new HashMap<>();
    for (final int b : barcodes) {
      count.put(b, count.getOrDefault(b, 0) + 1);
    }
    final int[] result = new int[barcodes.length];
    final Queue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
        (a, b) -> Integer.compare(b.getValue(), a.getValue()));
    pq.addAll(count.entrySet());
    Queue<Map.Entry<Integer, Integer>> q = new ArrayDeque<>();
    int k = 0;
    while (!pq.isEmpty()) {
      final Map.Entry<Integer, Integer> toRemove = pq.remove();
      final int toRemoveCount = toRemove.getValue();
      if (toRemoveCount != 0) {
        result[k++] = toRemove.getKey();
        toRemove.setValue(toRemoveCount - 1);
        q.add(toRemove);
        if (q.size() > 1) {
          pq.add(q.remove());
        }
      }
    }
    return result;
  }
}
