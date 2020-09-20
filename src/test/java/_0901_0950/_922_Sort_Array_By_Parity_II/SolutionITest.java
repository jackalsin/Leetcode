package _0901_0950._922_Sort_Array_By_Parity_II;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 9/19/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final int[] input = {4, 2, 5, 7},
        actual = solution.sortArrayByParityII(input);
    assertValid(actual);
  }

  public static void assertValid(final int[] vals) {
    for (int i = 0; i < vals.length; ++i) {
      if (i % 2 == 0) {
        assertTrue(vals[i] % 2 == 0);
      } else {
        assertTrue(vals[i] % 2 != 0);
      }
    }
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}