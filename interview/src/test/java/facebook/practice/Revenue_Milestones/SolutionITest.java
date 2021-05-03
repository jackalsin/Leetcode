package facebook.practice.Revenue_Milestones;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * @author jacka
 * @version 1.0 on 5/2/2021
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    int revenues_1[] = {100, 200, 300, 400, 500};
    int milestones_1[] = {300, 800, 1000, 1400};
    int expected_1[] = {2, 4, 4, 5};
    int[] output_1 = solution.getMilestoneDays(revenues_1, milestones_1);
    assertArrayEquals(expected_1, output_1, Arrays.toString(output_1));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    int revenues_2[] = {700, 800, 600, 400, 600, 700};
    int milestones_2[] = {3100, 2200, 800, 2100, 1000};
    int expected_2[] = {5, 4, 2, 3, 2};
    int[] output_2 = solution.getMilestoneDays(revenues_2, milestones_2);
    assertArrayEquals(expected_2, output_2, Arrays.toString(output_2));

  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}