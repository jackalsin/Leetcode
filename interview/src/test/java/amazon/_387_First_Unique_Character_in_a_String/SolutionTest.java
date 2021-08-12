package amazon._387_First_Unique_Character_in_a_String;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 10/24/2017.
 */
public class SolutionTest {
  private Solution solution;

  @BeforeEach
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
