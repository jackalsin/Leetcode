package _0251_0300._258_Add_Digits;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 8/27/2017.
 */
public class SolutionTest {
  private Solution solution;

  @BeforeEach
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void test38() throws Exception {
    assertEquals(2, solution.addDigits(38));
  }

  @Test
  public void test1() throws Exception {
    assertEquals(1, solution.addDigits(1));
  }

  @Test
  public void test0() throws Exception {
    assertEquals(0, solution.addDigits(0));
  }
}
