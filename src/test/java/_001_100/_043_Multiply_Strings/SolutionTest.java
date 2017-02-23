package _001_100._043_Multiply_Strings;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 2/22/2017.
 */
public class SolutionTest {

  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();

  }

  @Test
  public void testWith11And11() throws Exception {
    // no carry
    assertEquals("121", solution.multiply("11", "11"));

  }

  @Test
  public void testWith233And233() throws Exception {
    // no carry
    assertEquals("54289", solution.multiply("233", "233"));
  }

  @Test
  public void testWithLeadingZero() throws Exception {
    assertEquals(String.valueOf(43 * 27), solution.multiply("43", "27"));
  }
}