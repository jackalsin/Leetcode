package google._489_Robot_Room_Cleaner;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import utils._489_Robot_Room_Cleaner.RobotImpl;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * @author jacka
 * @version 1.0 on 4/5/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    // 8 ge
    //      1, 1, 1, 1, 1, 0, 1, 1
    //      1, 1, 1, 1*, 1, 0, 1, 1
    //      1, 0, 1, 1, 1, 1, 1, 1
    //      0, 0, 0, 1, 0, 0, 0, 0
    //      1, 1, 1, 1, 1, 1, 1, 1

    //[
    //    // 1 is unvisited
    //    [2, 1, 1, 2, 2, 0, 1, 1],
    //    [1, 1, 1, 2, 2, 0, 1, 1],
    //    [1, 0, 2, 2, 2, 1, 1, 1],
    //    [0, 0, 0, 1, 0, 0, 0, 0],
    //    [1, 1, 1, 1, 1, 1, 1, 1]
    //]
    final int[][] board = {
        {1, 1, 1, 1, 1, 0, 1, 1},
        //       start
        {1, 1, 1, 1, 1, 0, 1, 1},
        {1, 0, 1, 1, 1, 1, 1, 1},
        {0, 0, 0, 1, 0, 0, 0, 0},
        {1, 1, 1, 1, 1, 1, 1, 1},
    }, expected = {
        {2, 2, 2, 2, 2, 0, 2, 2},
        //       start
        {2, 2, 2, 2, 2, 0, 2, 2},
        {2, 0, 2, 2, 2, 2, 2, 2},
        {0, 0, 0, 2, 0, 0, 0, 0},
        {2, 2, 2, 2, 2, 2, 2, 2},
    };
    final int[] start = {1, 3};
    final RobotImpl robot = new RobotImpl(board, start);
    solution.cleanRoom(robot);
    final int[][] actual = robot.getBoard();
    assertArrayEquals(expected, actual);
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}