package interviews.uber._039_Combination_Sum;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 2/15/2018.
 */
class SolutionITest {

  private Solution solution;

  @BeforeEach
  void setUp() throws Exception {
    solution = new SolutionI();
  }

  @Test
  void testWithExampleCase() throws Exception {
    List<List<Integer>> expect = new ArrayList<>();
    expect.add(Arrays.asList(2, 2, 3));
    expect.add(Collections.singletonList(7));

    List<List<Integer>> actual = solution.combinationSum(new int[] {2, 3, 6, 7}, 7);

    assertEquals(expect.size(), actual.size());
    assertEquals(new HashSet<>(expect), new HashSet<>(actual));

  }
}
