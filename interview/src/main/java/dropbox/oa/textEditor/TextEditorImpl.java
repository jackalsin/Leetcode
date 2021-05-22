package dropbox.oa.textEditor;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;

/**
 * @author jacka
 * @version 1.0 on 5/20/2021
 */
public final class TextEditorImpl implements TextEditor {
  private static final String APPEND = "APPEND", BACKSPACE = "BACKSPACE",
      UNDO = "UNDO", REDO = "REDO", SELECT = "SELECT", BOLD = "BOLD";
  private final StringBuilder sb = new StringBuilder();
  private int selectStart = -1, selectEnd = -1;
  private final Deque<String> undoStack = new ArrayDeque<>(),
      redoStack = new ArrayDeque<>();

  @Override
  public String getOutput(String[][] operations) {
    if (operations == null || operations.length == 0) return sb.toString();
    Arrays.sort(operations, Comparator.comparingLong(a -> Long.parseLong(a[0])));
    String prevOp = null;
    for (final String[] operation : operations) {
      switch (operation[1]) {
        case APPEND:
          append(operation[2]);
          break;
        case BACKSPACE:
          backspace();
          break;
        case UNDO:
          undo();
          break;
        case REDO:
          if (APPEND.equals(prevOp) || BACKSPACE.equals(prevOp)) {
            redoStack.clear();
          }
          redo();
          break;
        case SELECT:
          select(operation[2], operation[3]);
          break;
        case BOLD:
          bold();
          break;
      }

      prevOp = operation[1];
    }
    return sb.toString();
  }

  private void append(final String str) {
    undoStack.push(sb.toString());
    int insertPoint = sb.length();
    if (selectStart != -1) {
      assert selectEnd != -1;
      insertPoint = selectStart;
      sb.delete(selectStart, selectEnd);
    }
    sb.insert(insertPoint, str);
  }

  private void backspace() {
    undoStack.push(sb.toString());
    if (selectStart != -1) {
      assert selectEnd != -1;
      sb.delete(selectStart, selectEnd);
    } else {
      final int len = sb.length();
      if (len != 0) sb.setLength(len - 1);
    }
  }

  private void undo() {
    if (undoStack.isEmpty()) return;
    final String prev = undoStack.pop();
    redoStack.push(sb.toString());
    sb.setLength(0);
    sb.append(prev);
  }

  private void redo() {
    if (redoStack.isEmpty()) return;
    final String prev = redoStack.pop();
    sb.setLength(0);
    sb.append(prev);
  }

  private void select(final String startStr, final String endStr) {
    selectStart = Integer.parseInt(startStr);
    selectEnd = Integer.parseInt(endStr);
  }

  private void bold() {
    sb.insert(selectEnd, '*');
    sb.insert(selectStart, '*');
  }

  private void resetSelect() {
    selectStart = -1;
    selectEnd = -1;
  }
}
