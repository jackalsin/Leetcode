package uber._636_Exclusive_Time_of_Functions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  @Test
  void testOnlineCase1() {
    final int n = 2;
    final List<String> logs = List.of(
        "0:start:0",
        "1:start:2",
        "1:end:5",
        "0:end:6");

    final int[] output = {3, 4}, actual = solution.exclusiveTime(n, logs);
    assertArrayEquals(output, actual);
  }

  @Test
  void testFailedCase1() {
    final int n = 3;
    final List<String> logs = List.of(
        "0:start:0", "0:end:0", "1:start:1", "1:end:1", "2:start:2", "2:end:2", "2:start:3", "2:end:3"
    );

    final int[] output = {1, 1, 2}, actual = solution.exclusiveTime(n, logs);
    assertArrayEquals(output, actual);
  }

}
