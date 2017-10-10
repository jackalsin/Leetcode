package _351_400._353_Design_Snake_Game;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 10/9/2017.
 */
public class SnakeGame {
  private final Deque<Coordinate> snake;
  private final Set<Coordinate> bodies;
  private final int width;
  private final int height;
  private final Queue<int[]> food;
  private int score;
  /** Initialize your data structure here.
   @param width - screen width
   @param height - screen height
   @param food - A list of food positions
   E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
  public SnakeGame(int width, int height, int[][] food) {
    snake = new ArrayDeque<>();
    bodies = new HashSet<>();
    bodies.add(new Coordinate(0, 0));
    snake.addFirst(new Coordinate(0, 0));
    this.width = width;
    this.height = height;
    this.food = new ArrayDeque<>();
    this.food.addAll(Arrays.asList(food));
  }

  /** Moves the snake.
   @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
   @return The game's score after the move. Return -1 if game over.
   Game over when snake crosses the screen boundary or bites its body. */
  public int move(String direction) {
    switch (direction) {
      case "U": move(0, -1); break;
      case "D": move(0, 1); break;
      case "L": move(-1, 0); break;
      case "R": move(1, 0); break;
      default:
        throw new IllegalArgumentException("Illegal direction = '" + direction + "'");
    }
    return score;
  }

  private void move(int x, int y) {
    final int[] food = this.food.peek();
    final Coordinate head = snake.peekFirst();
    final Coordinate newHead = new Coordinate (head.x + x, head.y+ y);
    if (newHead.x < 0 || newHead.x >= width || newHead.y < 0 || newHead.y >= height) {
      score = -1;
      return;
    }
    if (food != null && food[1] == newHead.x && food[0] == newHead.y) {
      score++;
      this.food.poll();
    } else {
      bodies.remove(snake.pollLast());
    }

    if(!bodies.add(newHead)) { // add -> true -> no dup -> no body crossing
      score = -1;
    } else {
      snake.addFirst(newHead);
    }
  }

  private static class Coordinate {
    final int x;
    final int y;

    Coordinate(int x, int y) {
      this.x = x;
      this.y = y;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (!(o instanceof Coordinate)) {
        return false;
      }

      Coordinate that = (Coordinate) o;

      return x == that.x && y == that.y;
    }

    @Override
    public int hashCode() {
      int result = x;
      result = 31 * result + y;
      return result;
    }

    @Override
    public String toString() {
      return "Coordinate{" +
          "x=" + x +
          ", y=" + y +
          '}';
    }
  }

}
