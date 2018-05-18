package interviews.pinterest.guiPin;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
  /**
   * Time Complexity: O(Max(numCol, Log(numCol) * heights.length ))
   *
   * @param heights
   * @param width
   * @param numColumns
   * @param padding
   * @return
   */
  public List<List<Integer>> getPinList(final int[] heights,
                                        final int width,
                                        final int numColumns,
                                        final int padding) {
    /* List.of(column, height) */
    final Queue<List<Integer>> queue = new PriorityQueue<>(
        new Comparator<>() {
          @Override
          public int compare(List<Integer> i, List<Integer> j) {
            int cmp = Integer.compare(i.get(1), j.get(1));
            if (cmp == 0) {
              return Integer.compare(i.get(0), j.get(0));
            }
            return cmp;
          }
        }
    );

    for (int i = 0; i < numColumns; i++) {
      queue.add(List.of(i, 0));
    }
    final int columnWidth = width / numColumns;
    final List<List<Integer>> result = new ArrayList<>();
    for (int i = 0; i < heights.length; i++) {
      final int height = heights[i];
      final List<Integer> curBottom = queue.remove();
      result.add(List.of(curBottom.get(0) * columnWidth + padding,
          curBottom.get(1) + padding));
      queue.add(List.of(curBottom.get(0), curBottom.get(1) + padding + height + padding));
    }

    return result;
  }
}
