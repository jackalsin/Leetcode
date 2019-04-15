package interviews.airbnb.tenWizards;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MySolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new MySolution();
  }

  @Test
  void testOnlineCase1() {
//    求 0 到 4 认识的最少距离
//    0 号认识 1 号和 2 号
//    1 号认识 3 号
//    2 号认识 3 号，4 号
//    3 号认识 4 号

    final List<List<Integer>> input = List.of(
        List.of(1, 2),
        List.of(3),
        List.of(3, 4),
        List.of(4),
        List.of()
    );

    final List<Integer> expected = List.of(0, 2, 3, 4),
        actual = solution.getShortestPath(input, 0, 4);
    assertEquals(expected, actual);
  }
}