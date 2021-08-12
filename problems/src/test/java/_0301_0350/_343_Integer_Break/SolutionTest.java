package _0301_0350._343_Integer_Break;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 10/8/2017.
 */
public class SolutionTest {
  private Solution solution;

  @BeforeEach
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase() throws Exception {
    assertEquals(1, solution.integerBreak(2));
    assertEquals(36, solution.integerBreak(10)); // 3 * 3 * 4
  }
}
