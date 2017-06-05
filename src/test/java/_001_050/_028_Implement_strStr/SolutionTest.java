package _001_050._028_Implement_strStr;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 1/24/2017.
 */
public class SolutionTest {
  private Solution solution;
  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testWithNotExist() throws Exception {
    assertEquals(-1 , solution.strStr("abcde", "ee"));
  }

  @Test
  public void testWithOccurOnce() throws Exception {
    assertEquals(3, solution.strStr("abcdf", "df"));
  }

  @Test
  public void testWithMultipleOccurrance() throws Exception {
    assertEquals( 1,solution.strStr("abcbcbc", "bc"));
  }

}