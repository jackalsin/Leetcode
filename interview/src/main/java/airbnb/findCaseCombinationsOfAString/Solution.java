package airbnb.findCaseCombinationsOfAString;

import java.util.function.Function;

public interface Solution {
  /**
   * To find if <tt>f</tt> matches a combination of
   *
   * @param src
   * @param f
   * @return
   */
  boolean matchHiddenString(final String src, final Function<String, Boolean> f);
}
