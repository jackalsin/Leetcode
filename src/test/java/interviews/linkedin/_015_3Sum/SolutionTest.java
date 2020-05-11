package interviews.linkedin._015_3Sum;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {


  @ParameterizedTest
  @MethodSource("solutionStream")
  void threeSum(Solution solution) {
    final List<List<Integer>> expected = List.of(
        List.of(-1, 0, 1),
        List.of(-1, -1, 2)
    );
    final List<List<Integer>> actual = solution.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
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
  void threeSumWithDupAnsSymmetric(Solution solution) {
    List<List<Integer>> sampleAnswer = new ArrayList<>();
    sampleAnswer.add(Arrays.asList(-1, -1, 2));
    sampleAnswer.add(Arrays.asList(-1, 0, 1));
    assertEquals(
        new HashSet<>(sampleAnswer),
        new HashSet<>(solution.threeSum(new int[]{-1, 0, 1, 2, -1, -4}))
    );
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI(),
        new SolutionII()
    );
  }
}