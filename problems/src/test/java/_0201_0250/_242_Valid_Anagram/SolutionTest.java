package _0201_0250._242_Valid_Anagram;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 8/21/2017.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testExample() throws Exception {
    final String s = "anagram", t = "nagaram";
    assertTrue(solution.isAnagram(s, t));
  }

}
