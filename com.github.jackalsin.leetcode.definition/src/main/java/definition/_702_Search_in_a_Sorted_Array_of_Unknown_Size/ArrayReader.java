package definition._702_Search_in_a_Sorted_Array_of_Unknown_Size;

public final class ArrayReader {
  private final int[] elems;


  public ArrayReader(int[] elems) {
    if (elems == null) {
      throw new NullPointerException();
    }

    for (int elem : elems) {
      if (elem < -9999 || elem > 9999) {
        throw new IllegalArgumentException("element in elems should be [-9999, 9999], but got " + elem);
      }
    }

    this.elems = new int[elems.length];
    System.arraycopy(elems, 0, this.elems, 0, elems.length);
  }


  /**
   * However, the array size is unknown to you. You may only access the array using an ArrayReader interface, where ArrayReader.get(k) returns the element of the array at index k (0-indexed).
   * <p>
   * You may assume all integers in the array are less than 10000, and if you access the array out of bounds, ArrayReader.get will return 2147483647.
   *
   * @return
   */
  public int get(int i) {
    if (i < 0) {
      throw new IndexOutOfBoundsException();
    }

    if (i >= elems.length) {
      return 2147483647;
    }

    return elems[i];
  }
}
