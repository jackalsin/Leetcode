package definition;

import java.util.Arrays;

/**
 * @author jacka
 * @version 1.0 on 2/28/2017.
 */
public final class FloatRuleExample {
  public static void main(String[] args) {
    System.out.println(3 / 2);

    System.out.println(Integer.MAX_VALUE + " * 8 bits");
    System.out.println(Integer.MAX_VALUE / 1024 / 1024 * 8 + " MB");
    System.out.println(0.0 == -0.0);
    System.out.println(Integer.MAX_VALUE);

    int[] original = new int[]{42};
    changeRefOfNum(original);
    System.out.println(Arrays.toString(original));
  }

  private static void changeRefOfNum(int[] array) {
    array = new int[]{233};
  }
}
