package example.binarySearch;

import java.util.function.Function;

public final class AdvancedSolution {
  private static final String ERROR_MESSAGE = "All elements in the array don't satisfy the condition.";

  private AdvancedSolution() {
  }

  /**
   * Return the index of the first occurrence of an element in <code>nums</code> that is greater than or equals to
   * the <code>lowerBoundary</code>
   *
   * @param nums          an sorted array
   * @param lowerBoundary lower boundary
   * @return
   */
  public static int lowerBoundary(final int[] nums, final int lowerBoundary) {
    if (nums == null) {
      throw new NullPointerException();
    }
    if (nums.length == 0) {
      throw new IllegalArgumentException("The length of nums cannot be zero.");
    }

    int left = 0, right = nums.length - 1;
    while (left < right) {
      int mid = (right - left) / 2 + left;
      if (nums[mid] < lowerBoundary) {
        left = mid + 1;
      } else {
        right = mid;
      }
//      if (nums[mid] >= lowerBoundary) {
//        right = mid;
//      } else {
//        left = mid + 1;
//      }
    }
    return left;
  }

  /**
   * Return the index of the last occurrence of an element in <code>nums</code> that is smaller than or equals to
   * the <code>upperBoundary</code>
   *
   * @param nums          an sorted array
   * @param upperBoundary lower boundary
   * @return
   */
  public static int upperBoundary(final int[] nums, final int upperBoundary) {
    if (nums == null) {
      throw new NullPointerException();
    }
    if (nums.length == 0) {
      throw new IllegalArgumentException("The length of nums cannot be zero.");
    }

    int left = 0, right = nums.length - 1;
    while (left < right) {
      int mid = (right - left + 1) / 2 + left;
      if (nums[mid] <= upperBoundary) {
        left = mid;
      } else {
        right = mid - 1;
      }
    }
    return left;
  }

  public static int binarySearchFirstOccurrence(final int[] nums, Function<Integer, Boolean> isSatisfied) {
    return binarySearchFirstOccurrence(nums, isSatisfied, arrayLength -> {
      throw new IllegalStateException(ERROR_MESSAGE);
    });
  }

  public static int binarySearchFirstOccurrence(final int[] nums, Function<Integer, Boolean> isSatisfied,
                                                Function<Integer, Integer> allFalseErrorHandling) {
    if (nums == null) {
      throw new NullPointerException();
    }
    if (nums.length == 0) {
      return allFalseErrorHandling.apply(nums.length);
    }

    int left = 0, right = nums.length - 1;
    while (left < right) {
      int mid = (right - left) / 2 + left;
      if (isSatisfied.apply(nums[mid])) {
        right = mid;
      } else {
        left = mid + 1;
      }
    }

    // all element doesn't satisfy the condition
    if (!isSatisfied.apply(nums[left])) {
      return allFalseErrorHandling.apply(nums.length);
    }
    return left;
  }


  public static int binarySearchLastOccurrence(final int[] nums, Function<Integer, Boolean> isSatisfied) {
    return binarySearchLastOccurrence(nums, isSatisfied, arrayLength -> {
      throw new IllegalStateException(ERROR_MESSAGE);
    });
  }

  public static int binarySearchLastOccurrence(final int[] nums, Function<Integer, Boolean> isSatisfied,
                                               Function<Integer, Integer> allFalseErrorHandling) {
    if (nums == null) {
      throw new NullPointerException();
    }
    if (nums.length == 0) {
      return allFalseErrorHandling.apply(nums.length);
    }

    int left = 0, right = nums.length - 1;
    while (left < right) {
      int mid = (right - left + 1) / 2 + left;
      if (isSatisfied.apply(nums[mid])) {
        left = mid;
      } else {
        right = mid - 1;
      }
    }

    // all element doesn't satisfy the condition
    if (!isSatisfied.apply(nums[left])) {
      return allFalseErrorHandling.apply(nums.length);
    }
    return left;
  }
}
