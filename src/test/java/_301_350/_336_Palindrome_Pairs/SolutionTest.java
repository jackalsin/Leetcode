package _301_350._336_Palindrome_Pairs;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 10/4/2017.
 */
public class SolutionTest {
  private Solution solution;
  @Before
  public void setUp() throws Exception {
    solution = new ON2Solution();
  }

  @Test
  public void testOnlineCase() throws Exception {
    final String[] words = {"bat", "tab", "cat"};
    final List<List<Integer>> expected = List.of(List.of(0,1), List.of(1, 0));
    assertEquals(expected, solution.palindromePairs(words));
  }

  @Test
  public void testOnlineCase2() throws Exception {
    final String[] words = {"abcd", "dcba", "lls", "s", "sssll"};
    final List<List<Integer>> expected = List.of(List.of(0,1),
        List.of(1, 0), List.of(3, 2), List.of(2, 4));
    assertEquals(expected, solution.palindromePairs(words));
  }

  @Test
  public void testDuplicated() throws Exception {
    final String[] words = {"a",""};
    final List<List<Integer>> expected = List.of(List.of(0,1), List.of(1,0));
    assertEquals(expected, solution.palindromePairs(words));
  }

}
