package _0251_0300._254_Factor_Combinations;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 8/25/2017.
 */
public class SolutionTest {
  private Solution solution;

  @BeforeEach
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void test1() throws Exception {
    assertEquals(new ArrayList<>(), solution.getFactors(1));
  }

  @Test
  public void test37() throws Exception {
    assertEquals(new ArrayList<>(), solution.getFactors(37));
  }

  @Test
  public void test12() throws Exception {
    final List<List<Integer>> expected = new ArrayList<>();
    expected.add(Arrays.asList(2, 2, 3));
    expected.add(Arrays.asList(2, 6));
    expected.add(Arrays.asList(3, 4));
    List<List<Integer>> actual = solution.getFactors(12);
    assertEquals(expected.size(), actual.size());
    assertEquals(new HashSet<>(expected), new HashSet<>(actual));
  }

  @Test
  public void test32() throws Exception {
    final List<List<Integer>> expected = new ArrayList<>();
    expected.add(Arrays.asList(2, 16));
    expected.add(Arrays.asList(2, 2, 8));
    expected.add(Arrays.asList(2, 2, 2, 4));
    expected.add(Arrays.asList(2, 2, 2, 2, 2));
    expected.add(Arrays.asList(2, 4, 4));
    expected.add(Arrays.asList(4, 8));
    List<List<Integer>> actual = solution.getFactors(32);
    assertEquals(expected.size(), actual.size());
    assertEquals(new HashSet<>(expected), new HashSet<>(actual));
  }
}
