package linkedin._070_Climbing_Stairs;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testWith1(Solution solution) {
    assertEquals(1, solution.climbStairs(1));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testWith2(Solution solution) {
    assertEquals(2, solution.climbStairs(2));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testWith3(Solution solution) {
    assertEquals(3, solution.climbStairs(3));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testWith4(Solution solution) {
    assertEquals(5, solution.climbStairs(4));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI(),
        new SolutionII(),
        new SolutionIII()
    );
  }
}