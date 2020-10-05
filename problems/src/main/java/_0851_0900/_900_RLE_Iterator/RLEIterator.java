package _0851_0900._900_RLE_Iterator;

public final class RLEIterator {
  private int alreadyUsedCount = 0, currentValueIndex = 1;
  private final int[] A;

  public RLEIterator(int[] A) {
    this.A = A;
  }

  public int next(int n) {
    alreadyUsedCount += n;
    int curCountIndex = currentValueIndex - 1;
    while (curCountIndex < A.length && alreadyUsedCount > A[curCountIndex]) {
      alreadyUsedCount -= A[curCountIndex];
      curCountIndex += 2;
      currentValueIndex += 2;
    }
    return curCountIndex >= A.length ? -1 : A[currentValueIndex];
  }
}
