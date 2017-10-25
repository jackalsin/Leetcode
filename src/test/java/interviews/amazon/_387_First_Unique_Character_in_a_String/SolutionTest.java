package interviews.amazon._387_First_Unique_Character_in_a_String;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 10/24/2017.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase1() {
    final String input = "leetcode";
    assertEquals(0, solution.firstUniqChar(input));
  }

  @Test
  public void testFailedOnCc() {
    final String input = "cc";
    assertEquals(-1, solution.firstUniqChar(input));
  }
}
