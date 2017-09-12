package _301_350._302_Smallest_Rectangle_Enclosing_Black_Pixels;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author jacka
 * @version 1.0 on 9/11/2017.
 */
public class SolutionTest {
  private Solution solution;
  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase() throws Exception {
    final char[][] image = {
                            {'0', '0', '1', '0'},
                            {'0', '1', '1', '0'},
                            {'0', '1', '0', '0'},
                            };
    assertEquals(6, solution.minArea(image, 0, 2));
  }
}
