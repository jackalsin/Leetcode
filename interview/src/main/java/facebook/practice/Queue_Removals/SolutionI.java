package facebook.practice.Queue_Removals;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author jacka
 * @version 1.0 on 5/3/2021
 */
public final class SolutionI implements Solution {
  @Override
  public int[] findPositions(int[] arr, int x) {
    final Queue<Node> q = new ArrayDeque<>();
    for (int i = 0; i < arr.length; ++i) {
      q.add(new Node(i + 1, arr[i]));
    }
    final int[] result = new int[x];
    for (int t = 0; t < x; ++t) {
      final Queue<Node> removeQueue = new ArrayDeque<>();
      int maxIndex = -1, maxVal = -1;
      for (int i = 0; i < x && !q.isEmpty(); ++i) {
        final Node toRemove = q.remove();
        removeQueue.add(toRemove);
        if (maxVal < toRemove.val) {
          maxVal = toRemove.val;
          maxIndex = toRemove.i;
        }
      }
      while (!removeQueue.isEmpty()) {
        final Node toAdd = removeQueue.remove();
        if (toAdd.i == maxIndex) {
          result[t] = toAdd.i;
        } else {
          if (toAdd.val > 0) toAdd.val--;
          q.add(toAdd);
        }
      }

    }
    return result;
  }

  private static final class Node {
    private final int i;
    private int val;

    private Node(int i, int val) {
      this.i = i;
      this.val = val;
    }
  }
}
