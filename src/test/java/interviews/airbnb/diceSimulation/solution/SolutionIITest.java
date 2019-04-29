package interviews.airbnb.diceSimulation.solution;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionIITest {
  private Solution solution;

  @BeforeEach
  void setup() {
  }

  @Test
  void testOnlineCase1() {
    int success = 0, N = 1_000_000;
    solution = new SolutionII();
    System.out.println("start solving");
    for (int i = 0; i < N; i++) {
      final boolean res = solution.solve();
      if (res) success++;
    }

    System.out.println((double) success / N);
  }


  @Test
  void testListToState1() {
    final List<Integer> input = List.of(1, 3, 5, 9);
    int expected = 0;
    for (int c : input) {
      expected |= (1 << (c - 1));
    }
    assertEquals(expected, SolutionII.getNextState(0, input));
  }


  // test state

  @Test
  void testStateToList1() {
    final List<Integer> expected = List.of(1, 3, 5, 9);
    int input = 0;
    for (int c : expected) {
      input |= (1 << (c - 1));
    }
    assertEquals(expected, SolutionII.stateToList(input));
  }

  @Test
  void testStateToList2() {
    final List<Integer> expected = List.of(2, 3, 5, 9);
    int input = 0;
    for (int c : expected) {
      input |= (1 << (c - 1));
    }
    assertEquals(expected, SolutionII.stateToList(input));
  }

  @Test
  void testStateToList3() {
    final List<Integer> expected = List.of(1, 9);
    int input = 0;
    for (int c : expected) {
      input |= (1 << (c - 1));
    }
    assertEquals(expected, SolutionII.stateToList(input));
  }

  @Test
  void testStateToList4() {
    final List<Integer> expected = List.of(1, 2, 3, 4, 5, 9);
    int input = 0;
    for (int c : expected) {
      input |= (1 << (c - 1));
    }
    assertEquals(expected, SolutionII.stateToList(input));
  }
}