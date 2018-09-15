package _701_750._748_Shortest_Completing_Word;

public final class PrimeSolution implements Solution {

  private static final int[] PRIMES = {
      2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103
  };

  public String shortestCompletingWord(String licensePlate, String[] words) {
    final long plateProduct = getCharProduct(licensePlate);
    int minLen = Integer.MAX_VALUE;
    String minStr = "";
    for (String word : words) {
      if (word.length() < minLen && getCharProduct(word) % plateProduct == 0) {
        minLen = word.length();
        minStr = word;
      }
    }

    return minStr;
  }

  private static long getCharProduct(final String str) {
    long res = 1;
    for (char chr : str.toCharArray()) {
      if (Character.isAlphabetic(chr)) {
        final int i = Character.toLowerCase(chr) - 'a';
        res *= PRIMES[i];
      }
    }
    return res;
  }
}
