package interviews.hulu._353_Design_Snake_Game;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 12/25/2019
 */
public final class SnakeGameI implements SnakeGame {
  private static final String U = "U", D = "D", L = "L", R = "R";

  private final int cols, rows;
  private final Deque<Point> snakeQueue = new LinkedList<>();
  private final Set<Point> snakeSet = new HashSet<>();

  private final Queue<Point> food = new ArrayDeque<>();
  private int score = 0;

  /**
   * Initialize your data structure here.
   *
   * @param width  - screen width
   * @param height - screen height
   * @param food   - A list of food positions
   *               E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0].
   */
  public SnakeGameI(int width, int height, int[][] food) {
    this.cols = width;
    this.rows = height;
    for (final int[] f : food) {
      this.food.add(new Point(f[0], f[1]));
    }
    final Point p = new Point(0, 0);
    snakeQueue.addLast(p);
    snakeSet.add(p);
  }

  /**
   * Moves the snake.
   *
   * @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
   * @return The game's score after the move. Return -1 if game over.
   * Game over when snake crosses the screen boundary or bites its body.
   */
  public int move(String direction) {
//    System.out.println(direction + ", snake = " + snakeQueue);
    switch (direction) {
      case U:
        move(-1, 0);
        break;
      case D:
        move(1, 0);
        break;
      case L:
        move(0, -1);
        break;
      case R:
        move(0, 1);
        break;
      default:
        throw new IllegalArgumentException("Unsupported operation = " + direction);
    }
    return score;
  }

  private void move(final int xDiff, final int yDiff) {
    final Point head = snakeQueue.peekFirst();
    final int nextRow = head.row + xDiff, nextCol = head.col + yDiff;
    if (!isValid(rows, cols, nextRow, nextCol)) {
      score = -1;
      return;
    }
    final Point newHead = new Point(nextRow, nextCol), toRemove = snakeQueue.removeLast();
    snakeSet.remove(toRemove);
    if (snakeSet.contains(newHead)) {
      score = -1;
      return;
    }
    snakeQueue.addFirst(newHead);
    snakeSet.add(newHead);
    if (food.isEmpty()) return;
    if (food.peek().equals(snakeQueue.peekFirst())) {
      score++;
      food.remove();
      snakeSet.add(toRemove);
      snakeQueue.addLast(toRemove);
    }
  }

  private static boolean isValid(final int rows, final int cols, final int row, final int col) {
    return 0 <= row && row < rows && 0 <= col && col < cols;
  }

  private static final class Point {
    private final int row, col;

    private Point(int row, int col) {
      this.row = row;
      this.col = col;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (!(o instanceof Point)) return false;
      Point point = (Point) o;
      return row == point.row &&
          col == point.col;
    }

    @Override
    public int hashCode() {
      return Objects.hash(row, col);
    }

    @Override
    public String toString() {
      return "Point{" +
          "row=" + row +
          ", col=" + col +
          '}';
    }
  }
}
