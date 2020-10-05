package microsoft.noodleEssence._163_Missing_Ranges;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
  private Solution solution;

  private final int[] input = new int[]{0, 1, 3, 50, 75};

  @BeforeEach
  void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  void testEmpty() throws Exception {
    assertEquals(Arrays.asList("1"), solution.findMissingRanges(new int[]{}, 1, 1));
  }

  @Test
  void testSingle() throws Exception {
    assertEquals(new ArrayList<>(), solution.findMissingRanges(new int[]{-1}, -1, -1));
  }

  @Test
  void testEmptyArrayOneInterval() throws Exception {
    assertEquals(Collections.singletonList("1"), solution.findMissingRanges(new int[]{}, 1, 1));
  }

  @Test
  void testLeading() throws Exception {
    assertEquals(Arrays.asList("2", "4->49", "51->74", "76->99"), solution.findMissingRanges(input,
        0, 99));
  }

  @Test
  void testOverflow() throws Exception {
    assertEquals(Arrays.asList("0->2147483646"), solution.findMissingRanges(new
        int[]{2147483647}, 0, Integer
        .MAX_VALUE));
  }

}