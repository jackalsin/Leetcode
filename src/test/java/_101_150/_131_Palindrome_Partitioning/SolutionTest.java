package _101_150._131_Palindrome_Partitioning;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 7/3/2017.
 */
public class SolutionTest {
  private Solution solution;
  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase() throws Exception {
    final String s = "aab";
    List<List<String>> expected = new ArrayList<>();
    expected.add(Arrays.asList("aa", "b"));
    expected.add(Arrays.asList("a", "a", "b"));
    List<List<String>> actual = solution.partition(s);
    assertEquals(expected.size(), actual.size());
    assertEquals(new HashSet<>(expected), new HashSet<>(actual));
  }

  @Test
  public void testFullPa() throws Exception {
    final String s = "bb";
    List<List<String>> expected = new ArrayList<>();
    expected.add(Arrays.asList("b", "b"));
    expected.add(Arrays.asList("bb"));
    List<List<String>> actual = solution.partition(s);
    assertEquals(expected.size(), actual.size());
    assertEquals(new HashSet<>(expected), new HashSet<>(actual));
  }

  @Test
  public void test1Char() throws Exception {
    final String s = "a";
    List<List<String>> expected = new ArrayList<>();
    expected.add(Arrays.asList("a"));
    assertEquals(expected, solution.partition(s));
  }
}