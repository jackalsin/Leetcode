package _0601_0650._636_Exclusive_Time_of_Functions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * @author jacka
 * @version 1.0 on 2/5/2018.
 */
class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  @Test
  void testOnlineCase1() throws Exception {
    final int n = 2;
    final List<String> logs = List.of("0:start:0",
        "1:start:2",
        "1:end:5",
        "0:end:6");

    final int[] output = {3, 4}, actual = solution.exclusiveTime(n, logs);
    assertArrayEquals(output, actual);
  }
}
