package _0451_0500._497_Random_Point_in_Non_overlapping_Rectangles;

import java.util.Random;
import java.util.TreeMap;

public final class Solution {
  private final int[][] rects;

  private final int sum;

  private final TreeMap<Integer, Integer> treeMap = new TreeMap<>();

  private final Random rand = new Random();

  public Solution(int[][] rects) {
    int sum = 0;
    for (int i = 0; i < rects.length; i++) {
      final int[] rect = rects[i];
      sum += (rect[3] - rect[1] + 1) * (rect[2] - rect[0] + 1);
      treeMap.put(sum, i);
    }
    this.sum = sum;
    this.rects = rects;
  }

  public int[] pick() {
    final int randIndex = rand.nextInt(sum);
    final int rectIndex = treeMap.higherEntry(randIndex).getValue();
    final int[] rect = rects[rectIndex];
    return new int[]{rect[0] + rand.nextInt(rect[2] - rect[0] + 1),
        rect[1] + rand.nextInt(rect[3] - rect[1] + 1)};
  }
}
