package _451_500._489_Robot_Room_Cleaner;

import utils.robot.Robot;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class Solution {
  private static final Point UP = new Point(-1, 0),
      RIGHT = new Point(0, 1), DOWN = new Point(1, 0),
      LEFT = new Point(0, -1);

  private static final Point[] DIRS = {UP, RIGHT, DOWN, LEFT};

  private static final Map<Point, Integer> DIR_TO_INDEX = new HashMap<>();

  static {
    DIR_TO_INDEX.put(UP, 0);
    DIR_TO_INDEX.put(RIGHT, 1);
    DIR_TO_INDEX.put(DOWN, 2);
    DIR_TO_INDEX.put(LEFT, 3);
  }

  public void cleanRoom(Robot robot) {
    final Set<Point> visited = new HashSet<>();
    final Point start = new Point(0, 0);
    visited.add(start);
    dfs(robot, visited, start, UP);
  }

  private void dfs(final Robot robot, final Set<Point> visited, final Point start, final Point preDir) {
    System.out.println(start);

    robot.clean();
    final int adjustToUp = DIR_TO_INDEX.get(preDir);
    for (int i = 0; i < adjustToUp; i++) {
      System.out.println(start + "\tLeft");
      robot.turnLeft();
    }

    for (final Point dir : DIRS) {
      final Point nextPoint = new Point(start.x + dir.x, start.y + dir.y);
      System.out.print("\tTrying to move to " + nextPoint + " ... ");
      if (visited.contains(nextPoint)) {
        System.out.println("Failed");
        System.out.println(start + "\tRight");
        robot.turnRight();
        continue;
      }
      visited.add(nextPoint);
      if (robot.move()) {
        System.out.println("Succeed");
        System.out.println(start + "\tMove to " + nextPoint);
        dfs(robot, visited, nextPoint, dir);
      } else {
        System.out.println("Failed");
        visited.remove(nextPoint);
      }
      System.out.println(start + "\tRight");

      robot.turnRight();
    }

    // now face up
    // we want to go back
    final int adjustToBack = DIR_TO_INDEX.get(new Point(-preDir.x, -preDir.y));
    for (int i = 0; i < adjustToBack; i++) {
      System.out.println(start + "\tRight");
      robot.turnRight();
    }

    robot.move();

    // turn 180
    System.out.println(start + "\tLeft");
    robot.turnLeft();
    System.out.println(start + "\tLeft");
    robot.turnLeft();

  }


  private static class Point {
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
      return "Point{" +
          "x=" + x +
          ", y=" + y +
          '}';
    }
  }
}
