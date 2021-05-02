package facebook.practice.Minimizing_Permutations;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author jacka
 * @version 1.0 on 5/1/2021
 */
public final class SolutionI implements Solution {

  public int minOperations(int[] arr) {
    final List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
    final Queue<List<Integer>> q = new ArrayDeque<>() {{
      add(list);
    }};
    final Set<List<Integer>> visited = new HashSet<>() {{
      add(new ArrayList<>(list));
    }};
    int target = 0;
    while (!q.isEmpty()) {
      final int size = q.size();
      for (int s = 0; s < size; ++s) {
        final List<Integer> toRemove = q.remove();
        if (isSorted(toRemove)) return target;
        for (int i = 0; i < list.size(); ++i) {
          for (int j = i + 1; j < list.size(); ++j) {
            reverse(toRemove, i, j);
            final List<Integer> next = new ArrayList<>(toRemove);
            if (visited.add(next)) {
              q.add(next);
            }
            reverse(toRemove, i, j);
          }
        }
      } // end for
      target++;
    }
    return -1; // not possible
  }

  private static void reverse(final List<Integer> list, final int start, final int end) {
    for (int i = start, j = end; i < j; ++i, --j) {
      swap(list, i, j);
    }
  }

  private static void swap(final List<Integer> list, final int i, final int j) {
    final int tmp = list.get(i);
    list.set(i, list.get(j));
    list.set(j, tmp);
  }

  private static boolean isSorted(final List<Integer> list) {
    for (int i = 0; i < list.size(); ++i) {
      if (list.get(i) != i + 1) return false;
    }
    return true;
  }
}
