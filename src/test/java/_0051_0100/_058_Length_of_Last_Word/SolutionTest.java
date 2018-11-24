package _0051_0100._058_Length_of_Last_Word;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 4/21/2017.
 */
public class SolutionTest {

  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testWithEmpty() throws Exception {
    assertEquals(0, solution.lengthOfLastWord(""));
  }

  @Test
  public void testWithNoSpaces() throws Exception {
    assertEquals(4, solution.lengthOfLastWord("abcd"));
  }

  @Test
  public void testWithLastIsMax() throws Exception {
    assertEquals(3, solution.lengthOfLastWord("a b c def"));
  }

  @Test
  public void testWithFirstIsMax() throws Exception {
    assertEquals(3, solution.lengthOfLastWord("abcd b c def"));
  }

  @Test
  public void testWithEmptyWithTailingSpace() throws Exception {
    assertEquals(0, solution.lengthOfLastWord(""));
  }

  @Test
  public void testWithNoSpacesWithTailingSpace() throws Exception {
    assertEquals(4, solution.lengthOfLastWord("abcd "));
  }

  @Test
  public void testWithLastIsMaxWithTailingSpace() throws Exception {
    assertEquals(3, solution.lengthOfLastWord("a b c def "));
  }

  @Test
  public void testWithFirstIsMaxWithTailingSpace() throws Exception {
    assertEquals(3, solution.lengthOfLastWord("abcd b c def "));
  }

}