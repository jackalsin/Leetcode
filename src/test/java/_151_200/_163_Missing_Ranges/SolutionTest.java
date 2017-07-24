package _151_200._163_Missing_Ranges;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author jacka
 * @version 1.0 on 7/23/2017.
 */
public class SolutionTest {
  private Solution solution;

  private final int[] input = new int[] {0, 1, 3, 50, 75};
  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testEmpty() throws Exception {
    assertEquals(Arrays.asList("1"), solution.findMissingRanges(new int[]{}, 1, 1));
  }

  @Test
  public void testSingle() throws Exception {
    assertEquals(new ArrayList<>(), solution.findMissingRanges(new int[]{-1}, -1, -1));
  }

  @Test
  public void testEmptyArrayOneInterval() throws Exception {
    assertEquals(Collections.singletonList("1"), solution.findMissingRanges(new int[]{}, 1, 1));
  }

  @Test
  public void testLeading() throws Exception {
    assertEquals(Arrays.asList("2","4->49","51->74","76->99"), solution.findMissingRanges(input,
        0, 99));
  }

  @Test
  public void testOverflow() throws Exception {
    assertEquals(Arrays.asList("0->2147483646"), solution.findMissingRanges(new
        int[]{2147483647}, 0, Integer
        .MAX_VALUE));
  }

}
