package interviews.uber.intervalMerge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public final class Solution {

  public List<List<Integer>> orOperation(final int[][] p1, final int[][] p2) {
    final List<List<Integer>> result = new ArrayList<>();
    if (p1.length == 0) {
      return Arrays.stream(p2).map(x -> List.of(x[0], x[1])).collect(Collectors.toList());
    } else if (p2.length == 0) {
      return Arrays.stream(p1).map(x -> List.of(x[0], x[1])).collect(Collectors.toList());
    }
    int i = 0, j = 0;
    int[] interval = p1[0][0] < p2[0][0] ? p1[0] : p2[0];
    for (; i < p1.length && j < p2.length; ) {
      if (p1[i][0] <= interval[1]) {
        interval = merge(interval, p1[i]);
        i++;
      } else if (p2[j][0] <= interval[1]) {
        interval = merge(interval, p2[j]);
        j++;
      } else {
        result.add(List.of(interval[0], interval[1]));
        interval = p1[i][0] < p2[j][0] ? p1[i] : p2[j];
      }
    }
    // 每次只动一个
    assert (i < p1.length && j == p2.length) || (i == p1.length && j < p2.length);
    while (i < p1.length) {
      final int[] p = p1[i];
      if (p[0] <= interval[1]) {
        interval = merge(interval, p);
        i++;
      } else {
        result.add(List.of(interval[0], interval[1]));
        interval = p1[i];
      }
    }

    while (j < p2.length) {
      final int[] p = p2[j];
      if (p[0] <= interval[1]) {
        interval = merge(interval, p);
        j++;
      } else {
        result.add(List.of(interval[0], interval[1]));
        interval = p2[j];
      }
    }
    result.add(List.of(interval[0], interval[1]));
    return result;
  }

  private static int[] merge(final int[] i, final int[] j) {
    return new int[]{Math.min(i[0], j[0]), Math.max(i[1], j[1])};
  }
}
