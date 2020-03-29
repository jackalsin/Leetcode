package _1351_1400._1396_Design_Underground_System;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/**
 * @author jacka
 * @version 1.0 on 3/28/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase1(Solution solution) {
    solution.checkIn(873562, "7PY3O0JV", 85);
    solution.checkOut(873562, "LEF142E5", 180);
    solution.checkIn(285106, "AUCG6WDZ", 192);
    solution.checkIn(285106, "AUCG6WDZ", 192);
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI()
    );
  }
}