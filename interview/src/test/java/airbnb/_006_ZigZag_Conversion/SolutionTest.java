package airbnb._006_ZigZag_Conversion;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
  private Solution solution;
  private static final String STR1 = "PAYPALISHIRING";

  @BeforeEach
  void setup() {
    solution = new Solution();
  }

  @Test
  void testConvertWithEmptyString() {
    assertEquals("", solution.convert("", 1));
  }

  @Test
  void convert1() {
    assertEquals(STR1, solution.convert(STR1, 1));
  }

  @Test
  void convert2() {
    assertEquals("PYAIHRNAPLSIIG", solution.convert(STR1, 2));
  }

  @Test
  void convert3() {
    assertEquals("PAHNAPLSIIGYIR", solution.convert(STR1, 3));
  }

  @Test
  void convert4() {
    assertEquals("PINALSIGYAHRPI", solution.convert(STR1, 4));
  }
}