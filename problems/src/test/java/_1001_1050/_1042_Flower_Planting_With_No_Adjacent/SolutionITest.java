package _1001_1050._1042_Flower_Planting_With_No_Adjacent;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author jacka
 * @version 1.0 on 10/24/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase1(Solution solution) {
    final int n = 3, paths[][] = {{1, 2}, {2, 3}, {3, 1}},
        expected[] = {1, 2, 3}, actual[] = solution.gardenNoAdj(n, paths);
    assertArrayEquals(expected, actual, "actual = " + Arrays.toString(actual));
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI()
    );
  }
}