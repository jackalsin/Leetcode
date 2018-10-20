package interviews.linkedin._611_Valid_Triangle_Number;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionITest {
  private Solution solution;

  @BeforeEach
  void setup() {
    solution = new SolutionI();
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

  @Test
  void testFailed2() {
    final int[] input = {0, 1, 0};
    assertEquals(7, solution.triangleNumber(input));
  }
}