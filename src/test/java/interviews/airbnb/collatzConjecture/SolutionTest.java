package interviews.airbnb.collatzConjecture;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 2/26/2019.
 */
@RunWith(Parameterized.class)
public class SolutionTest {
  private Solution solution;

  public SolutionTest(Solution solution) {
    this.solution = solution;
  }

  @Parameterized.Parameters
  public static Collection<Object[]> getParameters() {
    return Arrays.asList(new Object[][]{
        {new SolutionI()},
        {new SolutionII()}
    });
  }

  //less than 10 is 9, which has 19 steps,
  @Test
  public void testOnlineCase1() {
    assertEquals(19, solution.findTheLongestStep(10));
  }

  //less than 100 is 97, which has 118 steps,
  @Test
  public void testOnlineCase2() {
    assertEquals(118, solution.findTheLongestStep(100));
  }

  //less than 1,000 is 871, which has 178 steps,
  @Test
  public void testOnlineCase3() {
    assertEquals(178, solution.findTheLongestStep(1_000));
  }

  //less than 10,000 is 6,171, which has 261 steps,
  @Test
  public void testOnlineCase4() {
    assertEquals(261, solution.findTheLongestStep(10_000));
  }

  //less than 100,000 is 77,031, which has 350 steps,
  @Test
  public void testOnlineCase5() {
    assertEquals(350, solution.findTheLongestStep(100_000));
  }

  /**
   * This will take 1s 141ms on my local machine
   */
  @Test
  @Ignore
  public void testOnlineCase6() {
    //less than 1 million is 837,799, which has 524 steps,
    assertEquals(524, solution.findTheLongestStep(1_000_000));
  }

  /**
   * This will take 9s 891ms on my local machine
   */
  @Test
  @Ignore
  public void testOnlineCase7() {
    //less than 10 million is 8,400,511, which has 685 steps,
    assertEquals(685, solution.findTheLongestStep(10_000_000));
  }
}