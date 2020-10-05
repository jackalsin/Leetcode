package pinterest.battleship;

public final class Battleship {
  static final int CARRIER_SIZE = 5, BATTLESHIP_SIZE = 4, CRUISER_SIZE = 3, SUBMARINE_SIZE = 3,
      DESTROYER_SIZE = 2;

  static final String CARRIER_NAME = "Carrier", BATTLESHIP_NAME = "Battleship", CRUISER_NAME = "Cruiser",
      SUBMARINE_NAME = "Submarine", DESTROYER_NAME = "Destroyer";

  private final String name;

  private final int startRow, startCol, length;

  private final boolean isVertical;

  public Battleship(final String name, int row, int col, int length, boolean isVertical) {
    this.name = name;
    startRow = row;
    startCol = col;
    this.length = length;
    this.isVertical = isVertical;
  }

  public int getLength() {
    return length;
  }

  public String getName() {
    return name;
  }

  public boolean isVertical() {
    return isVertical;
  }

  public int getStartRow() {
    return startRow;
  }

  public int getStartCol() {
    return startCol;
  }

}
