package _251_300._290_Word_Pattern;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author jacka
 * @version 1.0 on 9/6/2017.
 */
public class SolutionTest {
  private Solution solution;
  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase1() throws Exception {
    assertTrue(solution.wordPattern("abba", "dog cat cat dog"));
    assertFalse(solution.wordPattern("abba", "dog cat cat fish"));
    assertFalse(solution.wordPattern("aaaa", "dog cat cat dog"));
    assertFalse(solution.wordPattern("abba", "dog dog dog dog"));
  }
}
