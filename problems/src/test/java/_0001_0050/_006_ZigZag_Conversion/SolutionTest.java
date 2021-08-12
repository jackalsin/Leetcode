package _0001_0050._006_ZigZag_Conversion;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 2017/1/12.
 */
public class SolutionTest {
  private static final String STR1 = "PAYPALISHIRING";
  private final Solution solution = new Solution();

  @Test
  public void testConvertWithEmptyString() throws Exception {
    assertEquals("", solution.convert("", 1));
  }

  @Test
  public void convert1() throws Exception {
    assertEquals(STR1, solution.convert(STR1, 1));
  }

  @Test
  public void convert2() throws Exception {
    assertEquals("PYAIHRNAPLSIIG", solution.convert(STR1, 2));
  }

  @Test
  public void convert3() throws Exception {
    assertEquals("PAHNAPLSIIGYIR", solution.convert(STR1, 3));
  }

  @Test
  public void convert4() throws Exception {
    assertEquals("PINALSIGYAHRPI", solution.convert(STR1, 4));
  }

}