package _101_150._119_Pascals_Triangle_II;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 6/23/2017.
 */
public class SolutionTest {
  private Solution solution;
  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void test0() throws Exception {
    assertEquals(Collections.singletonList(1), solution.getRow(0));
  }

  @Test
  public void test1() throws Exception {
    assertEquals(Arrays.asList(1, 1), solution.getRow(1));
  }

  @Test
  public void test2() throws Exception {
    assertEquals(Arrays.asList(1, 2, 1), solution.getRow(2));
  }

  @Test
  public void test3() throws Exception {
    assertEquals(Arrays.asList(1, 3, 3, 1), solution.getRow(3));
  }

  @Test
  public void test4() throws Exception {
    assertEquals(Arrays.asList(1, 4, 6, 4, 1), solution.getRow(4));
  }


}
