package facebook.practice.Counting_Triangles;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 5/2/2021
 */
public final class SolutionI implements Solution {
  @Override
  public int countDistinctTriangles(ArrayList<Sides> arr) {
    final List<List<Integer>> sorted = new ArrayList<>();
    for (final Sides sides : arr) {
      final List<Integer> cur = new ArrayList<>(Arrays.asList(sides.a, sides.b, sides.c));
      Collections.sort(cur);
      if (cur.get(0) + cur.get(1) > cur.get(2)) {
        sorted.add(cur);
      }
    }
    sorted.sort((x, y) -> {
      final int a = Integer.compare(x.get(0), y.get(0));
      if (a != 0) return a;
      final int b = Integer.compare(x.get(1), y.get(1));
      if (b != 0) return b;
      return Integer.compare(x.get(2), y.get(2));
    });
    int count = 1;
    for (int i = 1; i < sorted.size(); ++i) {
      final List<Integer> prev = sorted.get(i - 1), cur = sorted.get(i);
      if (!prev.equals(cur)) count++;
    }
    return count;
  }
}
