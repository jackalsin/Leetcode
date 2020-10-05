package _1001_1050._1033_Moving_Stones_Until_Consecutive;

import java.util.Arrays;

public final class Solution {
  public int[] numMovesStones(int a, int b, int c) {
    final int[] input = {a, b, c};
    Arrays.sort(input);
    return new int[]{numMovesStonesMin(input), input[2] - input[0] - 2};
  }

  private static int numMovesStonesMin(final int[] input) {
    if (isConsective(input)) {
      return 0;
    } else if (input[0] + 1 == input[1] || input[1] + 1 == input[2]
        || input[0] + 2 == input[1] || input[1] + 2 == input[2]) {
      return 1;
    } else {
      return 2;
    }
  }

  private static boolean isConsective(final int[] input) {
    return input[0] + 1 == input[1] && input[1] + 1 == input[2];
  }
}
