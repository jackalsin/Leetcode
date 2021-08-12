package _0101_0150._118_Pascals_Triangle;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 6/23/2017.
 */
public class SolutionTest {
  private Solution solution;

  @BeforeEach
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void test0() throws Exception {
    assertEquals(new ArrayList<>(), solution.generate(0));
  }

  @Test
  public void test1() throws Exception {
    List<List<Integer>> expected = new ArrayList<>();
    expected.add(Arrays.asList(1));
    assertEquals(expected, solution.generate(1));
  }

  @Test
  public void test2() throws Exception {
    List<List<Integer>> expected = new ArrayList<>();
    expected.add(Arrays.asList(1));
    expected.add(Arrays.asList(1, 1));
    assertEquals(expected, solution.generate(2));
  }

  @Test
  public void test3() throws Exception {
    List<List<Integer>> expected = new ArrayList<>();
    expected.add(Arrays.asList(1));
    expected.add(Arrays.asList(1, 1));
    expected.add(Arrays.asList(1, 2, 1));
    assertEquals(expected, solution.generate(3));
  }

  @Test
  public void test4() throws Exception {
    List<List<Integer>> expected = new ArrayList<>();
    expected.add(Arrays.asList(1));
    expected.add(Arrays.asList(1, 1));
    expected.add(Arrays.asList(1, 2, 1));
    expected.add(Arrays.asList(1, 3, 3, 1));
    assertEquals(expected, solution.generate(4));
  }

  @Test
  public void test5() throws Exception {
    List<List<Integer>> expected = new ArrayList<>();
    expected.add(Arrays.asList(1));
    expected.add(Arrays.asList(1, 1));
    expected.add(Arrays.asList(1, 2, 1));
    expected.add(Arrays.asList(1, 3, 3, 1));
    expected.add(Arrays.asList(1, 4, 6, 4, 1));
    assertEquals(expected, solution.generate(5));
  }

}
