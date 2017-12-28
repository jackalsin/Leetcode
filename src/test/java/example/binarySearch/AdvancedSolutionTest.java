package example.binarySearch;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AdvancedSolutionTest {

  //  test of lower boundary
  @Test
  public void testLowerBoundary2Elements() {
    final int[] nums = {1, 3};
    assertEquals(1, AdvancedSolution.lowerBoundary(nums, 2));
    // test Generic
    assertEquals(1, AdvancedSolution.binarySearchFirstOccurrence(nums, midVal -> Integer.compare(midVal, 2) >= 0));
    assertEquals(1, AdvancedSolution.lowerBoundary(nums, 3));
    assertEquals(1, AdvancedSolution.binarySearchFirstOccurrence(nums, midVal -> Integer.compare(midVal, 3) >= 0));
  }

  @Test
  public void testLowerBoundaryDuplicate() {
    final int[] nums = {1, 3, 3, 3, 5};
    assertEquals(1, AdvancedSolution.lowerBoundary(nums, 2));
    // test Generic
    assertEquals(1, AdvancedSolution.binarySearchFirstOccurrence(nums, midVal -> Integer.compare(midVal, 2) >= 0));
    assertEquals(1, AdvancedSolution.lowerBoundary(nums, 3));
    assertEquals(1, AdvancedSolution.binarySearchFirstOccurrence(nums, midVal -> Integer.compare(midVal, 3) >= 0));

  }

  // test of upper boundary
  @Test
  public void testUpperBoundary2Elements() {
    final int[] nums = {1, 3};
    assertEquals(0, AdvancedSolution.upperBoundary(nums, 2));
    assertEquals(0, AdvancedSolution.upperBoundary(nums, 1));

  }

  @Test
  public void testUpperBoundaryWithDuplicate() {
    final int[] nums = {1, 3, 3, 3, 5};
    assertEquals(3, AdvancedSolution.upperBoundary(nums, 3));
    assertEquals(3, AdvancedSolution.upperBoundary(nums, 4));

  }

  @Test
  public void testUpperBoundaryWithDuplicate2() {
    final int[] nums = {1, 3, 3, 3, 3, 5};
    assertEquals(4, AdvancedSolution.upperBoundary(nums, 3));
    assertEquals(0, AdvancedSolution.upperBoundary(nums, 1));

  }

  // test of generic solution
  @Test
  public void testGenericSolutionForUpperBoundary2Elements() {
    final int[] nums = {1, 3};
    assertEquals(0, AdvancedSolution.binarySearchLastOccurrence(nums, x -> Integer.compare(x, 2) <= 0));
    assertEquals(0, AdvancedSolution.binarySearchLastOccurrence(nums, x -> Integer.compare(x, 1) <= 0));

  }

  @Test
  public void testGenericSolutionForUpperBoundaryWithDuplicate() {
    final int[] nums = {1, 3, 3, 3, 5};
    assertEquals(3, AdvancedSolution.binarySearchLastOccurrence(nums, x -> Integer.compare(x, 3) <= 0));
    assertEquals(3, AdvancedSolution.binarySearchLastOccurrence(nums, x -> Integer.compare(x, 4) <= 0));

  }

  @Test
  public void testGenericSolutionForUpperBoundaryWithDuplicate2() {
    final int[] nums = {1, 3, 3, 3, 3, 5};
    assertEquals(4, AdvancedSolution.binarySearchLastOccurrence(nums, x -> Integer.compare(x, 3) <= 0));
    assertEquals(0, AdvancedSolution.binarySearchLastOccurrence(nums, x -> Integer.compare(x, 1) <= 0));

  }
}