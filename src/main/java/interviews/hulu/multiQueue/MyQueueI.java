package interviews.hulu.multiQueue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Queue;

/**
 * @author jacka
 * @version 1.0 on 12/16/2019
 */
public final class MyQueueI implements MultiQueue {
  private final LinkedHashSet<int[]> arrays = new LinkedHashSet<>();
  private Queue<Integer> q = new ArrayDeque<>();

  @Override
  public void add(int[] arr) {
    arrays.add(arr);
  }

  @Override
  public List<Integer> read(int k) {
    final List<Integer> result = new ArrayList<>();
    while (result.size() < k) {
      if (q.isEmpty()) {
        final int[] toRemove = arrays.iterator().next();
        arrays.remove(toRemove);
        Arrays.stream(toRemove).forEach(e -> q.add(e));
      }
      result.add(q.remove());
    }
    return result;
  }

  @Override
  public void remove(int[] arr) {
    arrays.remove(arr);
  }
}
