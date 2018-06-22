package interviews.linkedin._057_Insert_Interval;

import org.junit.Before;
import org.junit.Test;
import utils.Interval;

import java.util.ArrayList;
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
    final Interval newInterval = new Interval(5, 7);
    final List<Interval> expected = List.of(newInterval);
    assertEquals(expected, solution.insert(new ArrayList<>(), newInterval));
  }

  @Test
  public void testFailedCase2() throws Exception {
    final Interval newInterval = new Interval(2, 5);
    final List<Interval> expected = List.of(new Interval(1, 5), new Interval(6, 9));
    assertEquals(expected, solution.insert(List.of(new Interval(1, 3), new Interval(6, 9)),
        newInterval));
  }


}
