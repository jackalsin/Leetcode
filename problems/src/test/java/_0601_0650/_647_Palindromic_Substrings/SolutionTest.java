package _0601_0650._647_Palindromic_Substrings;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 10/15/2017.
 */
public class SolutionTest {

  private Solution solution;

  @BeforeEach
  public void setUp() throws Exception {
    solution = new ONSquareSolution();
  }

  @Test
  public void testAaa() throws Exception {
    assertEquals(6, solution.countSubstrings("aaa"));
  }

  @Test
  public void testEmpty() throws Exception {
    assertEquals(0, solution.countSubstrings(""));
  }

  @Test
  public void testAbc() throws Exception {
    assertEquals(3, solution.countSubstrings("abc"));
  }

}
