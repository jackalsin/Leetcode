package interviews.microsoft.noodleEssence._351_Android_Unlock_Patterns;

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
    assertEquals(65, solution.numberOfPatterns(1, 2));
  }

}