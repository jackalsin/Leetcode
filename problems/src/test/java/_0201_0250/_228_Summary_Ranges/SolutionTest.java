package _0201_0250._228_Summary_Ranges;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 8/17/2017.
 */
public class SolutionTest {
  private Solution solution;

  @BeforeEach
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnline() throws Exception {
    final int[] input = new int[] {0,1,2,4,5,7};
    List<String> actual = solution.summaryRanges(input);
    List<String> expected = Arrays.asList("0->2","4->5","7");
    assertEquals(expected, actual);
  }

}
