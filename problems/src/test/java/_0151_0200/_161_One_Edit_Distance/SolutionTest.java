package _0151_0200._161_One_Edit_Distance;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 7/20/2017.
 */
public class SolutionTest {
  private Solution solution;

  @BeforeEach
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testEmptyWithEmpty() throws Exception {
    assertFalse(solution.isOneEditDistance("", ""));
  }

  @Test
  public void test1With0() throws Exception {
    assertTrue(solution.isOneEditDistance("1", ""));
  }

  @Test
  public void test2With1() throws Exception {
    assertTrue(solution.isOneEditDistance("12", "1"));
  }

  @Test
  public void test4With4() throws Exception {
    assertTrue(solution.isOneEditDistance("1234", "1233"));
  }

}
