package _0801_0850._818_Race_Car;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase1(Solution solution) {
    assertEquals(2, solution.racecar(3));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase2(Solution solution) {
    assertEquals(5, solution.racecar(6));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase3(Solution solution) {
    assertEquals(7, solution.racecar(5));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase4(Solution solution) {
    assertEquals(50, solution.racecar(5478));
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new BfsSolution(),
        new DpSolution()
    );
  }
}