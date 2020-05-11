package _1301_1350._1349_Maximum_Students_Taking_Exam;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 2/8/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final char[][] input = {
        {'#', '.', '#', '#', '.', '#'},
        {'.', '#', '#', '#', '#', '.'},
        {'#', '.', '#', '#', '.', '#'}
    };
    assertEquals(4, solution.maxStudents(input));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final char[][] input = {
        {'.', '#'},
        {'#', '#'},
        {'#', '.'},
        {'#', '#'},
        {'.', '#'}
    };
    assertEquals(3, solution.maxStudents(input));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase3(Solution solution) {
    final char[][] input = {
        {'#', '.', '#'},
        {'#', '#', '.'},
        {'.', '#', '.'}
    };
    assertEquals(3, solution.maxStudents(input));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}