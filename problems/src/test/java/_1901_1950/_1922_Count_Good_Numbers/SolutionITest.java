package _1901_1950._1922_Count_Good_Numbers;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 7/3/2021
 */
class SolutionITest {
  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    assertEquals(5, solution.countGoodNumbers(1));
    assertEquals(400, solution.countGoodNumbers(4));
    assertEquals(2000, solution.countGoodNumbers(5));
    assertEquals(8000, solution.countGoodNumbers(6));
    assertEquals(564908303, solution.countGoodNumbers(50));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}