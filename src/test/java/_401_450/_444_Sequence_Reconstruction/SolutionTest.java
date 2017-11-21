package _401_450._444_Sequence_Reconstruction;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new TopologicalSortSolution();
//    solution = new ArraySolution();
  }

  @Test
  public void testOnlineCase1() throws Exception {
    final int[] org = {1, 2, 3};
    final List<List<Integer>> seqs = List.of(List.of(1, 2), List.of(1, 3));
    assertFalse(solution.sequenceReconstruction(org, seqs));

  }

  @Test
  public void testOnlineCase2() throws Exception {
    final int[] org = {1, 2, 3};
    final List<List<Integer>> seqs = List.of(List.of(1, 2));
    assertFalse(solution.sequenceReconstruction(org, seqs));

  }

  @Test
  public void testOnlineCase3() throws Exception {
    final int[] org = {1, 2, 3};
    final List<List<Integer>> seqs = List.of(List.of(1, 2), List.of(2, 3), List.of(1, 3));
    assertTrue(solution.sequenceReconstruction(org, seqs));

  }

  @Test
  public void testOnlineCase4() throws Exception {
    final int[] org = {4, 1, 5, 2, 6, 3};
    final List<List<Integer>> seqs = List.of(List.of(5, 2, 6, 3), List.of(4, 1, 5, 2));
    assertTrue(solution.sequenceReconstruction(org, seqs));

  }

  @Test
  public void testFailedCase1() throws Exception {
    final int[] org = {1, 2, 3, 4, 5};
    final List<List<Integer>> seqs = List.of(
        List.of(1, 2, 3, 4, 5),
        List.of(1, 2, 3, 4),
        List.of(1, 2, 3),
        List.of(1),
        List.of(4),
        List.of(5)
    );
    assertTrue(solution.sequenceReconstruction(org, seqs));

  }

  /**
   * Check if there is a cycle.
   *
   * @throws Exception
   */
  @Test
  public void testFailedCase2() throws Exception {
    final int[] org = {1};
    final List<List<Integer>> seqs = List.of(
        List.of(1),
        List.of(2, 3),
        List.of(3, 2)
    );
    assertFalse(solution.sequenceReconstruction(org, seqs));
  }

  @Test
  public void testFailedCheckCompare() throws Exception {
    final int[] org = {1, 2, 3};
    final List<List<Integer>> seqs = List.of(
        List.of(1, 7),
        List.of(7, 3)
    );

    assertFalse(solution.sequenceReconstruction(org, seqs));
  }

  @Test
  public void testFailedOnEmpty() throws Exception {
    final int[] org = {1};
    final List<List<Integer>> seqs = List.of(
        List.of(),
        List.of()
    );

    assertFalse(solution.sequenceReconstruction(org, seqs));
  }

  @Test
  public void testFailedOnEmpty2() throws Exception {
    final int[] org = {1};
    final List<List<Integer>> seqs = List.of(
        List.of(1),
        List.of()
    );

    assertTrue(solution.sequenceReconstruction(org, seqs));
  }
}