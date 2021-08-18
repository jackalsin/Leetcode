package airbnb._015_3Sum;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 1/21/2019.
 */
class SolutionTest {
  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI(),
        new SolutionII()
    );
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void threeSum(Solution solution) {
    final Set<List<Integer>> expected = Set.of(
        List.of(-1, 0, 1),
        List.of(-1, -1, 2)
    );
    final int[] input = new int[]{-1, 0, 1, 2, -1, -4};
    final List<List<Integer>> actual = solution.threeSum(input);
    assertEquals(expected.size(), actual.size());
    assertEquals(new HashSet<>(expected), new HashSet<>(actual));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void threeSumWithDipAnsSymmetric(Solution solution) {
    List<List<Integer>> sampleAnswer = new ArrayList<>();
    sampleAnswer.add(Arrays.asList(-4, 2, 2));
    sampleAnswer.add(Arrays.asList(-2, -2, 4));
    sampleAnswer.add(Arrays.asList(-1, -1, 2));
    sampleAnswer.add(Arrays.asList(-2, 1, 1));
    sampleAnswer.add(Arrays.asList(-2, 0, 2));
    sampleAnswer.add(Arrays.asList(-1, 0, 1));
    sampleAnswer.add(Arrays.asList(-4, 0, 4));
    assertEquals(
        new HashSet<>(sampleAnswer),
        new HashSet<>(solution.threeSum(new int[]{-4, -2, -2, -1, -1, 0, 1, 1, 2, 2, 4}))
    );
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void threeSumWithDipAnsSymmetric2(Solution solution) {
    final int[] nums = {-4, -2, -2, -2, 0, 1, 2, 2, 2, 3, 3, 4, 4, 6, 6};
    final List<List<Integer>> sampleAnswer = List.of(
        List.of(-4, -2, 6),
        List.of(-4, 0, 4),
        List.of(-4, 1, 3),
        List.of(-4, 2, 2),
        List.of(-2, -2, 4),
        List.of(-2, 0, 2)
    );
    final List<List<Integer>> actual = solution.threeSum(nums);
    assertEquals(new HashSet<>(sampleAnswer), new HashSet<>(solution.threeSum(nums)));
    assertEquals(sampleAnswer.size(), actual.size());
  }
}