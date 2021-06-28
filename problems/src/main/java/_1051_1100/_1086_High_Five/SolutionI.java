package _1051_1100._1086_High_Five;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author jacka
 * @version 1.0 on 6/27/2021
 */
public final class SolutionI implements Solution {
  private static final int SIZE = 5;

  public int[][] highFive(int[][] items) {
    final Map<Integer, Queue<Integer>> idToScores = new HashMap<>();
    for (final int[] item : items) {
      final Queue<Integer> scores = idToScores.computeIfAbsent(item[0],
          k -> new PriorityQueue<>(Integer::compare));
      scores.add(item[1]);
      if (scores.size() > SIZE) scores.remove();
    }
    final int[][] unsorted =
        idToScores.entrySet().stream().map(e -> new int[]{e.getKey(),
            e.getValue().stream().mapToInt(x -> x).sum() / SIZE}).toArray(int[][]::new);

    Arrays.sort(unsorted, Comparator.comparingInt(o -> o[0]));
    return unsorted;
  }
}
