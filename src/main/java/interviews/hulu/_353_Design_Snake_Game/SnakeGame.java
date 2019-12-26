package interviews.hulu._353_Design_Snake_Game;

/**
 * @author jacka
 * @version 1.0 on 12/25/2019
 */
public interface SnakeGame {

  /**
   * Moves the snake.
   *
   * @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
   * @return The game's score after the move. Return -1 if game over.
   * Game over when snake crosses the screen boundary or bites its body.
   */
  int move(String direction);
}
