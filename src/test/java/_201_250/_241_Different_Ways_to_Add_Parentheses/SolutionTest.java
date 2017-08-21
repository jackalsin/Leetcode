package _201_250._241_Different_Ways_to_Add_Parentheses;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 8/20/2017.
 */
public class SolutionTest {
  private Solution solution;
  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase1() throws Exception {
    final String input = "2-1-1";
    final List<Integer> actual = solution.diffWaysToCompute(input);
    final List<Integer> expected = Arrays.asList(0, 2);
    assertEquals(expected.size(), actual.size());
    assertEquals(new HashSet<>(expected), new HashSet<>(actual));
  }

  @Test
  public void testOnlineCase2() throws Exception {
    final String input = "2*3-4*5";
    final List<Integer> actual = solution.diffWaysToCompute(input);
    final List<Integer> expected = Arrays.asList(-34, -14, -10, -10, 10);
    assertEquals(expected.size(), actual.size());
    assertEquals(new HashSet<>(expected), new HashSet<>(actual));
  }

}
