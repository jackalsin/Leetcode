package _001_100._015_3Sum;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 2017/1/19.
 */
public class SolutionTest {

  private static final int[] ARRAY_1 = new int[] {1, 2, 3, 4, 5};
  private static final int[] ARRAY_2 = new int[] {-4, -1, -1, 0, 1, 2};
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void threeSum() throws Exception {
    System.out.println(solution.threeSum(new int[] {-1, 0, 1, 2, -1, -4}));
  }

  @Test
  public void threeSumWithDipAnsSymmetric() throws Exception {
    List<List<Integer>> sampleAnswer = new ArrayList<>();
    sampleAnswer.add(Arrays.asList(-4, 2, 2));
    sampleAnswer.add(Arrays.asList(-2, -2, 4));
    sampleAnswer.add(Arrays.asList(-1, -1, 2));
    sampleAnswer.add(Arrays.asList(-2, 1, 1));
    sampleAnswer.add(Arrays.asList(-2, 0, 2));
    sampleAnswer.add(Arrays.asList(-1, 0, 1));
    sampleAnswer.add(Arrays.asList(-4, 0, 4));
    assertEquals(
        new HashSet<>(sampleAnswer),
        new HashSet<>(solution.threeSum(new int[] {-4, -2, -2, -1, -1, 0, 1, 1, 2, 2, 4}))
    );
  }


}