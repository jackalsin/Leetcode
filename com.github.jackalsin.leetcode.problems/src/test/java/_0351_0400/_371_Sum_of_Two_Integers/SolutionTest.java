package _0351_0400._371_Sum_of_Two_Integers;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void test1Plus1(Solution solution) {
    assertEquals(4, solution.getSum(2, 2));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new Solution()
    );
  }
}