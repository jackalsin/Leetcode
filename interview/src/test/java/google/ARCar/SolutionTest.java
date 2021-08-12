package google.ARCar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 1/10/2018.
 */
public class SolutionTest {
  private Solution solution;

  @BeforeEach
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase1() throws Exception {
    assertEquals(0, solution.getLocation("AAARRRAR"));
  }
//
//  @Test
//  public void testOnlineCase2() throws Exception {
//    final int location = 2;
//    final String path = solution.getPath(location);
//    assertEquals(location, solution.getLocation(path));
//  }
}
