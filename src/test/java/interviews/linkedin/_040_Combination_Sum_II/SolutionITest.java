package interviews.linkedin._040_Combination_Sum_II;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author zhiwei.xin
 * @version 1.0 on 9/7/18
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testWithOnlineCase(Solution solution) {
    List<List<Integer>> expect = new ArrayList<>();
    expect.add(Arrays.asList(1, 7));
    expect.add(Arrays.asList(1, 2, 5));
    expect.add(Arrays.asList(2, 6));
    expect.add(Arrays.asList(1, 1, 6));

    List<List<Integer>> actual = solution.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
    assertEquals(expect.size(), actual.size());
    assertEquals(new HashSet<>(expect), new HashSet<>(actual));

  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testWithTripleElements(Solution solution) {
    List<List<Integer>> expect = new ArrayList<>();
    expect.add(Arrays.asList(1, 1, 6));

    List<List<Integer>> actual = solution.combinationSum2(new int[]{1, 1, 1, 6, 10}, 8);
    assertEquals(expect.size(), actual.size());
    assertEquals(new HashSet<>(expect), new HashSet<>(actual));
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI(),
        new SolutionII(),
        new SolutionIII()
    );
  }
}