package interviews.google._686_Repeated_String_Match;

/**
 * @author jacka
 * @version 1.0 on 1/29/2018.
 */
public final class KMPSolution implements Solution {
  public int repeatedStringMatch(String a, String b) {
//    final int[] prefTable = new int[b.length() + 1]; // 1-based to avoid extra checks.
//    for (int sp = 1, pp = 0; sp < b.length(); prefTable[++sp] = pp) {
//      pp = b.charAt(pp) == b.charAt(sp) ? pp + 1 : prefTable[pp];
//    }
//    System.out.println(Arrays.toString(prefTable));
//    for (int i = 0, j = 0; i < a.length(); i += Math.max(1, j - prefTable[j]), j = prefTable[j]) {
//      while (j < b.length() && a.charAt((i + j) % a.length()) == b.charAt(j)) {
//        ++j;
//      }
//      if (j == b.length()) {
//        return (i + j) / a.length() + ((i + j) % a.length() != 0 ? 1 : 0);
//      }
//    }
//    return -1;

    return repeat(a, b);
  }

  int[] getNext(final String a) {
    final int[] next = new int[a.length() + 1];
    for (int sp = 1, pp = 0; sp < a.length(); sp++) {
      pp = a.charAt(sp) == a.charAt(pp) ? pp + 1 : next[pp];
      next[sp + 1] = pp;
    }
    return next;
  }

  public int repeat(final String a, final String b) {
    final int[] next = getNext(b);
    for (int i = 0, j = 0; i < a.length(); i++, j = next[j]) {
      while (j < b.length() && a.charAt((i + j) % a.length()) == b.charAt(j)) {
        j++;
      }

      if (j == b.length()) {
        return (j + i) % a.length() == 0 ? (i + j) / a.length() : ((i + j) / a.length() + 1);
      }
    }
    return -1;
  }
}
