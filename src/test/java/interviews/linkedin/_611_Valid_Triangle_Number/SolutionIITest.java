package interviews.linkedin._611_Valid_Triangle_Number;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionIITest {
  private Solution solution;

  @BeforeEach
  void setup() {
    solution = new SolutionII();
  }

  @Test
  void testOnlineCase1() {
    final int[] input = {2, 2, 3, 4};
    assertEquals(3, solution.triangleNumber(input));
  }

  @Test
  void testDuplicate1() {
    final int[] input = {2, 2, 2, 3, 4};
    assertEquals(7, solution.triangleNumber(input));
  }
}