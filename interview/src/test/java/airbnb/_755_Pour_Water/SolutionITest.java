package airbnb._755_Pour_Water;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ArgumentConverter;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 2/10/2019.
 */
class SolutionITest {

  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new SolutionI();
  }

  @Test
  void testOnlineCase1() {
    final int[] input = {2, 1, 1, 2, 1, 2, 2},
        expect = {2, 2, 2, 2, 2, 2, 2},
        actual = solution.pourWater(input, 4, 3);
    assertArrayEquals(expect, actual);
  }

  @Test
  void testFailedCase1() {
    final int[] input = {1, 2, 3, 4, 3, 2, 1, 2, 3, 4, 3, 2, 1},
        expect = {1, 2, 3, 4, 3, 2, 1, 2, 3, 4, 3, 2, 1},
        actual = solution.pourWater(input, 10, 2);
    assertArrayEquals(expect, actual);
  }

  @ParameterizedTest
  @CsvSource({
      "1; 2; 3; 4; 3; 2; 1; 2; 3; 4; 3; 2; 1, 0",
      "1; 2; 3; 4; 3; 2; 2; 2; 3; 4; 3; 2; 1, 1",
      "1; 2; 3; 4; 3; 3; 2; 2; 3; 4; 3; 2; 1, 2",
      "1; 2; 3; 4; 3; 3; 3; 2; 3; 4; 3; 2; 1, 3",
      "1; 2; 3; 4; 3; 3; 3; 3; 3; 4; 3; 2; 1, 4",
      "1; 2; 3; 4; 4; 3; 3; 3; 3; 4; 3; 2; 1, 5",
      "1; 2; 3; 4; 4; 4; 3; 3; 3; 4; 3; 2; 1, 6",
      "1; 2; 3; 4; 4; 4; 4; 3; 3; 4; 3; 2; 1, 7",
      "1; 2; 3; 4; 4; 4; 4; 4; 3; 4; 3; 2; 1, 8",
      "1; 2; 3; 4; 4; 4; 4; 4; 4; 4; 3; 2; 1, 9",
      "1; 2; 3; 4; 4; 4; 4; 4; 4; 4; 3; 2; 1, 10",
  })
  void testFailedCase2(@ConvertWith(CsvArrayConverter.class) int[] expect, final int drops) {
    final int[] input = {1, 2, 3, 4, 3, 2, 1, 2, 3, 4, 3, 2, 1};
    final int[] actual = solution.pourWater(input, drops, 3);
    assertArrayEquals(expect, actual);
  }

  // -------------- Test of getBestPosition ---------------
  @Test
  void testMoveLeftLeftGoAway() {
    final int[] input = {1, 2, 3};
    for (int i = 0; i < input.length; i++) {
      final int actual = SolutionI.getBestPosition(input, i, -1);
      assertEquals(-1, actual);
    }
  }

  @Test
  void testMoveRightRightGoAway() {
    final int[] input = {1, 2, 3};
    for (int i = 0; i < input.length; i++) {
      final int actual = SolutionI.getBestPosition(input, i, 1);
      assertEquals(-1, actual, "Dropping at " + actual);
    }
  }

  private static final class CsvArrayConverter implements ArgumentConverter {
    @Override
    public Object convert(Object sourceObject, ParameterContext context) throws ArgumentConversionException {
      if (!(sourceObject instanceof String)) {
        throw new IllegalArgumentException("The argument should be a string: " + sourceObject);
      }
      final String line = (String) sourceObject;
      final String[] array = line.split("; ");
      return Arrays.stream(array).mapToInt(Integer::valueOf).toArray();
    }
  }
}