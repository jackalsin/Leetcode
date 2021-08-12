package _0051_0100._062_Unique_Paths;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 4/23/2017.
 */
public class SolutionTest {
  private Solution solution;

  @BeforeEach
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