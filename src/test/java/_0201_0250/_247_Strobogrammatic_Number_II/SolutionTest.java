package _0201_0250._247_Strobogrammatic_Number_II;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 8/22/2017.
 */
public class SolutionTest {
  private Solution solution;
  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void test1() throws Exception {
    final List<String> expected = Arrays.asList("0", "1", "8");
    final List<String> actual = solution.findStrobogrammatic(1);
    assertEquals(expected.size(), actual.size());
    assertEquals(new HashSet<>(expected), new HashSet<>(actual));
  }

  @Test
  public void test2() throws Exception {
    final List<String> expected = Arrays.asList("11","69","88","96");
    final List<String> actual = solution.findStrobogrammatic(2);
    assertEquals(expected.size(), actual.size());
    assertEquals(new HashSet<>(expected), new HashSet<>(actual));
  }

  @Test
  public void test3() throws Exception {
    final List<String> expected = Arrays.asList("101","111","181","609","619","689","808","818","888","906","916","986");
    final List<String> actual = solution.findStrobogrammatic(3);
    assertEquals(expected.size(), actual.size());
    assertEquals(new HashSet<>(expected), new HashSet<>(actual));
  }

}
