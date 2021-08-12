package _0101_0150._150_Evaluate_Reverse_Polish_Notation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 7/10/2017.
 */
public class SolutionTest {
  private Solution solution;

  @BeforeEach
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testEmpty() throws Exception {
    final String[] input = new String[]{};
    assertEquals(0, solution.evalRPN(input));
  }

  @Test
  public void testOnlineCase1() throws Exception {
    final String[] input = new String[]{"2", "1", "+", "3", "*"};
    assertEquals(9, solution.evalRPN(input));
  }

  @Test
  public void testOnlineCase2() throws Exception {
    final String[] input = new String[]{"4", "13", "5", "/", "+"};
    assertEquals(6, solution.evalRPN(input));
  }
}
