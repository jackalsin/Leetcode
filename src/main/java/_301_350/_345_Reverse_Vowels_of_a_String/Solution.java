package _301_350._345_Reverse_Vowels_of_a_String;

/**
 * @author jacka
 * @version 1.0 on 10/6/2017.
 */
public class Solution {
  public String reverseVowels(String s) {
    char[] chars = s.toCharArray();
    int i = 0, j = chars.length - 1;
    while (i < j) {
      while (i < chars.length - 1 && !isVowel(chars, i)) {
        ++i;
      }
      while (j >= 0 && !isVowel(chars, j)) {
        --j;
      }
      if (i < j && isVowel(chars, i) && isVowel(chars, j)) {
        swap(chars, i++, j--);
      }
    }
    return new String(chars);
  }

  private void swap(char[] chars, int i, int j) {
    char tmp = chars[i];
    chars[i] = chars[j];
    chars[j] = tmp;
  }

  private boolean isVowel(char[] chars, int j) {
    char chrLower = Character.toLowerCase(chars[j]);
    return chrLower == 'a' || chrLower == 'e' || chrLower == 'i'
        || chrLower == 'o' || chrLower == 'u';
  }
}
