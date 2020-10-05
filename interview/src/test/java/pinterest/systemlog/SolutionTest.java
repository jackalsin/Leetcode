package pinterest.systemlog;

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
  void testOnlineCase1() {
    final String[] logs = {
        "100 1000 A",
        "200 1003 A",
        "300 1009 B",
        "100 1026 B",
        "100 1030 C",
        "200 1109 B",
        "200 1503 A"
    };
    final String expected =
        "|---A (2)\n" +
            "|    |---B (2)\n" +
            "|    |    |---A (1)\n" +
            "|    |    |---C (1)\n" +
            "|---B (1)",
        actual = solution.archiveLog(logs);

//    System.out.print(actual);
    assertEquals(expected, actual);
  }

}