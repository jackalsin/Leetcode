package _0101_0150._132_Palindrome_Partitioning_II;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 7/3/2017.
 */
public class SolutionTest {
  private Solution solution;

  @BeforeEach
  public void setUp() throws Exception {
//    solution = new DPSolution();
    solution = new BitchingSolution();
  }

  @Test
  public void testaab() throws Exception {
    final String s = "aab";
    assertEquals(1, solution.minCut(s));
  }

  @Test
  public void testcdd() throws Exception {
    final String s = "cdd";
    assertEquals(1, solution.minCut(s));
  }

  @Test
  public void testbb() throws Exception {
    final String s = "bb";
    assertEquals(0, solution.minCut(s));
  }

  @Test
  public void testEmpty() throws Exception {
    final String s = "";
    assertEquals(0, solution.minCut(s));
  }
}