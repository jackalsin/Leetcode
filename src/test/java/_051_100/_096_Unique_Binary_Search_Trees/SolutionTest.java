package _051_100._096_Unique_Binary_Search_Trees;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author jacka
 * @version 1.0 on 6/1/2017.
 */
public class SolutionTest {
  private Solution solution;
  @Before
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

}