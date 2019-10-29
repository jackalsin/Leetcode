package _0551_0600._555_Split_Concatenated_Strings;

/**
 * @author jacka
 * @version 1.0 on 10/27/2019
 */
public final class SolutionI implements Solution {

  @Override
  public String splitLoopedString(String[] strs) {
    // create an array 都是最大的string
    for (int i = 0; i < strs.length; i++) {
      String rev = new StringBuilder(strs[i]).reverse().toString();
      if (strs[i].compareTo(rev) < 0)
        strs[i] = rev;
    }
    String res = "";
    for (int i = 0; i < strs.length; i++) {
      String rev = new StringBuilder(strs[i]).reverse().toString();
      for (String st : new String[]{strs[i], rev}) {
        for (int k = 0; k < st.length(); k++) {
          StringBuilder t = new StringBuilder(st.substring(k));
          for (int j = i + 1; j < strs.length; j++)
            t.append(strs[j]);
          for (int j = 0; j < i; j++)
            t.append(strs[j]);
          t.append(st.substring(0, k));
          if (t.toString().compareTo(res) > 0)
            res = t.toString();
        }
      }
    }
    return res;
  }
}
