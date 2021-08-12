package _0051_0100._096_Unique_Binary_Search_Trees;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 6/1/2017.
 */
public class SolutionTest {
  private Solution solution;

  @BeforeEach
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void test1() throws Exception {
    assertEquals(1, solution.numTrees(1));
  }

  @Test
  public void test2() throws Exception {
    assertEquals(2, solution.numTrees(2));
  }

  @Test
  public void test3() throws Exception {
    assertEquals(5, solution.numTrees(3));
  }

  @Test
  public void test4() throws Exception {
    assertEquals(14, solution.numTrees(4));
  }

  @Test
  public void test19() throws Exception {
    assertEquals(1767263190, solution.numTrees(19));
  }
}