package linkedin._464_Can_I_Win;

/**
 * @author jacka
 * @version 1.0 on 10/23/2017.
 */
public interface Solution {
  // TODO: Revisit
  boolean canIWin(int maxChoosableInteger, int desiredTotal);

  default void display(final boolean[] array) {
    for (int i = 0; i < array.length; i++) {
      System.out.println("usedInteger[" + i + "] = " + array[i]);
    }
  }
}
