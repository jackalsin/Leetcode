package google.trueFalseRectangle;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 1/28/2018.
 */
public class SolutionTest {
  private Solution solution;

  @BeforeEach
  public void setUp() throws Exception {
//    solution = new OMSquareNSolution();
    solution = new OMNSolution();
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

  @Test
  public void testOnlineCase2() throws Exception {
    final boolean[][] matrix = {
        {true, false, false, false, false, false, true},
        {true, true, false, false, false, false, false},
        {true, false, true, false, false, false, false},
        {true, false, false, true, false, false, false},
        {true, false, false, false, true, false, false},
        {true, false, false, false, false, true, false},
        {true, false, false, false, false, false, true},
    };
    assertTrue(solution.existTrueRectangle(matrix));
  }
}
