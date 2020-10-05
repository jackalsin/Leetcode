package _1351_1400._1394_Find_Lucky_Integer_in_an_Array;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 3/28/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final int arr[] = {2, 2, 3, 4}, expected = 2;
    assertEquals(expected, solution.findLucky(arr));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final int arr[] = {2, 2, 2, 3, 4}, expected = -1;
    assertEquals(expected, solution.findLucky(arr));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}