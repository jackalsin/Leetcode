package _1401_1450._1404_Number_of_Steps_to_Reduce_a_Number_in_Binary_Representation_to_One;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 4/4/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase1(Solution solution) {
    assertEquals(6, solution.numSteps("1101"));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase2(Solution solution) {
    assertEquals(1, solution.numSteps("10"));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase3(Solution solution) {
    assertEquals(0, solution.numSteps("1"));
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new BigIntegerSolution(),
        new BestSolution()
    );
  }
}