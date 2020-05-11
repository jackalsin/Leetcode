package interviews.google._163_Missing_Ranges;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 3/29/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testEmpty(Solution solution) {
    assertEquals(Arrays.asList("1"), solution.findMissingRanges(new int[]{}, 1, 1));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testSingle(Solution solution) {
    assertEquals(new ArrayList<>(), solution.findMissingRanges(new int[]{-1}, -1, -1));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testEmptyArrayOneInterval(Solution solution) {
    assertEquals(Collections.singletonList("1"), solution.findMissingRanges(new int[]{}, 1, 1));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testLeading(Solution solution) {
    final int[] input = new int[]{0, 1, 3, 50, 75};
    assertEquals(Arrays.asList("2", "4->49", "51->74", "76->99"), solution.findMissingRanges(input,
        0, 99));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOverflow(Solution solution) {
    assertEquals(Arrays.asList("0->2147483646"), solution.findMissingRanges(new
        int[]{2147483647}, 0, Integer
        .MAX_VALUE));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}