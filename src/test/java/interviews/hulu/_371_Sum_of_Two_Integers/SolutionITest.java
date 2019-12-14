package interviews.hulu._371_Sum_of_Two_Integers;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 12/14/2019
 */
class SolutionITest {
  @ParameterizedTest
  @MethodSource("solutionProvider")
  void test1Plus1(Solution solution) {
    assertEquals(4, solution.getSum(2, 2));
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI()
    );
  }
}