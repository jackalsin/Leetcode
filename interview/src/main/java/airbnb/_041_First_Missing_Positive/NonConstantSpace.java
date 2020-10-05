package airbnb._041_First_Missing_Positive;

/**
 * @author jacka
 * @version 1.0 on 1/22/2019.
 */
public final class NonConstantSpace implements Solution {
  public int firstMissingPositive(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 1;
    }
    final boolean[] visited = new boolean[nums.length];
    for (int num : nums) {
      if (num > 0 && num <= visited.length) {
        visited[num - 1] = true;
      }
    }

    for (int i = 0; i < visited.length; i++) {
      if (!visited[i]) {
        return i + 1;
      }
    }

    // [1, 2, 3, 4] -> [T, T, T , T] -> len + 1
    // [0, 1, 2] -> [T, T, F] -> 2 + 1
    // [] -> this will arrive here
    return nums.length + 1;
  }
}
