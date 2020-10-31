package _1051_1100._1052_Grumpy_Bookstore_Owner;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 10/31/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase1(Solution solution) {
    final int customers[] = {1, 0, 1, 2, 1, 1, 7, 5},
        grumpy[] = {0, 1, 0, 1, 0, 1, 0, 1}, X = 3, expected = 16,
        actual = solution.maxSatisfied(customers, grumpy, X);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase2(Solution solution) {
    final int customers[] = {10, 1, 7},
        grumpy[] = {0, 0, 0}, X = 2, expected = 18,
        actual = solution.maxSatisfied(customers, grumpy, X);
    assertEquals(expected, actual);
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI()
    );
  }
}