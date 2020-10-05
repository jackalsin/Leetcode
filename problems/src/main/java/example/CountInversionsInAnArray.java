package example;

/**
 * @author jacka
 * @version 1.0 on 9/26/2017.
 */
public final class CountInversionsInAnArray {

  /**
   * Return the inversion counts in <em>array</em>.
   *
   * Inversion Count for an array indicates – how far (or close) the array is from being sorted. If array is already sorted then inversion count is 0. If array is sorted in reverse order that inversion count is the maximum.
   * Formally speaking, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j
   *
   * Example:
   * The sequence 2, 4, 1, 3, 5 has three inversions (2, 1), (4, 1), (4, 3).
   *
   * http://www.geeksforgeeks.org/counting-inversions/
   *
   * @param array
   * @return
   */
  public int getInvCount(int[] array) {
    return getInvCount(array, 0, array.length - 1);
  }
  private int getInvCount(int[] array, int start, int end) {
    int mid = (end - start) / 2 + start, count = 0;
    if (start < end) {
      count += getInvCount(array, start, mid);
      count += getInvCount(array, mid + 1, end);
      count += merge(array, start, mid + 1, end);
    }
    return count;
  }

  /**
   *
   * @param array
   * @param leftStart   inclusive
   * @param rightStart  inclusive
   * @param end         inclusive
   * @return  the count of count inversion counts
   */
  private int merge(final int[] array, final int leftStart, final int rightStart, final int end) {
    int left = leftStart, right = rightStart, k = leftStart, count = 0;
    final int[] aux = new int[array.length];
    while (left < rightStart && right <= end) {
      if (array[left] <= array[right]) {
        aux[k++] = array[left++];
      } else {
        aux[k++] = array[right++];
        count += (rightStart - left);
      }
    }
    System.arraycopy(array, left, aux, k, rightStart - left);
    System.arraycopy(array, right, aux, k, end - right + 1);
    System.arraycopy(aux, leftStart, array, leftStart, end - leftStart + 1);
    return count;
  }

}
