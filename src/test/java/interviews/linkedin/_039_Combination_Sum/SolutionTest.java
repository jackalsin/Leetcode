package interviews.linkedin._039_Combination_Sum;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
  @ParameterizedTest
  @MethodSource("solutionStream")
  void testWithExampleCase(Solution solution) throws Exception {
    List<List<Integer>> expect = new ArrayList<>();
    expect.add(Arrays.asList(2, 2, 3));
    expect.add(Collections.singletonList(7));

    List<List<Integer>> actual = solution.combinationSum(new int[]{2, 3, 6, 7}, 7);
    assertEquals(expect.size(), actual.size());
    assertEquals(new HashSet<>(expect), new HashSet<>(actual));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) throws Exception {
    final List<List<Integer>> expect = List.of(
        List.of(3, 4, 4),
        List.of(3, 8),
        List.of(4, 7)
    ), actual = solution.combinationSum(new int[]{8, 7, 4, 3}, 11);
    actual.forEach(Collections::sort);
    assertEquals(expect.size(), actual.size());
    assertEquals(new HashSet<>(expect), new HashSet<>(actual));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI(),
        new SolutionII(),
        new SolutionIII()
    );
  }
}