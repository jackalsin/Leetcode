package _351_400._353_Design_Snake_Game;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 10/9/2017.
 */
public class SnakeGameTest {
  private static final String U = "U";
  private static final String D = "D";
  private static final String L = "L";
  private static final String R = "R";
  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void testOnlineCase() throws Exception {
    final SnakeGame snakeGame = new SnakeGame(3, 2, new int[][]{{1, 2}, {0, 1}});
    assertEquals(0, snakeGame.move(R));
    assertEquals(0, snakeGame.move(D));
    assertEquals(1, snakeGame.move(R));
    assertEquals(1, snakeGame.move(U));
    assertEquals(2, snakeGame.move(L));
    assertEquals(-1, snakeGame.move(U));
  }

  /**
   * Running out of food, food queue is null;
   * @throws Exception
   */
  @Test
  public void testFailedCase() throws Exception {
    final SnakeGame snakeGame = new SnakeGame(2, 2, new int[][]{{0, 1}});
    assertEquals(1, snakeGame.move(R));
    assertEquals(1, snakeGame.move(D));
  }

  /**
   * ["SnakeGame","move","move","move","move","move","move","move","move","move","move","move","move","move","move","move"]
   [[3,3,[[2,0],[0,0],[0,2],[0,1],[2,2],[0,1]]],["D"],["D"],["R"],["U"],["U"],["L"],["D"],["R"],["R"],["U"],["L"],["L"],["D"],["R"],["U"]]
   * @throws Exception
   */
  @Test
  public void testFailedCase2() throws Exception {
    final SnakeGame snakeGame = new SnakeGame(3, 3,
        new int[][]{{2, 0}, {0, 0}, {0, 2}, {0, 1}, {2, 2}, {0, 1}});
    assertEquals(0, snakeGame.move(D));
    assertEquals(1, snakeGame.move(D));
    assertEquals(1, snakeGame.move(R));
    assertEquals(1, snakeGame.move(U));
    assertEquals(1, snakeGame.move(U));
    assertEquals(2, snakeGame.move(L));
    assertEquals(2, snakeGame.move(D));
    assertEquals(2, snakeGame.move(R));
    assertEquals(2, snakeGame.move(R));
    assertEquals(3, snakeGame.move(U));
    assertEquals(4, snakeGame.move(L));
    assertEquals(4, snakeGame.move(L));
    assertEquals(4, snakeGame.move(D));
    assertEquals(4, snakeGame.move(R));
    assertEquals(-1, snakeGame.move(U));
  }

  /**
   * ["SnakeGame","move","move","move","move","move","move","move","move","move","move","move","move"]
   [[3,3,[[2,0],[0,0],[0,2],[2,2]]],["D"],["D"],["R"],["U"],["U"],["L"],["D"],["R"],["R"],["U"],["L"],["D"]]
   * @throws Exception
   */
  @Test
  public void testFailedCase3() throws Exception {
    final SnakeGame snakeGame = new SnakeGame(3, 3,
        new int[][]{{2, 0}, {0, 0}, {0, 2}, {2, 2}});
    assertEquals(0, snakeGame.move(D));
    assertEquals(1, snakeGame.move(D));
    assertEquals(1, snakeGame.move(R));
    assertEquals(1, snakeGame.move(U));
    assertEquals(1, snakeGame.move(U));
    assertEquals(2, snakeGame.move(L));
    assertEquals(2, snakeGame.move(D));
    assertEquals(2, snakeGame.move(R));
    assertEquals(2, snakeGame.move(R));
    assertEquals(3, snakeGame.move(U));
    assertEquals(3, snakeGame.move(L));
    assertEquals(3, snakeGame.move(D));
  }


}
