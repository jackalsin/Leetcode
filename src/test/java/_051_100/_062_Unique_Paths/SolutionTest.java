package _051_100._062_Unique_Paths;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author jacka
 * @version 1.0 on 4/23/2017.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testWith1And2() throws Exception {
    assertEquals(1, solution.uniquePaths(1, 2));
  }

  @Test
  public void testWith2And2() throws Exception {
    assertEquals(2, solution.uniquePaths(2, 2));
  }

}