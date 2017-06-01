package _051_100._051_N_Queens;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 3/3/2017.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testWith1by1() throws Exception {

  }

  @Test
  public void testWith4() throws Exception {
    List<List<String>> expected = new ArrayList<>();
    expected.add(Arrays.asList(".Q..","...Q", "Q...", "..Q."));
    expected.add(Arrays.asList("..Q.", "Q...", "...Q", ".Q.."));
    List<List<String>> actual = solution.solveNQueens(4);
    assertEquals(expected.size(), actual.size());

    assertEquals(new HashSet<>(expected), new HashSet<>(actual));
  }

}