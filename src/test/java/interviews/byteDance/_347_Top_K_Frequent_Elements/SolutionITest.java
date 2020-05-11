package interviews.byteDance._347_Top_K_Frequent_Elements;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * @author jacka
 * @version 1.0 on 5/8/2020
 */
class SolutionITest {
  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase(Solution solution) throws Exception {
    final int[] nums = {1, 1, 1, 2, 2, 3};
    final int[] actual = solution.topKFrequent(nums, 2), expected = {1, 2};
    assertArrayEquals(expected, actual);
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}