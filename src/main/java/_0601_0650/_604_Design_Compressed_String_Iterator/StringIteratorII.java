package _0601_0650._604_Design_Compressed_String_Iterator;

public final class StringIteratorII implements StringIterator {
  private final String str;
  private int remain = 0, ptr = 0;
  private char curChar = ' ';

  public StringIteratorII(String compressedString) {
    str = compressedString;
  }

  public char next() {
    if (!hasNext()) {
      return ' ';
    }
    if (remain == 0) {
      curChar = str.charAt(ptr);
      remain = str.charAt(++ptr) - '0';
      while (ptr + 1 < str.length() && Character.isDigit(str.charAt(ptr + 1))) {
        remain = remain * 10 + str.charAt(ptr + 1) - '0';
        ptr++;
      }
      ptr++;
    }
    remain--;
    return curChar;
  }

  public boolean hasNext() {
    return !(ptr == str.length() && remain == 0);
  }
}
