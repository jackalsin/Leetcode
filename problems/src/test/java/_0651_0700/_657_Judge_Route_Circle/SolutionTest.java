package _0651_0700._657_Judge_Route_Circle;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SolutionTest {
  private Solution solution;

  @BeforeEach
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase1() throws Exception {
    assertTrue(solution.judgeCircle("UD"));
  }

  @Test
  public void testOnlineCase2() throws Exception {
    assertFalse(solution.judgeCircle("LL"));
  }
}