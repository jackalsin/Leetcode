package _1001_1050._1041_Robot_Bounded_In_Circle;

public final class Solution {
  private static final char L = 'L', R = 'R', G = 'G';
  private static final int[][] DIRS = {
      {-1, 0}, {0, -1}, {1, 0}, {0, 1}
  };

  public boolean isRobotBounded(String instructions) {
    int x = 0, y = 0, dirIndex = 0;
    for (char chr : instructions.toCharArray()) {
      if (chr == L) {
        dirIndex = (dirIndex + 1) % DIRS.length;
      } else if (chr == R) {
        dirIndex = (dirIndex + 3) % DIRS.length;
      } else {
        assert chr == G;
        x += DIRS[dirIndex][0];
        y += DIRS[dirIndex][1];
      }
    }
    // as long as distance != 0 || dirIndex is changed, it will circle
    return (x == 0 && y == 0) || dirIndex != 0;
  }
}
