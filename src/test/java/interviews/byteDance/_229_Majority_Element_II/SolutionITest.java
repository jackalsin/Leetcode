package interviews.byteDance._229_Majority_Element_II;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 5/6/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testCase(Solution solution) throws Exception {
    final int[] input = new int[]{3, 3, 4, 3, 2, 3, 2, 2, 3, 3, 2}; // 3->6, 2 ->4, 4->1
    final Set<Integer> expected = new HashSet<>(Arrays.asList(3, 2));
    final List<Integer> actual = solution.majorityElement(input);
    assertEquals(expected.size(), actual.size());
    assertEquals(expected, new HashSet<>(actual));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}