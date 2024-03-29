package definition;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 8/15/2017.
 */
public class TwoDimensionArrayTest {
  @BeforeEach
  public void setUp() throws Exception {
  }

  @Test
  public void testPositiveCase() throws Exception {
    final String[] strings = new String[]{"12345", "67890", "12345", "67890"};
    TwoDimensionArray.getCharBoard(strings);
    char[][] expected = new char[4][5];
    for (int row = 0; row < 4; ++row) {
      for (int col = 0; col < 5; ++col) {
        expected[row][col] = strings[row].charAt(col);
      }
    }
    char[][] actual = TwoDimensionArray.getCharBoard(strings);
    assertTrue(TwoDimensionArray.TwoDimensionArrayEquals(expected, actual));
  }

}
