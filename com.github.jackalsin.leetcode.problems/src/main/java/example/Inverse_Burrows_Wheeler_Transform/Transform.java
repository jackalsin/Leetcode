package example.Inverse_Burrows_Wheeler_Transform;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author jacka
 * @version 1.0 on 1/7/2018.
 */
public final class Transform {
  public static String encode(final String raw) {
    final int n = raw.length();
    final Rotation[] suffixArray = new Rotation[raw.length()];
    for (int i = 0; i < raw.length(); i++) {
      suffixArray[i] = new Rotation(i, raw.substring(i));
    }

    Arrays.sort(suffixArray, new Comparator<Rotation>() {
      @Override
      public int compare(Rotation o1, Rotation o2) {
        return o1.suffix.compareTo(o2.suffix);
      }
    });
//    we want the last column
//    banana$                    $banana
//    $banana                    a$banan
//    a$banan       Sorting      ana$ban
//    na$bana      ---------->   anana$b
//    ana$ban    alphabetically  banana$
//    nana$ba                    na$bana
//    anana$b                    nana$ba
//
    // the suffix we extract
//    0 banana$                6 $
//    1 anana$                 5 a$
//    2 nana$      Sorting     3 ana$
//    3 ana$     ---------->   1 anana$
//    4 na$     alphabetically 0 banana$
//    5 a$                     4 na$
//    6 $                      2 nana$
    final StringBuilder sb = new StringBuilder();
    for (final Rotation rotation : suffixArray) {
      sb.append(raw.charAt((rotation.index - 1 + n) % n));
    }
    return sb.toString();
  }

  /**
   * The algorithm introduction
   * https://www.coursera.org/learn/algorithms-on-strings/lecture/C0opC/inverting-burrows-wheeler
   * -transform
   */
  public static String decode(final String input) {
//    char[] inputArr = input.toCharArray();
//    int[] translate = new int[inputArr.length];
//    int[] sums = new int[IHuffConstants.ALPH_SIZE + 1];
//    for(int k=0; k < inputArr.length; k++){
//      sums[inputArr[k]+1]++;
//    }
//    for(int k=1; k < sums.length; k++){
//      sums[k] += sums[k-1];
//    }
//    for(int k=0; k < inputArr.length; k++){
//      int index = sums[inputArr[k]]++;
//      translate[index] = k;
//    }
//    char[] reconstruct = new char[inputArr.length];
//    for (int k = 0; k <inputArr.length; k++) {
//      first = translate[first];
//      reconstruct[k] = inputArr[first];
//    }
//    return reconstruct;
    return null;
  }


  private static final class Rotation {
    private final int index;

    private final String suffix;

    public Rotation(int index, String suffix) {
      this.index = index;
      this.suffix = suffix;
    }

  }
}
