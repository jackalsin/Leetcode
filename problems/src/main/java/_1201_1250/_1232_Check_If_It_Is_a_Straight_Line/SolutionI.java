package _1201_1250._1232_Check_If_It_Is_a_Straight_Line;

/**
 * @author jacka
 * @version 1.0 on 5/8/2020
 */
public final class SolutionI implements Solution {
  @Override
  public boolean checkStraightLine(int[][] coordinates) {
    if (coordinates == null || coordinates.length < 3) {
      return true;
    }
    final int deltaX = coordinates[1][0] - coordinates[0][0],
        deltaY = coordinates[1][1] - coordinates[0][1];
    for (int i = 2; i < coordinates.length; ++i) {
      final int dx = coordinates[i][0] - coordinates[0][0],
          dy = coordinates[i][1] - coordinates[0][1];
      if (dx * deltaY != deltaX * dy) {
        return false;
      }
    }
    return true;
  }
}
