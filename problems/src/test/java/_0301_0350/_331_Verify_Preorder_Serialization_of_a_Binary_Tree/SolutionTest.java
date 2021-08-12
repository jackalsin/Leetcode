package _0301_0350._331_Verify_Preorder_Serialization_of_a_Binary_Tree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 10/1/2017.
 */
public class SolutionTest {
  private Solution solution;

  @BeforeEach
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase() throws Exception {
    final String input = "9,3,4,#,#,1,#,#,2,#,6,#,#";
    assertTrue(solution.isValidSerialization(input));
  }

  @Test
  public void testOnlineCase2() throws Exception {
    final String input = "1,#";
    assertFalse(solution.isValidSerialization(input));
  }

  @Test
  public void testOnlineCase3() throws Exception {
    final String input = "9,#,#,1";
    assertFalse(solution.isValidSerialization(input));
  }
}
