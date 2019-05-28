package interviews.airbnb.displayPage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionIIITest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new SolutionIII();
  }

  @Test
  void testOnlineCase1() {
    final String[] input = {
        "1,28,310.6,SF",
        "4,5,204.1,SF",
        "20,7,203.2,Oakland",
        "6,8,202.2,SF",
        "6,10,199.1,SF", // 1, 1
        "1,16,190.4,SF",
        "6,29,185.2,SF",
        "7,20,180.1,SF",
        "6,21,162.1,SF",
        "2,18,161.2,SF",
        "2,30,149.1,SF",
        "3,76,146.2,SF",
        "2,14,141.1,San Jose"
    }, expected = {
        "1,28,310.6,SF",
        "4,5,204.1,SF",
        "20,7,203.2,Oakland",
        "6,8,202.2,SF",
        "7,20,180.1,SF",
        " ",
        "6,10,199.1,SF",
        "1,16,190.4,SF",
        "2,18,161.2,SF",
        "3,76,146.2,SF",
        "6,29,185.2,SF", // 这是先试试能不能补全，不能再拉，此时不需要保持原顺序
        " ",
        "6,21,162.1,SF",
        "2,30,149.1,SF",
        "2,14,141.1,San Jose"
    }, actual = solution.pagination(5, input);
    assertArrayEquals(expected, actual);
  }
}