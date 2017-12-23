package _601_650._604_Design_Compressed_String_Iterator;

public class StringIterator {
  private final String string;

  /* count limit now */
  private int count = 0;

  private int curCount = 0;
  private char curChar = ' ';

  /* String pointer after move */
  private int curPointer = 0;

  public StringIterator(String compressedString) {
    string = compressedString;

    updateTheNextPart();
  }

  private void updateTheNextPart() {
    if (curPointer == string.length()) return;
    curChar = string.charAt(curPointer++);
    final int start = curPointer;
    count = 0;
    while (curPointer < string.length() && Character.isDigit(string.charAt(curPointer))) {
      count = count * 10 + string.charAt(curPointer++) - '0';
    }
    // manually add to optimize
//    count = Integer.parseInt(string.substring(start, curPointer));
    curCount = 0;
  }

  public char next() {
    if (curCount == count) {
      updateTheNextPart();
    }

    if (hasNext()) {
      curCount++;
      return curChar;
    } else {
      return ' ';
    }
  }

  public boolean hasNext() {
    if (curCount == count) {
      updateTheNextPart();
    }
    return curCount < count || curPointer != string.length();
  }
}
