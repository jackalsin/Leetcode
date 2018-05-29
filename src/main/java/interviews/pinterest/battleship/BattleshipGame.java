package interviews.pinterest.battleship;

import java.util.Arrays;

public final class BattleshipGame {

  public static final char X = 'X', UNCOVER = '*', SHIP = 'S', HIT = 'H', MISS = 'M';

  private final int rows, cols, playerNum;

  private final char[][][] boards;
  private final Player[] players;

  private int curPlayerId = 0;

  public BattleshipGame(final int rows, final int cols, final int playerNum) {
    this.rows = rows;
    this.cols = cols;
    this.playerNum = playerNum;
    boards = new char[playerNum][rows][cols];
    for (final char[][] board : boards) {
      for (final char[] chars : board) {
        Arrays.fill(chars, UNCOVER);
      }
    }
    // init player
    players = new Player[playerNum];
    for (int i = 0; i < playerNum; i++) {
      players[i] = new Player();
    }
  }

  /**
   * @param playerId
   * @param ship
   */
  public void place(final int playerId, final Battleship ship) {
    final char[][] board = boards[playerId - 1];
    place(ship, board, ship.getStartRow(), ship.getStartCol());
    players[playerId - 1].addShip(ship);
  }

  private void place(final Battleship ship, final char[][] board, final int startRow, final int startCol) {
    final int length = ship.getLength();
    if (!isInRange(startRow, startCol)) {
      throw new IllegalArgumentException(
          String.format("row = %d col = %d length = %d isVertical = %b cannot be placed on board",
              startRow, startCol, length, ship.isVertical()));
    }
    final int nextRow = startRow + (ship.isVertical() ? (length - 1) : 0), nextCol = startCol + (ship.isVertical() ? 0 : (length - 1));
    if (!isInRange(nextRow, nextCol)) {
      throw new IllegalArgumentException(
          String.format("row = %d col = %d length = %d isVertical = %b cannot be placed on board",
              startRow, startCol, length, ship.isVertical()));
    }

    for (int row = startRow; row <= nextRow; row++) {
      for (int col = startCol; col <= nextCol; col++) {
        if (board[row][col] == UNCOVER) { // no boat
          board[row][col] = SHIP;
        } else {
          throw new IllegalArgumentException(
              String.format("row = %d col = %d length = %d ship.isVertical() = %b cannot be placed on board", row, col, length, ship.isVertical())
          );
        }
      }
    }
  }

  /**
   * @param row
   * @param col
   * @return
   */
  public void fire(final int row, final int col) {
    final char[][] board = boards[curPlayerId];
    final Player curPlayer = players[curPlayerId];
    switchPlayer();
    fireUpdateBoard(board, curPlayer, row, col);
  }

  private void fireUpdateBoard(final char[][] board, final Player player, final int startRow, final int startCol) {
    // update the board
    if (!isInRange(startRow, startCol) && board[startRow][startCol] == UNCOVER) {
      throw new IllegalArgumentException();
    }
    final boolean res = board[startRow][startCol] == SHIP;
    board[startRow][startCol] = res ? HIT : MISS;

    // update the player
    if (res) {
      player.decreaseLive();
    }
  }

  /**
   * @return player id when he's the winner, otherwise 0;
   */
  public int winner() {
    for (int i = 0; i < players.length; i++) {
      if (players[i].isDead()) {
        final int winner = (i + 1) / playerNum;
        System.out.println("Player " + winner + "wins");
        return winner;
      }
    }
    return 0;
  }

  /**
   * Display board
   */
  public void displayBoards() {
    for (int i = 0; i < playerNum; i++) {
      System.out.println("===================== Player " + (i + 1) + "=====================");
      displayBoard(boards[i]);
    }
  }

  private void displayBoard(char[][] board) {
    for (final char[] chars : board) {
      System.out.println(Arrays.toString(chars));
    }
  }

  private boolean isInRange(final int row, final int col) {
    return 0 <= row && row < rows && 0 <= col && col < cols;
  }

  private void switchPlayer() {
    curPlayerId++;
    curPlayerId = curPlayerId % playerNum;
  }

}
