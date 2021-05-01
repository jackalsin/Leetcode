package facebook.practice.Reverse_to_Make_Equal;

/**
 * @author jacka
 * @version 1.0 on 4/30/2021
 */
public final class SolutionI implements Solution {
  @Override
  public boolean areTheyEqual(int[] array_a, int[] array_b) {
    if (array_a == null) return true;
    final int n = array_a.length;
    int start = n, end = -1;
    for (int i = 0; i < n; ++i) {
      if (array_a[i] == array_b[i]) {
      } else {
        start = Math.min(start, i);
        end = Math.max(end, i);
      }
    }
    for (int i = start, j = end; i <= end; ++i, --j) {
      if (array_a[i] != array_b[j]) return false;
    }
    return true;
  }
}
