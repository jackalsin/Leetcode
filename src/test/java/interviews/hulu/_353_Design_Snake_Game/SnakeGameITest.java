package interviews.hulu._353_Design_Snake_Game;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.lang.reflect.InvocationTargetException;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 12/25/2019
 */
class SnakeGameITest {

  private static final String U = "U", D = "D", L = "L", R = "R";

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testOnlineCase(Class<SnakeGame> solutionClass) throws NoSuchMethodException, IllegalAccessException,
      InvocationTargetException, InstantiationException {
    final SnakeGame snakeGame = solutionClass.getConstructor(Integer.TYPE,
        Integer.TYPE, int[][].class)
        .newInstance(3, 2, new int[][]{{1, 2}, {0, 1}});
    assertEquals(0, snakeGame.move(R));
    assertEquals(0, snakeGame.move(D));
    assertEquals(1, snakeGame.move(R));
    assertEquals(1, snakeGame.move(U));
    assertEquals(2, snakeGame.move(L));
    assertEquals(-1, snakeGame.move(U));
  }

  /**
   * Running out of food, food queue is null;
   */
  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testFailedCase(Class<SnakeGame> solutionClass) throws NoSuchMethodException, IllegalAccessException,
      InvocationTargetException, InstantiationException {
    final SnakeGame snakeGame = solutionClass.getConstructor(Integer.TYPE, Integer.TYPE, int[][].class)
        .newInstance(2, 2, new int[][]{{0, 1}});
    assertEquals(1, snakeGame.move(R));
    assertEquals(1, snakeGame.move(D));
  }

  /**
   * ["SnakeGame","move","move","move","move","move","move","move","move","move","move","move","move","move","move",
   * "move"]
   * [[3,3,[[2,0],[0,0],[0,2],[0,1],[2,2],[0,1]]],["D"],["D"],["R"],["U"],["U"],["L"],["D"],["R"],["R"],["U"],["L"],
   * ["L"],["D"],["R"],["U"]]
   */
  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testFailedCase2(Class<SnakeGame> solutionClass) throws NoSuchMethodException, IllegalAccessException,
      InvocationTargetException, InstantiationException {
    final SnakeGame snakeGame = solutionClass.getConstructor(Integer.TYPE, Integer.TYPE, int[][].class)
        .newInstance(3, 3, new int[][]{{2, 0}, {0, 0}, {0, 2}, {0, 1}, {2, 2}, {0, 1}});
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
   * [[3,3,[[2,0],[0,0],[0,2],[2,2]]],["D"],["D"],["R"],["U"],["U"],["L"],["D"],["R"],["R"],["U"],["L"],["D"]]
   *
   * @throws Exception
   */
  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testFailedCase3(Class<SnakeGame> solutionClass) throws NoSuchMethodException, IllegalAccessException,
      InvocationTargetException, InstantiationException {
    final SnakeGame snakeGame = solutionClass.getConstructor(Integer.TYPE, Integer.TYPE, int[][].class)
        .newInstance(3, 3, new int[][]{{2, 0}, {0, 0}, {0, 2}, {2, 2}});
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

  static Stream<Class> solutionStream() {
    return Stream.of(
        SnakeGameI.class
    );
  }
}