package _101_150._140_Word_Break_II;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 7/8/2017.
 */
public class SolutionTest {
  private Solution solution;
  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testLeetCode() throws Exception {
    List<String> candidates = Arrays.asList("leet", "code");
    final String input = "leetcode";
    assertEquals(Arrays.asList("leet code"), solution.wordBreak(input, candidates));
  }
}
