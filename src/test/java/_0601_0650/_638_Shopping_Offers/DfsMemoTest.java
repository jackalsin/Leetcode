package _0601_0650._638_Shopping_Offers;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class DfsMemoTest {

  @Test
  public void testOnlineCase1() throws Exception {
    Solution solution = new DfsMemo();
    final List<Integer> price = List.of(2, 5);
    final List<Integer> needs = List.of(3, 2);
    final List<List<Integer>> special = new ArrayList<>(List.of(
        List.of(3, 0, 5),
        List.of(1, 2, 10)
    ));
    assertEquals(14, solution.shoppingOffers(price, special, needs));
  }

  @Test
  public void testOnlineCase2() throws Exception {

    Solution solution = new DfsMemo();
    final List<Integer> price = List.of(2, 3, 4);
    final List<Integer> needs = List.of(1, 2, 1);
    final List<List<Integer>> special = new ArrayList<>(List.of(
        List.of(1, 1, 0, 4),
        List.of(2, 2, 1, 9)
    ));
    assertEquals(11, solution.shoppingOffers(price, special, needs));
  }

  @Test
  public void testFailedCase2() throws Exception {
    Solution solution = new DfsMemo();
    final List<Integer> price = List.of(9, 9);
    final List<Integer> needs = List.of(2, 2);
    final List<List<Integer>> special = new ArrayList<>(List.of(
        List.of(1, 1, 1)
    ));
    assertEquals(2, solution.shoppingOffers(price, special, needs));
  }

  @Test
  public void testFailedCase3() {
    Solution solution = new DfsMemoSolutionNotAddingToSpecial();
    final List<Integer> price = List.of(2, 5);
    final List<Integer> needs = List.of(3, 2);
    final List<List<Integer>> special = new ArrayList<>(List.of(
        List.of(3, 0, 5),
        List.of(1, 2, 10)
    ));
    assertEquals(14, solution.shoppingOffers(price, special, needs));
  }

  /**
   * Performance Testing
   *
   * @throws Exception
   */
  @Test
  public void testFailedCase1() throws Exception {
    final List<Integer> price = List.of(4, 7, 9, 9, 3, 2);
    final List<Integer> needs = List.of(6, 6, 6, 6, 6, 6);
    @SuppressWarnings("RedundantTypeArguments (explicit type arguments speedup compilation and analysis time)") final List<List<Integer>> special = new ArrayList<>(List.<List<Integer>>of(
        List.of(0, 0, 4, 6, 2, 0, 22),
        List.of(1, 4, 3, 5, 5, 3, 10),
        List.of(4, 5, 6, 3, 4, 1, 29),
        List.of(0, 3, 2, 2, 4, 2, 4),
        List.of(4, 6, 3, 4, 4, 6, 21),
        List.of(5, 6, 3, 6, 3, 4, 23),
        List.of(6, 1, 3, 4, 6, 2, 9),
        List.of(3, 3, 6, 1, 5, 1, 16),
        List.of(0, 3, 6, 4, 0, 2, 5),
        List.of(5, 1, 2, 3, 5, 5, 7),
        List.of(0, 1, 1, 6, 2, 4, 24),
        List.of(1, 5, 2, 2, 6, 1, 3),
        List.of(4, 2, 2, 4, 3, 1, 8),
        List.of(3, 1, 0, 6, 1, 2, 30),
        List.of(4, 6, 1, 4, 0, 0, 2),
        List.of(0, 4, 5, 6, 2, 5, 1),
        List.of(2, 6, 0, 6, 6, 2, 21),
        List.of(2, 1, 3, 4, 0, 2, 2),
        List.of(6, 4, 4, 4, 1, 3, 24),
        List.of(6, 3, 1, 6, 5, 5, 12),
        List.of(1, 3, 2, 1, 3, 2, 32),
        List.of(2, 2, 0, 3, 1, 2, 16),
        List.of(2, 4, 3, 6, 6, 5, 26),
        List.of(1, 6, 3, 5, 0, 4, 2),
        List.of(6, 2, 1, 5, 6, 2, 9),
        List.of(0, 4, 2, 2, 5, 3, 3),
        List.of(6, 3, 3, 6, 0, 5, 9),
        List.of(4, 3, 2, 5, 3, 3, 29),
        List.of(1, 6, 0, 0, 1, 6, 31),
        List.of(5, 6, 0, 5, 4, 3, 31),
        List.of(0, 4, 2, 6, 0, 6, 28),
        List.of(5, 4, 3, 2, 5, 3, 32),
        List.of(6, 5, 1, 1, 4, 6, 18),
        List.of(3, 3, 3, 2, 3, 3, 2),
        List.of(5, 6, 2, 5, 3, 3, 7),
        List.of(1, 2, 6, 4, 4, 0, 18),
        List.of(0, 4, 4, 0, 0, 3, 18),
        List.of(4, 2, 0, 0, 3, 3, 19),
        List.of(6, 0, 4, 4, 4, 6, 15),
        List.of(6, 2, 3, 0, 2, 2, 4),
        List.of(4, 1, 1, 5, 5, 5, 14),
        List.of(3, 6, 4, 0, 6, 2, 27),
        List.of(2, 4, 6, 2, 2, 3, 24),
        List.of(6, 0, 5, 3, 1, 6, 7),
        List.of(3, 1, 5, 1, 2, 6, 28),
        List.of(5, 2, 2, 1, 1, 4, 25),
        List.of(5, 6, 5, 0, 3, 4, 19),
        List.of(3, 5, 3, 3, 5, 1, 31),
        List.of(6, 0, 1, 1, 6, 4, 14),
        List.of(0, 3, 4, 3, 3, 4, 10),
        List.of(4, 1, 2, 2, 0, 0, 27),
        List.of(2, 2, 1, 3, 5, 2, 24),
        List.of(2, 3, 2, 6, 1, 1, 21),
        List.of(6, 6, 5, 6, 2, 2, 12),
        List.of(6, 6, 3, 1, 0, 6, 28),
        List.of(6, 4, 1, 6, 5, 0, 8),
        List.of(3, 3, 0, 5, 4, 2, 7),
        List.of(4, 3, 3, 3, 0, 2, 25),
        List.of(1, 2, 0, 5, 2, 4, 8),
        List.of(0, 1, 6, 6, 5, 5, 27),
        List.of(3, 6, 4, 5, 2, 2, 4),
        List.of(4, 4, 6, 1, 5, 3, 30),
        List.of(4, 3, 4, 5, 5, 5, 19),
        List.of(0, 0, 0, 6, 1, 0, 27),
        List.of(6, 5, 0, 1, 2, 4, 10),
        List.of(2, 6, 0, 0, 1, 0, 13),
        List.of(4, 1, 6, 1, 4, 1, 24),
        List.of(2, 4, 0, 1, 4, 1, 25),
        List.of(5, 1, 3, 3, 4, 1, 8),
        List.of(5, 5, 1, 0, 2, 1, 25),
        List.of(1, 6, 2, 4, 0, 6, 27),
        List.of(4, 0, 3, 0, 5, 3, 30),
        List.of(2, 4, 6, 6, 3, 2, 4),
        List.of(6, 4, 2, 2, 0, 3, 27),
        List.of(1, 2, 1, 2, 2, 1, 2),
        List.of(2, 0, 3, 0, 5, 4, 4),
        List.of(3, 5, 4, 4, 1, 1, 25),
        List.of(2, 1, 1, 6, 3, 3, 28),
        List.of(4, 4, 4, 3, 6, 3, 21),
        List.of(1, 4, 1, 4, 2, 2, 27),
        List.of(0, 6, 0, 2, 2, 2, 33),
        List.of(3, 3, 5, 6, 4, 6, 9),
        List.of(1, 0, 0, 3, 4, 2, 11),
        List.of(1, 3, 0, 3, 0, 1, 16),
        List.of(2, 3, 0, 0, 0, 5, 1),
        List.of(3, 5, 6, 4, 1, 4, 3),
        List.of(3, 1, 0, 2, 6, 0, 19),
        List.of(3, 0, 0, 5, 3, 1, 6),
        List.of(1, 0, 4, 1, 2, 2, 18),
        List.of(0, 0, 4, 3, 5, 1, 31),
        List.of(4, 4, 2, 5, 5, 2, 2),
        List.of(5, 0, 2, 6, 5, 3, 4),
        List.of(6, 2, 1, 0, 2, 3, 11),
        List.of(4, 5, 1, 5, 3, 3, 23),
        List.of(6, 2, 5, 1, 6, 6, 4),
        List.of(5, 6, 6, 1, 5, 6, 6),
        List.of(3, 2, 6, 1, 4, 5, 19),
        List.of(0, 2, 6, 2, 5, 0, 26),
        List.of(0, 1, 3, 6, 3, 6, 18),
        List.of(3, 5, 4, 6, 5, 3, 6)
    ));
    Solution solution = new DfsMemoSolutionNotAddingToSpecial();
    solution.shoppingOffers(price, special, needs);

    {
      solution = new DfsMemoSolutionNotAddingToSpecial();
      long startTime = System.nanoTime();
      solution.shoppingOffers(price, special, needs);
      long endTime = System.nanoTime();
      System.out.println(solution.getClass().getName() + "Time = " + (endTime - startTime) / 1E6);
    }

    Solution dfsMemoSolution = new DfsMemo();
    long solution2StartTime = System.nanoTime();
    solution.shoppingOffers(price, special, needs);
    long solution2EndTime = System.nanoTime();
    System.out.println(dfsMemoSolution.getClass().getName() + "Time = " + (solution2EndTime - solution2StartTime) / 1E6);

    {
      solution = new DfsMemoSolutionNotAddingToSpecial();
      long startTime = System.nanoTime();
      solution.shoppingOffers(price, special, needs);
      long endTime = System.nanoTime();
      System.out.println(solution.getClass().getName() + "Time = " + (endTime - startTime) / 1E6);
    }
  }

}