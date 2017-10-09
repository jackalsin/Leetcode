package _351_400._353_Design_Snake_Game;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * @author jacka
 * @version 1.0 on 10/9/2017.
 */
public class SnakeGame {
  private final Queue<int[]> snake;

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
    snake.add(new int[] {0, 0});
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
      case "U": move(1, 0); break;
      case "D": move(-1, 0); break;
      case "L": move(0, -1); break;
      case "R": move(0, 1); break;
      default:
        throw new IllegalArgumentException("Illegal direction = '" + direction + "'");
    }
    return score;
  }

  private void move(int x, int y) {
    final int[] food = this.food.peek();
    final int[] head = snake.peek();
    int[] newHead = new int[] {head[0] + x, head[1] + y};

  }

}
