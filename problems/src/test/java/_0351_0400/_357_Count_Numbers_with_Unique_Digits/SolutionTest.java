package _0351_0400._357_Count_Numbers_with_Unique_Digits;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 10/10/2017.
 */
public class SolutionTest {
  private Solution solution;

  @BeforeEach
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void test1() throws Exception {
    assertEquals(10, solution.countNumbersWithUniqueDigits(1));
  }

  @Test
  public void test2() throws Exception {
    assertEquals(91, solution.countNumbersWithUniqueDigits(2));
  }

  @Test
  public void test10() throws Exception {
    assertEquals(8877691, solution.countNumbersWithUniqueDigits(10));
  }

  @Test
  public void test11() throws Exception {
    assertEquals(8877691, solution.countNumbersWithUniqueDigits(11));
  }

  @Test
  public void test9() throws Exception {
    assertEquals(5611771, solution.countNumbersWithUniqueDigits(9));
  }

  @Test
  public void test0() throws Exception {
    assertEquals(1, solution.countNumbersWithUniqueDigits(0));
  }

}
