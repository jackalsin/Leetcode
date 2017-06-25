package _101_150._120_Triangle;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author jacka
 * @version 1.0 on 6/24/2017.
 */
public class SolutionTest {
  private Solution solution;
  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase() throws Exception {
    List<List<Integer>> input = new ArrayList<>();
      input.add(Arrays.asList(2));
      input.add(Arrays.asList(3, 4));
      input.add(Arrays.asList(6, 5, 7));
      input.add(Arrays.asList(4, 1, 8, 3));

    assertEquals(11, solution.minimumTotal(input));
  }

}