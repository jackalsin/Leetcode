package linkedin._013_Roman_to_Integer;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionIITest {
  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI(),
        new SolutionII(),
        new SolutionIII()
    );
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOneDigit(Solution solution) {
    assertEquals(9, solution.romanToInt("IX"));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testMCMXCIV(Solution solution) {
    assertEquals(1994, solution.romanToInt("MCMXCIV"));
  }
}