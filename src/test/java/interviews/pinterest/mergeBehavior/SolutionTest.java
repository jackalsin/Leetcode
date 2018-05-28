package interviews.pinterest.mergeBehavior;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  @Test
  void testOnlineCase1() {
    final String[][] input = {
        {"ab", "0", "1.0"},
        {"bc", "0", "2.0"},
        {"ab", "30", "1.0"},
        {"bc", "30", "2.0"},
        {"ab", "60", "1.0"},
        {"bc", "60", "2.0"},
        {"ab", "90", "1.0"},
        {"bc", "90", "2.0"}
    };
    final List<String> expected = List.of(
        "ab 0 2.0",
        "bc 0 4.0",
        "ab 60 2.0",
        "bc 60 4.0"
    );
    assertEquals(new HashSet<>(expected), solution.mergeBehavoirs(input, 60));
  }
}