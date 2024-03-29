package google._351_Android_Unlock_Patterns;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 1/20/2018.
 */
public class SolutionTest {
  private Solution solution;

  @BeforeEach
  public void setUp() {
    solution = new ReturnCountSolution();
  }


  @Test
  public void testOnlineCaseM1N1() throws Exception {
    assertEquals(9, solution.numberOfPatterns(1, 1));
  }

  @Test
  public void testOnlineCaseM1N2() throws Exception {
    assertEquals(65, solution.numberOfPatterns(1, 2));
  }

}
