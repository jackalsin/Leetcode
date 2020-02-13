package _0051_0100._051_N_Queens;

import org.junit.Before;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 3/3/2017.
 */
public class SolutionTest {

  @Before
  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new Solution()
    );
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  public void testWith4(Solution solution) throws Exception {
    List<List<String>> expected = new ArrayList<>();
    expected.add(Arrays.asList(".Q..", "...Q", "Q...", "..Q."));
    expected.add(Arrays.asList("..Q.", "Q...", "...Q", ".Q.."));
    List<List<String>> actual = solution.solveNQueens(4);
    assertEquals(expected.size(), actual.size());

    assertEquals(new HashSet<>(expected), new HashSet<>(actual));
  }

}