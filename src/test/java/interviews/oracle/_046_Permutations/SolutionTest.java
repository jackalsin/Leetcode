package interviews.oracle._046_Permutations;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 10/23/2019
 */
class SolutionTest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testWithSingleElement(Solution solution) {
    final List<List<Integer>> expected = new ArrayList<>();
    expected.add(Collections.singletonList(1));
    assertEquals(expected, solution.permute(new int[]{1}));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testWithMultipleElements(Solution solution) {
    final Set<List<Integer>> expected = new HashSet<>();
    expected.add(Arrays.asList(1, 2, 3));
    expected.add(Arrays.asList(1, 3, 2));
    expected.add(Arrays.asList(2, 1, 3));
    expected.add(Arrays.asList(2, 3, 1));
    expected.add(Arrays.asList(3, 1, 2));
    expected.add(Arrays.asList(3, 2, 1));

    List<List<Integer>> actual = solution.permute(new int[]{1, 2, 3});
    assertEquals(expected.size(), actual.size());
    assertEquals(expected, new HashSet<>(actual));

  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testWithEmptyArray(Solution solution) {
    assertEquals(new ArrayList<>(), solution.permute(new int[]{}));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}