package google._072_Edit_Distance;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 1/24/2018.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }


  @Test
  public void testWithEmptyCouples() throws Exception {
    assertEquals(0, solution.minDistance("", ""));
  }

  @Test
  public void testWithEmpty() throws Exception {
    assertEquals(5, solution.minDistance("", "word1"));
  }

  @Test
  public void testWithCommonCase1() throws Exception {
    assertEquals(2, solution.minDistance("word", "wcd"));
  }
}
