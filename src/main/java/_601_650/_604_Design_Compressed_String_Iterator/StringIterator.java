package _601_650._604_Design_Compressed_String_Iterator;

public class StringIterator {
  private final String string;

  private int count = 0;
  private char curChar = ' ';

  /* String pointer after move */
  private int curPointer = 0;

  public StringIterator(String compressedString) {
    string = compressedString;

  }

  private void updateTheNextPart() {
    if (curPointer == string.length()) return;
    curChar = string.charAt(curPointer++);
    count = 0;
    while (curPointer < string.length() && Character.isDigit(string.charAt(curPointer))) {
      count = count * 10 + string.charAt(curPointer++) - '0';
    }
    // manually add to optimize
  }

  public char next() {
    if (count == 0) {
      updateTheNextPart();
    }

    if (hasNext()) {
      count--;
      return curChar;
    } else {
      return ' ';
    }
  }

  public boolean hasNext() {
    return count > 0 || curPointer != string.length();
  }
}
