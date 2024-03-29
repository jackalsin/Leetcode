package _0001_0050._039_Combination_Sum;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * @author jacka
 * @version 1.0 on 2/18/2017.
 */
public class SolutionTest {

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new Solution()
    );
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testWithExampleCase(Solution solution) {
    List<List<Integer>> expect = new ArrayList<>();
    expect.add(Arrays.asList(2, 2, 3));
    expect.add(Collections.singletonList(7));

    List<List<Integer>> actual = solution.combinationSum(new int[]{2, 3, 6, 7}, 7);
    assertEquals(expect.size(), actual.size());
    assertEquals(new HashSet<>(expect), new HashSet<>(actual));

  }

}