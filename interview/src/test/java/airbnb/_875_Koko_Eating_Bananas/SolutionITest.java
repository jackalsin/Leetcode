package airbnb._875_Koko_Eating_Bananas;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 9/5/2021
 */
class SolutionITest {


  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final int piles[] = {3, 6, 7, 11}, H = 8, expected = 4, actual = solution.minEatingSpeed(piles, H);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final int piles[] = {30, 11, 23, 4, 20}, H = 5, expected = 30, actual = solution.minEatingSpeed(piles, H);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase3(Solution solution) {
    final int piles[] = {30, 11, 23, 4, 20}, H = 6, expected = 23, actual = solution.minEatingSpeed(piles, H);
    assertEquals(expected, actual);
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}