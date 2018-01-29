package interviews.google.trueFalseRectangle;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 1/28/2018.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new OMSquareNSolution();
  }

  @Test
  public void testOnlineCase2By2True() throws Exception {
    final boolean[][] matrix = new boolean[][] {
        {true, true},
        {true, true}
    };
    assertTrue(solution.existTrueRectangle(matrix));
  }

  @Test
  public void testOnlineCase2By2False() throws Exception {
    final boolean[][] matrix = new boolean[][] {
        {true, true},
        {true, false}
    };
    assertFalse(solution.existTrueRectangle(matrix));
  }

  @Test
  public void testMultipleRowTrue() throws Exception {
    final boolean[][] matrix = new boolean[][] {
        {false, false, true, false},
        {true, true, true, true},
        {false, false, true, true}
    };
    assertTrue(solution.existTrueRectangle(matrix));
  }

  @Test
  public void testMultipleRowHeightBiasFalse() throws Exception {
    final boolean[][] matrix = new boolean[][] {
        {false, false, true, false},
        {true, true, true, false},
        {false, false, true, true},
        {false, false, false, true},
        {false, false, false, true}
    };
    assertFalse(solution.existTrueRectangle(matrix));
  }

  @Test
  public void testOnlineCase1() throws Exception {
    final boolean[][] matrix = new boolean[][] {
        {true, false, false, true, false},
        {false, false, true, false, true},
        {false, false, false, true, false},
        {true, false, true, false, true}
    };
    assertTrue(solution.existTrueRectangle(matrix));
  }
}
