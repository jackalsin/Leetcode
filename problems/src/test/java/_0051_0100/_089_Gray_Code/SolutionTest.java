package _0051_0100._089_Gray_Code;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 5/29/2017.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void test2() throws Exception {
    List<Integer> result = new ArrayList<>();
    result.add(0);
    result.add(1);
    result.add(3);
    result.add(2);
    assertEquals(result, solution.grayCode(2));
  }

}