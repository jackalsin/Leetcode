package _0051_0100._066_Plus_One;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


/**
 * @author jacka
 * @version 1.0 on 4/25/2017.
 */
public class SolutionTest {
  private Solution solution;

  @BeforeEach
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testWithNoCarry() throws Exception {
    assertArrayEquals(new int[]{1, 0, 1}, solution.plusOne(new int[]{1, 0, 0}));
  }


  @Test
  public void testWithWithCarry() throws Exception {
    assertArrayEquals(new int[]{1, 1, 0}, solution.plusOne(new int[]{1, 0, 9}));
  }
}