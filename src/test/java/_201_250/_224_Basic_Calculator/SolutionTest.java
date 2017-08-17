package _201_250._224_Basic_Calculator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author jacka
 * @version 1.0 on 8/16/2017.
 */
public class SolutionTest {
  private Solution solution;
  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void test1Plus1() throws Exception {
    assertEquals(2, solution.calculate("1 + 1"));
  }

  @Test
  public void test2Minus1Plus2() throws Exception {
    assertEquals(3, solution.calculate(" 2-1 + 2"));
  }

  @Test
  public void testLine3() throws Exception {
    assertEquals(23, solution.calculate("(1+(4+5+2)-3)+(6+8)"));
  }

  @Test
  public void test2147483647() throws Exception {
    assertEquals(2147483647, solution.calculate("2147483647"));
  }
}
