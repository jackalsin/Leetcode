package _0501_0550._524_Longest_Word_in_Dictionary_through_Deleting;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
//    solution = new UnSortedSolution();
    solution = new SortSolution();
  }

  @Test
  public void testOnlineCase1() throws Exception {
    final String s = "abpcplea";
    final List<String> d = Arrays.asList("ale", "apple", "monkey", "plea");
    assertEquals("apple", solution.findLongestWord(s, d));
  }

  @Test
  public void testOnlineCase2() throws Exception {
    final String s = "abpcplea";
    final List<String> d = Arrays.asList("a", "b", "c");
    assertEquals("a", solution.findLongestWord(s, d));
  }

}