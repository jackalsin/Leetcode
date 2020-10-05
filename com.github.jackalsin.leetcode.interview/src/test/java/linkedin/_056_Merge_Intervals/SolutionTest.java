package linkedin._056_Merge_Intervals;

import definition.Interval;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 10/17/2017.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new SolutionII();
  }

  @Test
  public void testFailedCase1() throws Exception {
    final List<Interval> result = Arrays.asList(new Interval(1, 4), new Interval(2, 3));
    final List<Interval> expected = List.of(new Interval(1, 4));
    assertEquals(expected, solution.merge(result));
  }


}
