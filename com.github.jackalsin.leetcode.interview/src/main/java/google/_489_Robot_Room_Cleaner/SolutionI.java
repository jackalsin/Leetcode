package google._489_Robot_Room_Cleaner;

import utils._489_Robot_Room_Cleaner.Robot;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 4/5/2020
 */
public final class SolutionI implements Solution {
  private final boolean isDebug = false;
  private static final int[] RIGHT = {0, 1}, LEFT = {0, -1}, DOWN = {1, 0}, UP = {-1, 0};
  private static final int[][] DIRS = {
      DOWN, LEFT, UP, RIGHT
  };
  private final Set<Point> visited = new HashSet<>();

  public void cleanRoom(Robot robot) {
    final Point start = new Point(1, 3);
    visited.add(start);
    dfs(robot, start, 0);
  }

  private void dfs(final Robot robot, final Point start, final int prevDirIndex) {
    log("Cleaning " + start + ", robot = " + robot);
    robot.clean();
    for (int diff = 0; diff < DIRS.length; ++diff) {
      final int index = (prevDirIndex + diff) % 4;
      final int[] dir = DIRS[index];
      final int nextX = dir[0] + start.x,
          nextY = dir[1] + start.y;
      final Point nextP = new Point(nextX, nextY);
      if (!visited.contains(nextP) && robot.move()) {
        visited.add(nextP);
        dfs(robot, nextP, index);
        // point to original
        robot.turnRight();
        robot.turnRight();
      }
      robot.turnRight();
    }
    // turn around, prepare back to space
    robot.turnRight();
    robot.turnRight();
    robot.move();
  }

  private static final class Point {
    private final int x, y;

    private Point(int x, int y) {
      this.x = x;
      this.y = y;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Point point = (Point) o;
      return x == point.x &&
          y == point.y;
    }

    @Override
    public int hashCode() {
      return Objects.hash(x, y);
    }

    @Override
    public String toString() {
      return "[" + x + ", " + y + ']';
    }
  }

  private void log(String message) {
    if (isDebug) {
      System.out.println(message);
    }
  }
}
