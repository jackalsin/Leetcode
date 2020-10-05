package microsoft.noodleEssence._351_Android_Unlock_Patterns;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setup() {
    solution = new Solution();
  }

  @Test
  void testOnlineCaseM1N1() throws Exception {
    assertEquals(9, solution.numberOfPatterns(1, 1));
  }

  @Test
  void testOnlineCaseM1N2() throws Exception {
    // 1 -> 6, 2 -> 8, 5 -> 9
    assertEquals(65, solution.numberOfPatterns(1, 2));
  }

  @Test
  void testOnlineCaseM1N3() throws Exception {
    // 1 -> 37, 2 -> 45, 5 -> 57
    assertEquals(385, solution.numberOfPatterns(1, 3));
  }

}