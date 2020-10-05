package airbnb.displayPage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionIITest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new SolutionII();
  }

  @Test
  void testOnlineCase1() {
    final String[] input = {
        // "host_id,listing_id,score,city"
        "1,28,310.6,SF",  // 0, 0
        "4,5,204.1,SF",   // 0, 1
        "20,7,203.2,Oakland", // 0, 2
        "6,8,202.2,SF",   // 0, 3
        "6,10,199.1,SF",  // 1, 0
        "1,16,190.4,SF",  // 1, 1
        "6,29,185.2,SF",  // 1, 4
        "7,20,180.1,SF",  // 0, 4
        "6,21,162.1,SF",  // 2, 0
        "2,18,161.2,SF",  // 1, 2
        "2,30,149.1,SF",  // 2, 1
        "3,76,146.2,SF",  // 1, 3
        "2,14,141.1,San Jose" // 2, 2
    }, expected = {
        "1,28,310.6,SF",  // 0
        "4,5,204.1,SF",   // 1
        "20,7,203.2,Oakland", // 2
        "6,8,202.2,SF",   // 3
        "7,20,180.1,SF", // 4
        " ",  // 5
        "6,10,199.1,SF",  // 6
        "1,16,190.4,SF",  // 7
        "2,18,161.2,SF",  // 8
        "3,76,146.2,SF",  // 9
        "6,29,185.2,SF", // 10, 这是先试试能不能补全，不能再拉，此时不需要保持原顺序
        " ",  // 11
        "6,21,162.1,SF",
        "2,30,149.1,SF",
        "2,14,141.1,San Jose"
    }, actual = solution.pagination(5, input);
    assertArrayEquals(expected, actual);
  }
}